package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HelloDao;
import com.example.demo.pojo.HelloPojo;

@Service
public class HelloService {
	
	@Autowired
	private HelloDao helloDao;

	public List<HelloPojo> getAllMessage() {
		// TODO Auto-generated method stub
		return helloDao.getAllMessage();
	}

}
