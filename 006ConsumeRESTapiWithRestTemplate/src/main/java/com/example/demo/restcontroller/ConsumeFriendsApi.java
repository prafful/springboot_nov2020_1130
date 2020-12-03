package com.example.demo.restcontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.pojo.FriendResponse;

@RestController
public class ConsumeFriendsApi {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/external/friends/get/all")
	public List<FriendResponse> getAllFriends() {
		String url = "http://localhost:4444/friends/all";
		//String url = "https://jsonplaceholder.typicode.com/posts/";
		ResponseEntity<FriendResponse[]> response = restTemplate.getForEntity(url, FriendResponse[].class);
		System.out.println(response.toString());
		List<FriendResponse> friends = new ArrayList<FriendResponse>();
		if(response.getStatusCode() == HttpStatus.OK) {
			
			  for(FriendResponse fr: response.getBody()) { 
				  System.out.println(fr);
			  	  System.out.println("#########################");
			  	  friends.add(fr);
			  }
			  return friends;
			 
			
		}else {
			System.out.println("Error in communicating with rest api!!!!");
			return friends;
		}
		
	}
	
}
