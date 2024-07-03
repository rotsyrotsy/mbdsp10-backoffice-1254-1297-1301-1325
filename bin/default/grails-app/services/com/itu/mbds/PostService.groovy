package com.itu.mbds

import grails.gorm.services.Service

@Service(Post)
interface logiPostService {

    Post get(Serializable id)

    List<Post> list(Map args)

    Long count()

    void delete(Serializable id)

    Post save(Post post)

}