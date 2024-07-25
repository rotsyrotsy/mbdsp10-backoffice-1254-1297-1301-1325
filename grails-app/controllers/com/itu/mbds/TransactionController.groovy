package com.itu.mbds

import grails.plugin.springsecurity.annotation.Secured
import org.hibernate.criterion.CriteriaSpecification

@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])

class TransactionController {
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
}
