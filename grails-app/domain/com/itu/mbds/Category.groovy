package com.itu.mbds

class Category {

    String categoryName

    static constraints = {
        categoryName nullable: false, blank: false, unique: true
    }
    static mapping = {
        categoryName column: '`category_name`'
        version false
    }
    Set<Product> getProducts(){
        (ProductCategory.findAllByCategory(this) as List<ProductCategory>)*.product as Set<Product>
    }
}
