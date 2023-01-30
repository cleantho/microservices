package com.course.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.hroauth.entities.User;
import com.course.hroauth.feignclients.UserFeignClient;


@Service
public class AuthService {
	private static Logger log = LoggerFactory.getLogger(AuthService.class);

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User obj = userFeignClient.findByEmail(email).getBody();
		if(obj == null) {
			log.error("---> Email  not found");
			throw new IllegalArgumentException("Email not found");
		}
		log.info("---> Email found: " + email);
		return obj;
	}
}
