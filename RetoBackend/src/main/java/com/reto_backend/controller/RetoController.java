package com.reto_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto_backend.entity.Response;
import com.reto_backend.service.IUserService;
import com.reto_backend.service.UserServiceImpl;

@RestController
@RequestMapping("/reto")
public class RetoController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping
	public ResponseEntity<?> changeStructureJson(){
		try {
			Response response = userService.changeStructureJson();
			
			if(response != null) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
