package com.itu.mbds

class Product {
    String description
    String productName
    String productImage
    boolean isExchangeable = true
    Date creationDate = new Date()
    Date updatedAt = new Date()
    Date deletedAt = new Date()
    User firstOwner
    User actualOwner
    static belongsTo = [firstOwner: User, actualOwner: User]

    static constraints = {
        productName nullable: false, blank: false
        description nullable: true
        productImage nullable: true
        firstOwner nullable: false, blank:false
        actualOwner nullable: false, blank:false
        creationDate nullable: false,date: true, default: new Date()
        updatedAt nullable: false,date:true, default: new Date()
        deletedAt nullable: true,date:true
    }
    static mapping = {
        table '`Products`'
        productName column: '`product_name`'
        productImage column: '`product_image`'
        isExchangeable column: '`is_exchangeable`'
        creationDate column: '`createdAt`'
        updatedAt column: '`updatedAt`'
        deletedAt column: '`deletedAt`'
        description column: '`description`'
        description type: 'text'
        firstOwner column: '`first_owner_id`'
        actualOwner column: '`actual_owner_id`'
        version false
    }

    Set<Proposition> getPropositions(){
        (PropProducts.findAllByProduct(this) as List<PropProducts>)*.proposition as Set<Proposition>
    }
    Set<Category> getCategories(){
        (ProductCategory.findAllByProduct(this) as List<ProductCategory>)*.category as Set<Category>
    }
    Set<Exchange> getAllExchanges(){
        Set<Exchange> allExchanges = new HashSet<>()
        this.propositions.each { proposition ->
            allExchanges.addAll(proposition.getAllExchanges())
        }
        return allExchanges
    }
    List<Transaction> getAllTransactions(){
        List<Transaction> allTransactions = new ArrayList<>()
        this.allExchanges.each { exchange ->
            def exchanges = Transaction.findAllByExchange_id(exchange.id)
            allTransactions.addAll(exchanges)
        }
        return allTransactions
    }
}
