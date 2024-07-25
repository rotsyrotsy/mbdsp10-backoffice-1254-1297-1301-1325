package com.itu.mbds

import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])
class DashboardController {
    ExchangeService exchangeService
    TransactionService transactionService
    def index() {
        params.max = Math.min(10, 100)
        params.sort = "creationDate"
        params.order = "desc"
        def exchangeList = exchangeService.list(params)
        params.sort = "creation_date"
        def transactionList = transactionService.list(params)

        respond exchangeList,model:[transactionList: transactionList]
    }
}
