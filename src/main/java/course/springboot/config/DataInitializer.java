package course.springboot.config;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import course.springboot.entities.User;
import course.springboot.repository.UserRepository;

/**
 * 
 * @author Edson Cavalcanti 
 * 
 * - ApplicationListener será executado logo no inicio da aplicação.
 */

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private final Logger log = LoggerFactory.getLogger(DataInitializer.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {

			createUser("Edson Cavalcanti", "edson.horacavalcanti@gmail.com");
			createUser("Juliana de Castro", "juliana.horacavalcanti@hotmail.com");
			createUser("Selena Pinheiro", "selena@yahoo.com.br");
		}
	
		Optional<User> user = userRepository.findFullName("Selena Pinheiro");
		user.ifPresent(u -> log.info("User Full Name: "+ u.getName()));
		
		log.info("Find Username in Database");
		Optional<User> name = userRepository.findByName("Edson Cavalcanti");
		name.ifPresent(n -> log.info("User Found: " + n.getEmail()));
		
		log.info("Find Like E-mail in Database");
		Optional<User> email = userRepository.findByEmailLike("juliana");
		email.ifPresent(e -> log.info("E-mail Found: " + e.getEmail()));
	}

	
	public void createUser(String name, String email) {

		User user = new User(email, name);
		userRepository.save(user);

	}

}
