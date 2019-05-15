package com.ander.cloud.propertymanagement.authentication;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findRoleByName(String name);
}
