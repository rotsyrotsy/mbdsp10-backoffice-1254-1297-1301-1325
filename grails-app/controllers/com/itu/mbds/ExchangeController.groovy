package com.itu.mbds

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import grails.plugin.springsecurity.annotation.Secured
import org.hibernate.criterion.CriteriaSpecification

@Secured(['ROLE_ADMIN','ROLE_SUPER_ADMIN'])

class ExchangeController implements GrailsConfigurationAware {
    String csvMimeType
    String encoding
    TransactionService transactionService
    ExchangeService exchangeService
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.sort = "creationDate"
        params.order = "desc"
        def exchanges = exchangeService.list(params)

        def exchangeList = flash.search ? flash.searchResults : exchangeService.list(params)
        def exchangeCount = flash.search ? flash.searchResults.size() : exchangeService.count()
        respond exchangeList, model:[exchangeCount: exchangeCount]
    }
    def search() {
        def searchParams = params
        def keyword = searchParams.keyword
        def state = searchParams.state?.toUpperCase()

        List<Integer> userIds = []
        if (keyword) {
            def users = User.findAllByUsernameLike("%${keyword}%")
            userIds = users.collect { it.id }
        }
        def criteria = Exchange.createCriteria()
        def results = criteria.list {
            createAlias('ownerProposition', 'op', CriteriaSpecification.INNER_JOIN)
            createAlias('takerProposition', 'tp', CriteriaSpecification.INNER_JOIN)
            createAlias('op.user','owner',  CriteriaSpecification.INNER_JOIN)
            createAlias( 'tp.user', 'taker',CriteriaSpecification.INNER_JOIN)

            if (keyword) {
                or {
                    ilike('owner.username', "%${searchParams.keyword}%")
                    ilike('taker.username', "%${searchParams.keyword}%")
                }
            }
            if (state) {
                ilike("status", state)
            }
            maxResults(Math.min(searchParams.max ?: 10, 100))
            order('creationDate', 'desc')
        }
        flash.searchResults = results
        flash.searchParams = searchParams
        flash.search = true
        redirect(action: 'index',  params: searchParams)
    }
    def exportCsv(){
        final String filename = 'exchanges.csv'
        def header = ["Owner", "Owner Products", "Taker", "Taker Products", "Exchange Date", "Status"]
        def headerLine = header.join(';')
        def lines = Exchange.findAll().collect{ exchange ->
            def ownerProducts = exchange.ownerProposition.getProducts().collect { product ->
                product.productName
            }.join(', ')

            def takerProducts = exchange.takerProposition.getProducts().collect { product ->
                product.productName
            }.join(', ')
            [
                    exchange.ownerProposition.user.username,
                    ownerProducts,
                    exchange.takerProposition.user.username,
                    takerProducts,
                    exchange.creationDate,
                    exchange.status
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
