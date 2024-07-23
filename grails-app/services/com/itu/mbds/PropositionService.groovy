package com.itu.mbds

import grails.gorm.services.Service

@Service(Proposition)
interface PropositionService {

    Proposition get(Serializable id)

    List<Proposition> list(Map args)

    Long count()

    void delete(Serializable id)

    Proposition save(Proposition post)

}