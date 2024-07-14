package com.itu.mbds

class Proposition {
    Date creationDate = new Date()
    Date updatingDate = new Date()
    User user

    static constraints = {
        user nullable: false
        creationDate nullable: false,date: true, default: new Date()
        updatingDate nullable: false,date:true, default: new Date()
    }

    static mapping = {
        creationDate column: 'creation_date'
        updatingDate column: 'updated_date'
        user column: 'user_id'
        version false
    }
    static hasMany = [exchanges: Exchange]

    Set<Product> getProducts(){
        (PropProducts.findAllByProposition(this) as List<PropProducts>)*.product as Set<Product>
    }
}

