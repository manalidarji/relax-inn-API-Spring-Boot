package project.relaxinnAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.relaxinnAPI.model.UserModel;
import project.relaxinnAPI.repository.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao userDaoObj;

	public List<UserModel> getAllUsers() {
		return userDaoObj.findAll();
	}
}
