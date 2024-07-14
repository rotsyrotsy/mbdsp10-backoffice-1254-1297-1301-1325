package com.itu.mbds

import grails.gorm.DetachedCriteria

class PropProducts {
    Proposition proposition
    Product product

    static mapping = {
        table '`prop_products`'
        proposition column: 'proposition_id'
        product column: 'product_id'
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
    static constraints = {
        proposition nullable: false
        product nullable: false
    }
}
