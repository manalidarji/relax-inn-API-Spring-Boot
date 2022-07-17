package project.relaxinnAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.relaxinnAPI.model.UserModel;
import project.relaxinnAPI.repository.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao userDaoObj;

	// read all users from DB
	public List<UserModel> getAllUsers() {
		return userDaoObj.findAll();
	}

	// read single user from DB
	public UserModel getSingleUser(String userId) {
	    Optional<UserModel> singleUser = userDaoObj.findById(userId);
	    if(singleUser.isPresent()) {
	        return singleUser.get();
	    }
	    return null;
	}
}
