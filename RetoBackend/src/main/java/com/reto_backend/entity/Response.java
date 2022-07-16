package com.reto_backend.entity;

import java.util.List;

public class Response {

	private List<String> data;

	public Response() {
	}

	public Response(List<String> data) {
		this.data = data;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
	
	

}
