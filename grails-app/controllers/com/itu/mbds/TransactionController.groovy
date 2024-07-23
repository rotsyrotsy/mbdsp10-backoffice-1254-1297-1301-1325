package com.itu.mbds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])

class TransactionController {

    def index() { }
}
