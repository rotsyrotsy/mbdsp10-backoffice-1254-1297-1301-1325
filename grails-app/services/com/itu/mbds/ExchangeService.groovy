package com.itu.mbds

import grails.gorm.services.Service

@Service(Exchange)
interface ExchangeService {

    Exchange get(Serializable id)

    List<Exchange> list(Map args)

    Long count()

    void delete(Serializable id)

    Exchange save(Exchange post)

}