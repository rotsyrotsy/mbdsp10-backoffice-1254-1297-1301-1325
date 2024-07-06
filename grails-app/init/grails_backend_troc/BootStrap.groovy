package grails_backend_troc

import com.itu.mbds.Role

import com.itu.mbds.User
import com.itu.mbds.UserRole

class BootStrap {
/*
    def init = { servletContext ->

        // Démarre une transaction programmatique
        UserRole.withTransaction {
            // On crée un rôle admin que l'on attribuera après aux utilisateurs
            def adminRole = new Role(authority: 'ROLE_ADMIN').save()
            def userRole = new Role(authority: 'ROLE_USER').save()
            // On crée un compte utilisateur
            def adminUser = new User(username: 'admin', password: 'admin').save()
            def userUser = new User(username: 'user', password: 'user').save()

            // On attribue le role (ROLE_ADMIN) à l'utilisateur
            UserRole.create(adminUser, adminRole)
            UserRole.create(userUser, userRole)
        }

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2


        }
*/
}
