package com.ander.cloud.propertymanagement.property;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/property")
public class PropertyController {

	@Autowired
	private PropertyRepository propertyRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public String addNewProperty(@Valid @RequestBody Property requestBody) {
		Property property = (Property) requestBody;
		propertyRepository.save(property);
		return "Saved";
	}

	@GetMapping("/{id}")
	public Property getProperty(@PathVariable("id") Long id) {
		Property property = propertyRepository.findById(id).get();
		return property;
	}

	@GetMapping
	public Iterable<Property> getAllProperties() {
		return propertyRepository.findAll();
	}

	@PutMapping("/{id}")
	public Property updateProperty(@RequestBody Property newProperty, @PathVariable("id") Long id) {
		return propertyRepository.findById(id).map(property -> {
			property.setAddress(newProperty.getAddress());
			property.setPrice(newProperty.getPrice());
			return propertyRepository.save(property);
		}).orElseGet(() -> {
			newProperty.setId(id);
			return propertyRepository.save(newProperty);
		});
	}

	@DeleteMapping("/{id}")
	void deleteEmployee(@PathVariable Long id) {
		propertyRepository.deleteById(id);
	}

}
