package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.FriendPojo;
import com.example.demo.repository.FriendRepository;

@Repository
public class FriendDao {
	
	@Autowired
	private FriendRepository friendRepository;

	public List<FriendEntity> getAllFriends() {
		// TODO Auto-generated method stub
		return friendRepository.findAll();
	}

	public List<FriendEntity> addFriend(FriendPojo fp) {
		// TODO Auto-generated method stub
		FriendEntity fe = new FriendEntity();
		fe.setName(fp.getName());
		fe.setLocation(fp.getLocation());
		fe.setScore(fp.getScore());
		fe.setStatus(fp.isStatus());
		friendRepository.save(fe);
		return friendRepository.findAll();
	}

}
