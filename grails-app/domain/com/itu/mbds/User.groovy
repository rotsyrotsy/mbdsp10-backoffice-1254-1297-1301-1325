package com.itu.mbds

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String email
    String password
    String user_image
    String address
    boolean enabled=true
    Date dateCreated
    Date deleted_at
    Role role_id
    Date locked_at

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        email nullable: false, blank: false, unique: true, email: true
        enabled nullable: false
        role_id nullable: false
        user_image nullable: true
        address nullable: true
        deleted_at nullable: true, date: true
        locked_at nullable: true, date: true
    }

    static mapping = {
        table '`user`'
	    password column: '`password`'
        dateCreated column: 'creation_date'
        enabled column: 'is_active'
    }
}
