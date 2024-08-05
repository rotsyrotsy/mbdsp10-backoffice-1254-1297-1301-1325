package com.itu.mbds

import com.mongodb.client.model.Accumulators
import com.mongodb.client.model.Aggregates
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Projections
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.JsonSlurper
import org.bson.Document


@Secured(['ROLE_ADMIN','ROLE_SUPER_ADMIN'])
class DashboardController {
    ExchangeService exchangeService
    TransactionService transactionService
    GlobalService globalService

    def index() {
        params.max = Math.min(10, 100)
        params.sort = "creationDate"
        params.order = "desc"
        def exchangeList = exchangeService.list(params)
        params.sort = "creation_date"
        def transactionList = transactionService.list(params)

        def criteria = Transaction.createCriteria()
        // Query using GORM criteria
        def todayTransactions =  criteria.list {
            between('creation_date', globalService.getStartOfDay(), globalService.getEndOfDay())
            ne('status', 'PENDING')  // 'ne' for not equal
        }

        List<Map> dailyTransactions = []
        Transaction.collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("status", "ACCEPTED")),
                        // Project creation_date as a formatted date string
                        Aggregates.project(Projections.fields(
                                Projections.computed("date", new Document("\$dateToString", new Document("format", "%Y-%m-%d").append("date", "\$creation_date"))),
                                Projections.excludeId()
                        )),
                        // Group by the formatted date and count the number of occurrences
                        Aggregates.group("\$date", Accumulators.sum("count", 1)),
                        // Sort the results by the date
                        Aggregates.sort(new Document("_id", 1))
                ).collect { it.toBsonDocument() }
        ).forEach { doc ->
            dailyTransactions << doc.toJson()
        }
        List<Map> mapTransactionList = []
        Transaction.collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("status", "PENDING")),
                        Aggregates.group(new Document("latitude", "\$latitude").append("longitude", "\$longitude"),
                                Accumulators.sum("count", 1)),
                        Aggregates.sort(new Document("_id", 1))
                ).collect { it.toBsonDocument() }
        ).forEach { doc ->
            mapTransactionList << new JsonSlurper().parseText(doc.toJson())
        }
        for(int i =0; i<mapTransactionList.size(); i++){
            def transaction = mapTransactionList[i]
            def x1 = transaction._id
            println(i)
            for(int ii =0; ii<mapTransactionList.size(); ii++) {
                def transaction2 = mapTransactionList[ii]
                def x2 = transaction2._id
                println("ii : ${ii}")
                if (x1 != x2) {
                    double distance = globalService.haversineDistance(x1.latitude, x1.longitude, x2.latitude, x2.longitude)
                    if (distance <= 1) { // 1000 meters = 1 km
                        transaction.count += transaction.count
                        mapTransactionList.removeIf { it._id.latitude == transaction2._id.latitude && it._id.longitude == transaction2._id.longitude }
                    }
                }
            }
        }
        def totalUsers = User.countByRole([Role.get(3)])
        def totalTransactions = todayTransactions.size()
        respond exchangeList,model:[transactionList: transactionList,totalUsers:totalUsers, totalTransactions:totalTransactions, dailyTransactions:dailyTransactions, mapTransactions : mapTransactionList]

    }
}
