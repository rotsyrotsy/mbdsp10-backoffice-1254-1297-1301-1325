package com.itu.mbds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])
class ProductController {

    def index() { }

    def show(Long id) {}
}
