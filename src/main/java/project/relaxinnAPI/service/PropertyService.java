//This class holds all the business logic related to 'Property' entity
package project.relaxinnAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.relaxinnAPI.model.PropertyModel;
import project.relaxinnAPI.repository.PropertyDao;

// We mark beans with @Service to indicate that they're holding the business logic
@Service
public class PropertyService {
	// dependency injection as per singleton spring design pattern, only one object across the whole application
	@Autowired
	PropertyDao propDaoObj;
	
	public List<PropertyModel> getAllProperties() {
		return propDaoObj.findAll();
	}

	public PropertyModel getSingleProperty(String propID) {
		Optional<PropertyModel> singleProp = propDaoObj.findById(propID);
		if(singleProp.isPresent()) {
			return singleProp.get();
		}
		return null;
	}
}