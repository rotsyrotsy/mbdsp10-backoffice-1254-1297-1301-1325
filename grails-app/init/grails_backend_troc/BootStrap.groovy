package grails_backend_troc

import com.itu.mbds.Role
import com.itu.mbds.User

class BootStrap {
    def init = { servletContext ->
        //initData()
    }
    void initData(){
        Role.withTransaction {
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

    }
}
