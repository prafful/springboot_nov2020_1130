package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FriendEntity;

public interface FriendRepository  extends  JpaRepository<FriendEntity,Integer>{
	
	List<FriendEntity> findByName(String name);
	
	List<FriendEntity> findByLocation(String location);

}
