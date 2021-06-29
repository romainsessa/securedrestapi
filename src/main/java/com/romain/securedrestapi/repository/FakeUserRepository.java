package com.romain.securedrestapi.repository;

import org.springframework.stereotype.Repository;

import com.romain.securedrestapi.model.InternalUser;

/**
 * Fake Repository used for some tests...
 */
@Repository
public class FakeUserRepository {

	public InternalUser findByUsername(String username) {
		// Fake data
		InternalUser user = new InternalUser();
		user.setUsername(username);
		user.setPassword("test");
		user.setMail(username+"@mail.com");
		return user;
	}	
	
}