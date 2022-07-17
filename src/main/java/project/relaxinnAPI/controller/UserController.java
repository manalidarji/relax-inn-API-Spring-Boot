package project.relaxinnAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// for reading single users
	@GetMapping("/users/{userID}")
	public ResponseEntity<UserModel> getSingleUser(@PathVariable String userID){
		UserModel singleUser = userServiceObj.getSingleUser(userID);
	    if(singleUser == null) {
	        return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.NOT_FOUND);		
	    }
	    return new ResponseEntity<UserModel>(singleUser, HttpStatus.OK);
	}
	
	// for creating/registering new user
	@PostMapping( value = {"/users", "/register"}, consumes = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel user){
		return new ResponseEntity<UserModel>(
			userServiceObj.createUser(user), 
			HttpStatus.CREATED
		);
	}
}
