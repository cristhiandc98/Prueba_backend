package com.reto_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.reto_backend.entity.Response;
import com.reto_backend.entity.UserFilterResponse;
import com.reto_backend.entity.UserResponse;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${my.url}")
	public String url;

	@Override
	public Response changeStructureJson(){
		try {
			UserFilterResponse userFilterResponse = (UserFilterResponse) restTemplate.getForEntity(url, UserFilterResponse.class).getBody();
			
			List<String> userDataList = new ArrayList<>();
			
			userFilterResponse.getData().stream()
				.forEach(userData -> userDataList.add(userData.toString()));
			
			return new Response(userDataList);
			
		}catch (Exception e) {
			return null;
		}
	}

}
