//This class holds all the business logic related to 'Property' entity
package project.relaxinnAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	private PropertyDao propDaoObj;
	
	@Autowired
	private PropertyTypeDao propTypeDaoObj;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
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
	
	// filter properties according to searchTerm from DB
	public List<PropertyModel> getPropertiesByTitle(String searchTerm) {
		Query dbQuery = new Query();
        // searches in title containing searchTerm (.*searchTerm.*)
		// i is for case-insensitive search
		dbQuery.addCriteria(Criteria.where("title").regex(".*" + searchTerm + ".*", "i"));
		List<PropertyModel> searchResults = mongoTemplate.find(dbQuery, PropertyModel.class); 		
		
		if(searchResults.isEmpty()) {
			return null;	
		}		
		return searchResults;
	}
	
	// read bestseller properties from DB
	public List<PropertyModel> getBestsellerProperties(String number) {
		int limit = -1;
		if(number == null) {
			limit = 0;
		}else {
			limit = Integer.parseInt(number);
		}
		
		if(limit < 0) {
			limit = 0;
		}
		int counter = 0;
		List<PropertyModel> bestSellerProps = new ArrayList<PropertyModel>();
		List<PropertyModel> allProps = propDaoObj.findAll();

        for (PropertyModel property: allProps) {
            if (property.isBestSeller()) {
            	if(limit > 0 && counter == limit) {
            		break;
            	}
            	bestSellerProps.add(property);
            	if(limit > 0) {
            		counter++;
            	}
            }
        }
        
        if(bestSellerProps.isEmpty()) {
        	return null;
        }
		return bestSellerProps;
	}
}