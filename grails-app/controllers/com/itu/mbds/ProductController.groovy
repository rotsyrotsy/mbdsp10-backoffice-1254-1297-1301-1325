package com.itu.mbds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])
class ProductController {
    ProductService productService

    def index(Integer max) {
        def productList = productService.list(params)
        params.max = Math.min(max ?: 10, 100)
        params.sort = "creationDate"
        params.order = "desc"
        respond productList, model:[productCount: productService.count()]
    }
    def show(Long id) {}
}
