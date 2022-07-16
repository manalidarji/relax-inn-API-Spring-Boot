// This class is responsible for processing incoming REST API requests and give back appropriate response. 
package project.relaxinnAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import project.relaxinnAPI.model.PropertyModel;
import project.relaxinnAPI.service.PropertyService;

//In Spring's approach to building RESTful web services, HTTP requests are handled by a controller. 
//These components are identified by the @RestController annotation
@RestController
public class PropertyController {
	// Dependency Injection using @Autowired
	@Autowired
	PropertyService propServObj;
	
	// for reading all properties
	// @GetMapping handles the HTTP GET requests matched with given URI expression.
	// ResponseEntity represents the whole HTTP response: status code, headers, and body. 
	// As a result, we can use it to fully configure the HTTP response
	@GetMapping("/properties")
	public ResponseEntity<List<PropertyModel>> getAllProperties() {
		List<PropertyModel> allProps = propServObj.getAllProperties();
		if(allProps.isEmpty() || allProps == null) {
			return new ResponseEntity<List<PropertyModel>>(allProps, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PropertyModel>>(allProps, HttpStatus.OK);
	}
}
