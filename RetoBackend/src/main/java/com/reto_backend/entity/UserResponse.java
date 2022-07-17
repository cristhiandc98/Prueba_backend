package com.reto_backend.entity;

import java.io.Serializable;

public class UserResponse implements Serializable{
	
	private int id;
	
	private String last_name;
	
	private String email;

	public UserResponse() {
	}

	public UserResponse(int id, String last_name, String email) {
		this.id = id;
		this.last_name = last_name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return id + " | " + last_name + " | " + email;
	}

}
