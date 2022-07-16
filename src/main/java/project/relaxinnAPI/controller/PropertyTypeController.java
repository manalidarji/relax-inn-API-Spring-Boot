package project.relaxinnAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.relaxinnAPI.model.PropertyTypeModel;
import project.relaxinnAPI.service.PropertyTypeService;

@RestController
public class PropertyTypeController { 
	@Autowired
	PropertyTypeService propTypeServiceObj;
	
	@GetMapping("/propertyTypes")
	public ResponseEntity<List<PropertyTypeModel>> getAllPropTypes(@RequestParam(name = "limit", required = false) String limit){
		List<PropertyTypeModel> allPropTypes = propTypeServiceObj.getAllPropTypes(limit);	
		if(allPropTypes.isEmpty() || allPropTypes == null) {
			return new ResponseEntity<List<PropertyTypeModel>>(allPropTypes, HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<List<PropertyTypeModel>>(allPropTypes, HttpStatus.OK);
	}
}
