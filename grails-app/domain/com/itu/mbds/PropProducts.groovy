package com.itu.mbds

import grails.gorm.DetachedCriteria

class PropProducts {
    Proposition proposition
    Product product
    Date createdAt
    Date updatedAt

    static mapping = {
        table '`PropositionProducts`'
        proposition column: '`proposition_id`'
        product column: '`product_id`'
        createdAt column: '`createdAt`'
        updatedAt column: '`updatedAt`'
        version false
    }
    static boolean exists(long propositionId, long ProductId) {
        criteriaFor(propositionId, ProductId).count()
    }
    private static DetachedCriteria criteriaFor(long propositionId, long ProductId) {
        PropProducts.where {
            proposition == Proposition.load(propositionId) && product == Product.load(ProductId)
        }
    }
    static PropProducts create(Proposition proposition, Product product, boolean flush = false) {
        def instance = new PropProducts(proposition: proposition, product: product)
        instance.save(flush: flush)
        instance
    }
    static constraints = {
        proposition nullable: false
        product nullable: false
    }
}
