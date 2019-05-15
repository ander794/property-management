package com.ander.cloud.propertymanagement.authentication;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	DataSource dataSource;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.OK)
	public User register(@Valid @RequestBody User user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		
		Role userRole = roleRepository.findRoleByName("USER");
		user.setRoles(Arrays.asList(userRole));
		
		User u = userRepository.save(user);
		return u;
	}

	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public Collection<String> users() {
		List<User> users = (List<User>) userRepository.findAll();
		return users.stream().map(t->t.getName()).collect(Collectors.toCollection(LinkedList::new));
	}
	
}
