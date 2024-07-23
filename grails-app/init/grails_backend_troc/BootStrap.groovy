package grails_backend_troc

import com.itu.mbds.Category
import com.itu.mbds.Exchange
import com.itu.mbds.Product
import com.itu.mbds.ProductCategory
import com.itu.mbds.PropProducts
import com.itu.mbds.Proposition
import com.itu.mbds.Role
import com.itu.mbds.User

class BootStrap {
    def init = { servletContext ->
        initData()
    }
    void initData(){
       /* Role.withTransaction {
            ["ROLE_SUPER_ADMIN", "ROLE_ADMIN", "ROLE_USER"].each {
                String name ->
                    new Role(authority: name).save()
            }
        }
        assert Role.count() == 3
        User.withTransaction {
            // Create super admin user and assign the role
            def sadminUser = new User(username: 'super admin', password: 'superadmin', email: 'superadmin@mail.com', role: Role.findByAuthority('ROLE_SUPER_ADMIN'))
            if (!sadminUser.save(failOnError: true)) {
                sadminUser.errors.allErrors.each { println it }
            }

            // Create admin user and assign the role
            def adminUser = new User(username: 'admin', password: 'admin', email: 'admin@mail.com', role: Role.findByAuthority('ROLE_ADMIN'))
            if (!adminUser.save(failOnError: true)) {
                adminUser.errors.allErrors.each { println it }
            }

            // Create regular user and assign the role
            def userUser = new User(username: 'user', password: 'user', email: 'user@mail.com', role: Role.findByAuthority('ROLE_USER'))
            if (!userUser.save(failOnError: true)) {
                userUser.errors.allErrors.each { println it }
            }
        }
        assert User.count() == 3
        Category.withTransaction{
            def techCategory = new Category(categoryName: 'Technology').save()
            def beautyCategory = new Category(categoryName: 'Beauty').save()
            def officeCategory = new Category(categoryName: 'Office').save()
        }
        assert Category.count() == 3
        Product.withTransaction {
            def userUser = User.get(6)
            def product1 = new Product(
                    description: 'A high-quality smartphone.',
                    productName: 'Smartphone X',
                    productImage: 'https://example.com/images/smartphone-x.jpg',
                    isExchangeable: true,
                    isDeleted: false,
                    firstOwner: userUser,
                    actualOwner: userUser
            )
            if (!product1.save(failOnError: true)) {
                product1.errors.allErrors.each { println it }
            }
            def product2 = new Product(
                    description: 'Latest model of the laptop series.',
                    productName: 'Laptop Pro',
                    productImage: 'https://example.com/images/laptop-pro.jpg',
                    isExchangeable: true,
                    isDeleted: false,
                    firstOwner: userUser,
                    actualOwner: userUser
            )
            if (!product2.save(failOnError: true)) {
                product2.errors.allErrors.each { println it }
            }
            def product3 = new Product(
                    description: 'A comfortable office chair.',
                    productName: 'Office Chair',
                    productImage: 'https://example.com/images/office-chair.jpg',
                    isExchangeable: true,
                    isDeleted: false,
                    firstOwner: userUser,
                    actualOwner: userUser
            )
            if (!product3.save(failOnError: true)) {
                product3.errors.allErrors.each { println it }
            }
        }
        assert Product.count() == 3
        ProductCategory.withTransaction {
            def pc1 = ProductCategory.create(Category.findByCategoryName("Technology"), Product.findByProductName("Smartphone X"))
            if (!pc1.save(failOnError: true)) {
                pc1.errors.allErrors.each { println it }
            }
            def pc2 = ProductCategory.create(Category.findByCategoryName("Technology"), Product.findByProductName("Laptop Pro"))
            if (!pc2.save(failOnError: true)) {
                pc2.errors.allErrors.each { println it }
            }
            def pc20 = ProductCategory.create(Category.findByCategoryName("Office"), Product.findByProductName("Laptop Pro"))
            if (!pc20.save(failOnError: true)) {
                pc20.errors.allErrors.each { println it }
            }
            def pc3 = ProductCategory.create(Category.findByCategoryName("Office"), Product.findByProductName("Office Chair"))
            if (!pc3.save(failOnError: true)) {
                pc3.errors.allErrors.each { println it }
            }
        }
        assert ProductCategory.count() == 4

        Proposition.withTransaction {
            def proposition = new Proposition(
                    user: User.get(6)
            )
            if (!proposition.save(failOnError: true)) {
                proposition.errors.allErrors.each { println it }
            }

            def proposition2 = new Proposition(
                    user: User.get(18)
            )
            if (!proposition2.save(failOnError: true)) {
                proposition2.errors.allErrors.each { println it }
            }
        }
        assert Proposition.count() == 2
        PropProducts.withTransaction {
            def pp1 = PropProducts.create(Proposition.get(19), Product.findByProductName("Laptop Pro"))
            if (!pp1.save(failOnError: true)) {
                pp1.errors.allErrors.each { println it }
            }
            def pc2 = PropProducts.create(Proposition.get(20), Product.findByProductName("Smartphone X"))
            if (!pc2.save(failOnError: true)) {
                pc2.errors.allErrors.each { println it }
            }
            def pc3 = PropProducts.create(Proposition.get(20), Product.findByProductName("Office Chair"))
            if (!pc3.save(failOnError: true)) {
                pc3.errors.allErrors.each { println it }
            }
        }
        assert PropProducts.count() == 3
        Exchange.withTransaction {
            def exchange = new Exchange(
                status: "PENDING",
                ownerProposition :Proposition.get(19),
                takerProposition :Proposition.get(20)
            )
            if (!exchange.save(failOnError: true)) {
                exchange.errors.allErrors.each { println it }
            }
        }
        assert Exchange.count() == 1*/
    }
}
