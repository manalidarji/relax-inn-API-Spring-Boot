//This class holds the DB object of the 'Property' entity
package project.relaxinnAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.relaxinnAPI.model.PropertyModel;

// This interface helps to connect to MongoDB
public interface PropertyDao extends MongoRepository<PropertyModel, String> {
}