package com.reto_backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.reto_backend.entity.Response;
import com.reto_backend.entity.UserFilterResponse;
import com.reto_backend.entity.UserResponse;

public class UserServiceTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	UserFilterResponse userFilterResponse;
	
	@BeforeEach
	public void setUp() {		
		MockitoAnnotations.initMocks(this);		

		UserResponse user1 = new UserResponse(1, "Bluth", "george.bluth@reqres.in");
		UserResponse user2 = new UserResponse(2, "Weaver", "janet.weaver@reqres.in");
		UserResponse user3 = new UserResponse(3, "Wong", "emma.wong@reqres.in");
		UserResponse user4 = new UserResponse(4, "Holt", "eve.holt@reqres.in");
		UserResponse user5 = new UserResponse(5, "Morris", "charles.morris@reqres.in");
		UserResponse user6 = new UserResponse(6, "Ramos", "tracey.ramos@reqres.in");
		List<UserResponse> usersList = new ArrayList<>();
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		usersList.add(user4);
		usersList.add(user5);
		usersList.add(user6);
		userFilterResponse = new UserFilterResponse(usersList);
		
		userService.url = "https://reqres.in/api/users";
		
		Mockito.when(restTemplate
				.getForEntity("https://reqres.in/api/users", UserFilterResponse.class))
		.thenReturn(new ResponseEntity<UserFilterResponse>(userFilterResponse, null, 200));
	}
	
	@Test
	void verifyURL() {

		userService.url = "https://reqres.in/api/v2/users";

		assertEquals(null, userService.changeStructureJson());
	}
	
	@Test
	void verifyUser() {
		List<String> userDataList = userService.changeStructureJson().getData();
		
		assertEquals("3 | Wong | emma.wong@reqres.in", userDataList.get(2));
	}
	
	@Test
	void verifySize() {

		userFilterResponse.addData(new UserResponse(7, "Eduardo", "eduardo@gmail.com"));
		
		List<String> userFilterResponse = userService.changeStructureJson().getData();
		
		assertEquals(7, userFilterResponse.size());
	}

}
