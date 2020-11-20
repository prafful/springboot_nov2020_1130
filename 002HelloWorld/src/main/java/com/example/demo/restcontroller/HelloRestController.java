package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.HelloPojo;
import com.example.demo.service.HelloService;

@RestController
public class HelloRestController {
	
	@Autowired
	private HelloService helloService;
	
	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Spring Boot 2.4.0!!!!";
	}
	
	@RequestMapping("/welcome")
	public String message() {
		return "Welcome to Spring Boot 2.4.0!!!!";
	}
	
	@RequestMapping("/check")
	public String devTool() {
		return "Spring Boot is using DevTools!!!!";
	}
	
	@RequestMapping("/messages/all")
	public List<HelloPojo> getAllMessage() {
		return helloService.getAllMessage();
	}
	
	
	@GetMapping("/messages/get/{id}")
	public HelloPojo getMessageById(@PathVariable int id) {
		return helloService.getMessageById(id);
	}
	
	@DeleteMapping("/messages/delete/{id}")
	public List<HelloPojo> deleteMessageById(@PathVariable int id){
		return helloService.deleteMessageById(id);
	}
	
	@PutMapping("/messages/update/{id}")
	public List<HelloPojo> updateMessageById(@PathVariable int id, @RequestBody HelloPojo hp){
		return helloService.updateMessageById(id, hp);
	}

}
