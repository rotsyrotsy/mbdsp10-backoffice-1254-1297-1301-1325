package com.itu.mbds

import com.mongodb.BasicDBObject
import com.mongodb.client.model.Accumulators
import com.mongodb.client.model.Aggregates
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Projections
import grails.plugin.springsecurity.annotation.Secured
import org.bson.Document
import org.bson.conversions.Bson

import java.text.SimpleDateFormat


@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])
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
            //dailyTransactions << globalService.docToMap(doc)
            dailyTransactions << doc.toJson()
        }

        def totalUsers = User.countByRole([Role.get(3)])
        def totalTransactions = todayTransactions.size()
        respond exchangeList,model:[transactionList: transactionList,totalUsers:totalUsers, totalTransactions:totalTransactions, dailyTransactions:dailyTransactions]
    }
}
