package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

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

	public FriendEntity updateFriendById(int id, FriendPojo fp) {
		// TODO Auto-generated method stub
		//check if friend with given id is valid
		//optional will be empty if id is invalid
		//optional will contain FriendEntity instance if id is valid
		Optional<FriendEntity> feo =  friendRepository.findById(id);
		if(feo.isPresent()) {
			//extract entity from optional
			FriendEntity fe = feo.get();
			//pass updated values from fp to fe
			fe.setName(fp.getName());
			fe.setLocation(fp.getLocation());
			fe.setScore(fp.getScore());
			fe.setStatus(fp.isStatus());
			//save fe in the repository and flush it to persist the updates in database
			friendRepository.saveAndFlush(fe);
		}else {
			return new FriendEntity();
		}
		return friendRepository.findById(id).get();
	}

	public FriendEntity deleteFriendById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check if friend with given id is valid
		//optional will be empty if id is invalid
		//optional will contain FriendEntity instance if id is valid
		Optional<FriendEntity> feo =  friendRepository.findById(id);
		if(feo.isPresent()) {
			friendRepository.deleteById(id);
		}else {
			return new FriendEntity(id, null, null, 0, false);
		}
		
		return new FriendEntity();
	}
	
	public List<FriendEntity> getByName(String name){
		return friendRepository.findByName(name);
	}
	
	public List<FriendEntity> getByLocation(String location){
		return friendRepository.findByLocation(location);
	}

}
