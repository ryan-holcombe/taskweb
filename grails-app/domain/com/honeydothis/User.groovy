package com.honeydothis

class User {
  String firstName
  String lastName
  String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

  String passwordConfirm

	static constraints = {
		firstName blank: false
    lastName blank: false
    username blank: false, unique: true, email: true
		password minSize:6, blank: false, matches: /^\S+$/, validator: {password, obj ->
         def passwordConfirm = obj.properties['passwordConfirm']
         passwordConfirm == password ? true : ['matchingPasswords']
     }
	}

	static mapping = {
		password column: '`password`'
	}

  static transients = ['passwordConfirm']

}
