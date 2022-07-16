package project.relaxinnAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.relaxinnAPI.model.PropertyTypeModel;
import project.relaxinnAPI.repository.PropertyTypeDao;

@Service
public class PropertyTypeService {
	@Autowired
	PropertyTypeDao propTypeDaoObj;
	
	public List<PropertyTypeModel> getAllPropTypes(String number){
		List<PropertyTypeModel> allPropTypes = propTypeDaoObj.findAll();
		
		// return all prop types if number is null
		if(number == null) {
			return allPropTypes;
		}
		
		// parse string into int
		int limit = Integer.parseInt(number);
		
		// return all prop types if limit is less than or equal to 0
		if(limit <= 0) {
			return allPropTypes;
		}
				
		List<PropertyTypeModel> limitedPropTypes = new ArrayList<PropertyTypeModel>();
        for (PropertyTypeModel propType: allPropTypes) {
        	if(limitedPropTypes.size() == limit) {
        		break;
        	}
        	limitedPropTypes.add(propType);   
        }		
		return limitedPropTypes;
	}
}