//This class holds the DB object of the 'Property' entity
package project.relaxinnAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.relaxinnAPI.model.PropertyModel;
import project.relaxinnAPI.model.PropertyTypeModel;

// This interface helps to connect to MongoDB
public interface PropertyDao extends MongoRepository<PropertyModel, String> {
	public List<PropertyModel> findByType(PropertyTypeModel type);
}