package com.itu.mbds

class Proposition {
    Date creationDate = new Date()
    Date updatingDate = new Date()
    User user
    boolean isActive=true

    static constraints = {
        user nullable: false
        creationDate nullable: false,date: true, default: new Date()
        updatingDate nullable: false,date:true, default: new Date()
        isActive nullable: false
    }

    static mapping = {
        creationDate column: 'creation_date'
        updatingDate column: 'updated_date'
        user column: 'user_id'
        isActive column: 'is_active'
        version false
    }
    static hasMany = [ownerExchanges: Exchange]

    Set<Product> getProducts(){
        (PropProducts.findAllByProposition(this) as List<PropProducts>)*.product as Set<Product>
    }
    Set<Exchange> getAllExchanges() {
        def ownerExchanges = Exchange.findAllByOwnerProposition(this)
        def takerExchanges = Exchange.findAllByTakerProposition(this)
        return (ownerExchanges + takerExchanges) as Set<Exchange>
    }
}

