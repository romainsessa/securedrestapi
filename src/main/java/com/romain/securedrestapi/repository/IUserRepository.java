package com.romain.securedrestapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romain.securedrestapi.model.InternalUser;

@Repository
public interface IUserRepository extends CrudRepository<InternalUser, Integer> {
	
	List<InternalUser> findByUsername(String username);	

}