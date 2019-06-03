package com.ander.cloud.propertymanagement.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class Utils {
	public static User getTechnicalUser() {
		  Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		  grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		  
		  return new User("Technical User","",grantedAuthorities);
	}
}
