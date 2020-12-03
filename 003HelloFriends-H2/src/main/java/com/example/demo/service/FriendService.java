package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FriendDao;
import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.FriendPojo;

@Service
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;

	public List<FriendPojo> getAllFriends() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}

	public List<FriendEntity> addFriend(FriendPojo fp) {
		// TODO Auto-generated method stub
		return friendDao.addFriend(fp);
	}

	public FriendEntity updateFriendById(int id, FriendPojo fp) {
		// TODO Auto-generated method stub
		return friendDao.updateFriendById(id, fp);
	}

	public FriendEntity deleteFriendById(int id) {
		// TODO Auto-generated method stub
		return friendDao.deleteFriendById(id);
	}

	public List<FriendEntity> getByName(String name) {
		// TODO Auto-generated method stub
		return friendDao.getByName(name);
	}

	public List<FriendEntity> getByLocation(String location) {
		// TODO Auto-generated method stub
		return friendDao.getByLocation(location);
	}

}
