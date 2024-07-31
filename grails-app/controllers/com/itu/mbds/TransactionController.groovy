package com.itu.mbds

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import grails.plugin.springsecurity.annotation.Secured
import org.hibernate.criterion.CriteriaSpecification

@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])

class TransactionController implements GrailsConfigurationAware {
    String csvMimeType
    String encoding
    TransactionService transactionService
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.sort = "creation_date"
        params.order = "desc"
        def transactionList = flash.search ? flash.searchResults : transactionService.list(params)
        def transactionCount = flash.search ? flash.searchResults.size() : transactionService.count()
        respond transactionList, model:[transactionCount: transactionCount]
    }
    def search() {
        def searchParams = params
        def keyword = searchParams.keyword
        def state = searchParams.state?.toUpperCase()
        def maxResults = Math.min(searchParams.max ?: 10, 100)
        def sortOrder = -1

        List<Integer> userIds = []
        if (keyword) {
            def users = User.findAllByUsernameLike("%${keyword}%")
            userIds = users.collect { it.id }
        }
        def transactionQuery = [
                '$or': [
                        [owner_id: ['$in': userIds]],
                        [taker_id: ['$in': userIds]]
                ]
        ]
        if (state) {
            transactionQuery['state'] = state
        }
        def transactionsCursor = Transaction.collection.find(transactionQuery)
                .sort([creation_date: sortOrder])
                .limit(maxResults)
        def results = transactionsCursor.toList()
        flash.searchResults = results
        flash.searchParams = searchParams
        flash.search = true
        redirect(action: 'index',  params: searchParams)
    }
    def exportCsv(){
        final String filename = 'transactions.csv'
        def header = ["Owner Username", "Owner Products", "Taker Username", "Taker Products", "Creation Date", "Status"]
        def headerLine = header.join(';')
        def lines = Transaction.findAll().collect{ transaction ->
            def ownerProducts = transaction.exchange.ownerProposition.getProducts().collect { product ->
                product.productName
            }.join(', ')

            def takerProducts = transaction.exchange.takerProposition.getProducts().collect { product ->
                product.productName
            }.join(', ')
            [
                    transaction.exchange.ownerProposition.user.username,
                    ownerProducts,
                    transaction.exchange.takerProposition.user.username,
                    takerProducts,
                    transaction.creation_date,
                    transaction.status
            ]
            .join(';')
        }
        def sortedLines = lines.sort { it.split(';')[4] }
        def csvContent = [headerLine] + sortedLines
        def outs = response.outputStream
        response.status = 200
        response.contentType = "${csvMimeType};charset=${encoding}";
        response.setHeader "Content-disposition", "attachment; filename=${filename}"

        csvContent.each { String line ->
            outs << "${line}\n"
        }

        outs.flush()
        outs.close()
    }
    @Override
    void setConfiguration(Config co) {
        csvMimeType = co.getProperty('grails.mime.types.csv', String, 'text/csv')
        encoding = co.getProperty('grails.converters.encoding', String, 'UTF-8')

    }
}
