package com.javatechie.aws.dyanamodb.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.dyanamodb.sample.entity.User;
import com.javatechie.aws.dyanamodb.sample.repository.UserRepository;

@SpringBootApplication
@RestController
public class SpringbootAwsDynamoDbExampleApplication {
	
	@Autowired
	private UserRepository repository;
	
	//@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return repository.addUser(user);
	}
	
	@GetMapping("/fetchUser/{userId}")
	public User findUser(@PathVariable String userId) {
		return repository.findUserByUserId(userId);
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		return repository.updateUser(user);
	}
	
	@DeleteMapping("/removeUser")
	public String removeUser(@RequestBody User user) {
		return repository.removeUser(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsDynamoDbExampleApplication.class, args);
	}

}
