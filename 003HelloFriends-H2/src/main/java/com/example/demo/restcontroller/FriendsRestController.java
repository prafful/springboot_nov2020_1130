package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.FriendPojo;
import com.example.demo.service.FriendService;

@RestController
public class FriendsRestController {
	
	@Autowired
	private FriendService friendService;
	
	@GetMapping("/friends/all")
	public List<FriendEntity> getAllFriends(){
		return friendService.getAllFriends();
	}

	
	@PostMapping("/friends/add")
	public List<FriendEntity> addFriend(@RequestBody FriendPojo fp){
		return friendService.addFriend(fp);
	}
	
	@PutMapping("/friends/update/{id}")
	public FriendEntity updateFriendById(@PathVariable int id, @RequestBody FriendPojo fp) {
		return friendService.updateFriendById(id, fp);
	}
	
	
}
