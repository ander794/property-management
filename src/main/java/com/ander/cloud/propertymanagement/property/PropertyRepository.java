package com.ander.cloud.propertymanagement.property;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PropertyRepository extends CrudRepository<Property, Long> {
	
	List<Property> findAllPropertyByAddress(@Param("address") String address);
}
