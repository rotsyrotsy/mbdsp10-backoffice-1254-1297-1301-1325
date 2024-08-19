package com.itu.mbds
import grails.gorm.DetachedCriteria

class ProductCategory {
    Category category
    Product product
    Date createdAt
    Date updatedAt

    static mapping = {
        table '`ProductCategories`'
        category column: '`category_id`'
        product column: '`product_id`'
        createdAt column: '`createdAt`'
        updatedAt column: '`updatedAt`'
        version false
    }
    static boolean exists(long categoryId, long ProductId) {
        criteriaFor(categoryId, ProductId).count()
    }
    private static DetachedCriteria criteriaFor(long categoryId, long ProductId) {
        ProductCategory.where {
            category == Category.load(categoryId) &&
                    product == Product.load(ProductId)
        }
    }
    static constraints = {
        category nullable: false
        product nullable: false, validator: { Product r, ProductCategory ur ->
            if (ur.category?.id) {
                if (ProductCategory.exists(ur.category.id, r.id)) {
                    return ['productCategory.exists']
                }
            }
        }
    }

    static ProductCategory create(Category category, Product product, boolean flush = false) {
        def instance = new ProductCategory(category: category, product: product)
        instance.save(flush: flush)
        instance
    }
}
