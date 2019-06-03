package com.ander.cloud.propertymanagement.authentication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.ander.cloud.propertymanagement.utils.Utils;

public class SecurityAuditorAware implements AuditorAware<String>{
	Logger logger = LoggerFactory.getLogger(SecurityAuditorAware.class);
	
	public Optional<String> getCurrentAuditor() {

		  Optional<org.springframework.security.core.userdetails.User> secureUser = Optional.ofNullable(SecurityContextHolder.getContext())
					  .map(SecurityContext::getAuthentication)
					  .filter(Authentication::isAuthenticated)
					  .map(Authentication::getPrincipal)
					  .map(u->{
						  User user = Utils.getTechnicalUser();
						  
						  try {
							  user =  org.springframework.security.core.userdetails.User.class.cast(u);
						  }catch(ClassCastException exception) {
							  logger.error("User casting exception: "+exception.getMessage());	
						  }
						  return user;
					  });
		   
		   if(secureUser.isPresent()) {
			   return Optional.of(secureUser.get().getUsername());
		   } else {
			   return null;   
		   }
		   
	  }
}
