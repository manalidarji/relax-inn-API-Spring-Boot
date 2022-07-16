package project.relaxinnAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.relaxinnAPI.model.PropertyTypeModel;
import project.relaxinnAPI.repository.PropertyTypeDao;

@Service
public class PropertyTypeService {
	@Autowired
	PropertyTypeDao propTypeDaoObj;
	
	public List<PropertyTypeModel> getAllPropTypes(){
		return propTypeDaoObj.findAll();
	}

}
