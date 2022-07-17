package com.reto_backend.entity;

import java.util.List;

public class UserFilterResponse {
	
	private List<UserResponse> data;

	public UserFilterResponse() {
	}

	public UserFilterResponse(List<UserResponse> data) {
		this.data = data;
	}

	public List<UserResponse> getData() {
		return data;
	}

	public void setData(List<UserResponse> data) {
		this.data = data;
	}
	
	public void addData(UserResponse data) {
		this.data.add(data);
	}
	

}
