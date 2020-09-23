package course.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.springboot.entities.User;
import course.springboot.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	public UserRepository userRepository;
	
	public List<User> listAllUsers () {
		
	  return userRepository.findAll();	
	}
	
	
}
