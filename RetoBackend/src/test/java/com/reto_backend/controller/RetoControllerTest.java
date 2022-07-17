package com.reto_backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.reto_backend.entity.Response;

@SpringBootTest
public class RetoControllerTest {
	
	@Autowired
	private RetoController retoController;
	
	ResponseEntity<Response> response;

	@Test
	void contextLoads() {
		
	}
	
	@Test
	void verifySize() {
		response = (ResponseEntity<Response>) retoController.changeStructureJson();
		assertEquals(6, response.getBody().getData().size());
	}
	
	@Test
	void verifyIDsNumeric() {
		ResponseEntity<Response> response = (ResponseEntity<Response>) retoController.changeStructureJson();
		
		List<String> userDataList = response.getBody().getData().stream()
				.filter(this::validateNumeric).toList();
		
		assertEquals(6, userDataList.size());
	}
	
	@Test
	void verifyFieldEmpty() {
		response = (ResponseEntity<Response>) retoController.changeStructureJson();
		
		List<String> userDataList = response.getBody().getData().stream()
				.filter(this::validateFieldEmpty).toList();
		
		assertEquals(6, userDataList.size());
	}
	
	
	boolean validateFieldEmpty(String userData) {
		try {
			String[] userDataArray = userData.replace("|", "-").split("-");
			for (String data : userDataArray) {
				if(data.trim().isEmpty()) {
					return false;
				}
			}
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	boolean validateNumeric(String userData) {
		try {
			String id = userData.replace("|", "-").split("-")[0].trim();
			Integer.parseInt(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
