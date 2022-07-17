package project.relaxinnAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import project.relaxinnAPI.model.UserModel;
import project.relaxinnAPI.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userServiceObj;
	
	// for reading all users
	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> getAllUsers(){
		List<UserModel> allUsers = userServiceObj.getAllUsers();	
		if(allUsers == null) {
			return new ResponseEntity<List<UserModel>>(allUsers, HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<List<UserModel>>(allUsers, HttpStatus.OK);
	}
}
