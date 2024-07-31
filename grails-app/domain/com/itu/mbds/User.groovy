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
    Date lastUpdated
    Date deleted_at
    Date locked_at
    Role role

    transient  boolean accountExpired
    transient  boolean accountLocked
    transient  boolean passwordExpired
    static transients = ['accountExpired','accountLocked','passwordExpired']

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        email nullable: false, blank: false, unique: true, email: true
        enabled nullable: false
        role nullable: false
        user_image nullable: true
        address nullable: true
        deleted_at nullable: true, date: true
        locked_at nullable: true, date: true
    }

    static mapping = {
        table '`user`'
	    password column: '`password`'
        dateCreated column: 'creation_date'
        lastUpdated column: 'updated_at'
        enabled column: 'is_active'
        role column: 'role_id'
        version false
    }
    Set<Role> getAuthorities() {
        [role] as Set
    }
    static hasMany = [ownedProducts: Product, actualProducts: Product, propositions:Proposition]
    static mappedBy = [ownedProducts: 'firstOwner', actualProducts: 'actualOwner']

    User moderateAccount(User user, String action){
        user.enabled = false
        if(action=="lock"){
            user.locked_at = new Date()
        }else if(action=="ban") {
            user.deleted_at = new Date()
        }else if(action=="unlock"){
            user.enabled = true
            user.locked_at = null
        }
        return user
    }
}
