package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "friend_table")
public class FriendEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "friend_name")
	private String name;
	
	@Column(name = "friend_location")
	private String location;
	
	@Column(name = "friend_score")
	private int score;
	
	@Column(name = "friend_status")
	private boolean status;
	

}
