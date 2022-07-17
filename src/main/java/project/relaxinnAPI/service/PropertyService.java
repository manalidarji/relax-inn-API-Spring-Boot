//This class holds all the business logic related to 'Property' entity
package project.relaxinnAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.relaxinnAPI.model.PropertyModel;
import project.relaxinnAPI.model.PropertyTypeModel;
import project.relaxinnAPI.repository.PropertyDao;
import project.relaxinnAPI.repository.PropertyTypeDao;

// We mark beans with @Service to indicate that they're holding the business logic
@Service
public class PropertyService {
	// dependency injection as per singleton spring design pattern, only one object across the whole application
	@Autowired
	PropertyDao propDaoObj;
	
	@Autowired
	PropertyTypeDao propTypeDaoObj;
	
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

	public PropertyModel createProperty(PropertyModel prop) {
		return propDaoObj.insert(prop);
	}

	public void deleteProperty(String propID) {
		propDaoObj.deleteById(propID);
	}

	public PropertyModel updateProperty(PropertyModel prop) {
		return propDaoObj.save(prop);
	}

	public List<PropertyModel> getPropertiesByType(String propType) {
		PropertyTypeModel foundType = propTypeDaoObj.findByPropType(propType);
		if(foundType == null) {
			return null;
		}
		
		PropertyTypeModel propTypeObj = new PropertyTypeModel(
				foundType.getId(),
				foundType.getPropType()
		);
		return propDaoObj.findByType(propTypeObj);
	}
}