package com.itu.mbds


import grails.gorm.services.Service

@Service(Transaction)
interface TransactionService {

    Transaction get(Serializable id)

    List<Transaction> list(Map args)

    Long count()

    void delete(Serializable id)

    Transaction save(Transaction post)

}