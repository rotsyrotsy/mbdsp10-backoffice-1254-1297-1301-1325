package com.itu.mbds

import grails.plugin.springsecurity.annotation.Secured
import org.hibernate.criterion.CriteriaSpecification

import static org.springframework.http.HttpStatus.NOT_FOUND

@Secured(['ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN'])
class ProductController {
    ProductService productService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.sort = "creationDate"
        params.order = "desc"
        def productList = flash.search ? flash.searchResults : productService.list(params)
        def productCount = flash.search ? flash.searchResults.size() : productService.count()

        respond productList, model:[productCount: productCount]

    }
    def search() {
        def searchParams = params
        def criteria = Product.createCriteria()
        def results = criteria.list {
            createAlias('actualOwner', 'ao', CriteriaSpecification.INNER_JOIN)
            createAlias('firstOwner', 'fo', CriteriaSpecification.INNER_JOIN)

            if (searchParams.keyword) {
                or {
                    ilike('productName', "%${searchParams.keyword}%")
                    ilike('ao.username', "%${searchParams.keyword}%")
                    ilike('fo.username', "%${searchParams.keyword}%")

                }
            }
            if (searchParams.isExchangeable != null && searchParams.isExchangeable.compareTo("")!=0) {
                eq('isExchangeable', searchParams.isExchangeable.toBoolean() )
            }
            maxResults(Math.min(searchParams.max ?: 10, 100))
            order('creationDate', 'desc')
        }
        flash.searchResults = results
        flash.searchParams = searchParams
        flash.search = true
        redirect(action: 'index',  params: searchParams)
    }

    def show(Long id) {
        def product = productService.get(id)
        if (product == null) {
            notFound()
            return
        }
        respond product
    }
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
