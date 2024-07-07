package com.itu.mbds


class Role {
	private static final long serialVersionUID = 1

	String role_name

	static hasMany = [users: User]

	static constraints = {
		role_name nullable: false, blank: false, unique: true
	}

	static mapping = {
		cache true
	}
}
