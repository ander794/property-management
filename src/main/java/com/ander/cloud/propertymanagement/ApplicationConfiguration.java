package com.ander.cloud.propertymanagement;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ander.cloud.propertymanagement.authentication.SecurityAuditorAware;
import com.ander.cloud.propertymanagement.authentication.User;

@Configuration
@EnableScheduling
//@EnableJpaAuditing ensure that the createdAt, updatedAt, modifiedBy, createdBy fields will be filled
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class ApplicationConfiguration {

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public AuditorAware<String> auditorProvider(){
		return new SecurityAuditorAware();
	}
	
}
