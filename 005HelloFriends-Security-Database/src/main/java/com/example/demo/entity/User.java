package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	private String roles = "";
	
	private String permissions = "";
	
	private Integer active;
	
	public User(String username, String password, String roles, String permissions) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
		this.active =1;
	}
	
	
	public User() {

	}
	
	//utility methods to convert CSV to List
	
	public List<String> convertRolesToList(){
		if (this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		
		return new ArrayList<String>();
	}
	
	public List<String> convertPermissionsToList(){
		if (this.permissions.length() > 0) {
			return Arrays.asList(this.permissions.split(","));
		}
		
		return new ArrayList<String>();
		
	}
	
	
	
	
	
}
