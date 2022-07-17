package project.relaxinnAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.relaxinnAPI.model.UserModel;

public interface UserDao extends MongoRepository<UserModel, String> {

}