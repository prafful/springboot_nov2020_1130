package com.example.demo.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class DatabaseInit implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {

		//delete all values from user table
		userRepository.deleteAll();
		
		//create users
		User visitor = new User("visitor", passwordEncoder.encode("visitor123"), "VISITOR", "");
		User manager = new User("manager", passwordEncoder.encode("manager123"), "VISITOR, MANAGER", "ACCESS_1, ACCESS_2");
		User admin = new User("admin", passwordEncoder.encode("admin123"), "VISITOR, MANAGER, ADMIN", "ACCESS_1, ACCESS_2, ACCESS_3");
		
		List<User> users = Arrays.asList(visitor, manager, admin);
		
		//save users
		userRepository.saveAll(users);
				
		
	}

}
