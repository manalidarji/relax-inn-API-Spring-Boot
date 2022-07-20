package project.relaxinnAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import project.relaxinnAPI.model.UserModel;
import project.relaxinnAPI.repository.UserDao;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserDao userDaoObj;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoderObj;

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

	public UserModel createUser(UserModel user) {	
		String encodedPassword = bCryptPasswordEncoderObj.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userDaoObj.insert(user);
	}
	
	// override loadUserByUsername function for authentication purpose
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel foundUser = userDaoObj.findByEmail(username);
		return new User(
				foundUser.getEmail(), 
				foundUser.getPassword(), 
				new ArrayList<>()
			);
	}
}
