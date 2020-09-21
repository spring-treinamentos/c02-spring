package course.springboot.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import course.springboot.entities.User;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findByName(String name);
	
	Optional<User> findByEmailLike(String email);
	
	@Query("{ 'name' : ?0 }")
	Optional<User> findFullName(String name);
	
}
