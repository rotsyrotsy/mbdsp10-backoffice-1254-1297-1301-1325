package com.itu.mbds

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role {
	private static final long serialVersionUID = 1

	String authority
	String name
	Date createdAt
	Date updatedAt

	static hasMany = [users: User]

	static constraints = {
		authority nullable: false, blank: false, unique: true
		name nullable: false, blank: false, unique: true
	}


	static mapping = {
		table '`Roles`'
		cache true
		authority column: '`authority`'
		name column: '`name`'
		createdAt column: '`createdAt`'
		updatedAt column: '`updatedAt`'
		version false
	}
}
