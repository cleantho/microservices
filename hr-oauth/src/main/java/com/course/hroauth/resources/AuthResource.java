package com.course.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.hroauth.entities.User;
import com.course.hroauth.services.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private AuthService service;

	@GetMapping(value = "/user")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			User obj = service.findByEmail(email);
			return ResponseEntity.ok(obj);
		} catch (IllegalArgumentException e) {
			//return ResponseEntity.notFound().build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();			
		}
	}

}
