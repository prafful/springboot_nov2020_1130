package com.example.demo.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from spring boot!!!!";
	}

}
