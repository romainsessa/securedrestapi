package com.romain.securedrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romain.securedrestapi.model.InternalUser;

@Repository
public interface IUserRepository extends JpaRepository<InternalUser, Integer> {

	InternalUser findByUsername(String username);

}