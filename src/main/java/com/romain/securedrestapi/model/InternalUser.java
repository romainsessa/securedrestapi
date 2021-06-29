package com.romain.securedrestapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "internalusers")
public class InternalUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String username;
	private String mail;
	private String password;
	
	/*
	 * Only 1 role by user.
	 */
	@ManyToOne
	@JoinColumn(name="role_id")
	private InternalRole role;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public InternalRole getRole() {
		return role;
	}
	
	public void setRole(InternalRole role) {
		this.role = role;
	}
	
}