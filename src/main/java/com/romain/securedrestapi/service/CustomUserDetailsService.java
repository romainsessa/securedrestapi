package com.romain.securedrestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.romain.securedrestapi.model.InternalRole;
import com.romain.securedrestapi.model.InternalUser;
import com.romain.securedrestapi.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private IUserRepository userRepository;
	
	public CustomUserDetailsService(final IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		InternalUser user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + " not found");
		}

		//Use the following line if password is not encrypted in database.
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
				user.getPassword(), 
				getGrantedAuthorities(user.getRole()));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(InternalRole role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (role != null) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

}
