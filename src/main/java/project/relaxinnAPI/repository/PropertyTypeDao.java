package project.relaxinnAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.relaxinnAPI.model.PropertyTypeModel;

public interface PropertyTypeDao extends MongoRepository<PropertyTypeModel, String> {
	public PropertyTypeModel findByPropType(String propType);
}
