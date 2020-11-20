package com.example.demo.pojo;

public class HelloPojo {

	private int id;
	private String message;
	private boolean status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public HelloPojo(int id, String message, boolean status) {
		super();
		this.id = id;
		this.message = message;
		this.status = status;
	}
	
	public HelloPojo() {
		super();
		
	}
	
	
	
	
}
