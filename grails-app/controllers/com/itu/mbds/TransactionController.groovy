package com.itu.mbds

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')

class TransactionController {

    def index() { }
}
