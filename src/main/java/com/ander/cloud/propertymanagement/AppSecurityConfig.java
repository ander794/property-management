package com.ander.cloud.propertymanagement;

import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Value("${authentication.users-query}")
	private String usersQuery;

	@Value("${authentication.roles-query}")
	private String authoritiesByUsernameQuery;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/register","/users").permitAll()
			.and()
			.authorizeRequests()
			.antMatchers("/property").authenticated()
			.and()
			.httpBasic();
		//	.and()
		//	.httpBasic();
		// .csrf().disable();
		// .anyRequest().authenticated();
		// .antMatchers("/admin/**").hasRole("ADMIN")
		// .antMatchers("/register**").permitAll()
		// .anyRequest().authenticated()
		// .antMatchers("/user/**").hasRole("USER")
		// .antMatchers("/user/**").hasRole("USER")
		// .and().formLogin().loginPage("/login").failureUrl("/login-error");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
		System.out.print(usersQuery);
		auth
				// For database authentication
				.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(authoritiesByUsernameQuery)
				.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web.ignoring().antMatchers("/register");
//	}

}
