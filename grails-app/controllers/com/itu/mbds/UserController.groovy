package com.itu.mbds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])

class UserController {
    UserService userService

    def index(Integer maxRecords) {
        params.maxRecords = Math.min(maxRecords ?: 10, 100)
        params.sort = "dateCreated"
        params.order = "desc"
        respond userService.list(params), model:[userCount: userService.count()]
    }
    def show(Long id) {
    }
    def create() {
    }
}
