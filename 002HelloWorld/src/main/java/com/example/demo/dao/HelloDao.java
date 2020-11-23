package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.HelloPojo;

@Repository
public class HelloDao {
	
	private List<HelloPojo> messages = new ArrayList<HelloPojo>();
	
	public HelloDao() {
		HelloPojo hp1 = new HelloPojo(1, "Hello from India!", true);
		HelloPojo hp2 = new HelloPojo(2, "Hello from Japan!", true);
		HelloPojo hp3 = new HelloPojo(3, "Hello from Singapore!", true);
		HelloPojo hp4 = new HelloPojo(4, "Hello from Canada!", true);
		
		messages.add(hp1);
		messages.add(hp2);
		messages.add(hp3);
		messages.add(hp4);
	}
	
	

	public List<HelloPojo> getAllMessage() {
		// TODO Auto-generated method stub
		return messages;
	}



	public HelloPojo getMessageById(int id) {
		// TODO Auto-generated method stub
		for (HelloPojo helloPojo : messages) {
			if(helloPojo.getId() == id ) {
				return helloPojo;
			}
		}
		return new HelloPojo();
		
	
	}



	public List<HelloPojo> deleteMessageById(int id) {
		// TODO Auto-generated method stub
		for (HelloPojo helloPojo : messages) {
			if(helloPojo.getId() == id ) {
				messages.remove(helloPojo);
				return messages;
			}
		}
		return new ArrayList<HelloPojo>();
	}



	public List<HelloPojo> updateMessageById(int id, HelloPojo hp) {
		// TODO Auto-generated method stub
		for (HelloPojo helloPojo : messages) {
			if(helloPojo.getId() == id ) {
				helloPojo.setMessage(hp.getMessage());
				helloPojo.setStatus(hp.isStatus());
				return messages;
						
			}
		}
		return new ArrayList<HelloPojo>();
	}

}
