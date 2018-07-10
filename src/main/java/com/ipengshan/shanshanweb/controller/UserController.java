package com.ipengshan.shanshanweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipengshan.shanshanweb.dto.ResultJson;
import com.ipengshan.shanshanweb.mapper.UserMapper;
import com.ipengshan.shanshanweb.service.impl.UserServiceImpl;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired 
	UserMapper userMapper;
	

	@RequestMapping("/login")
	public ResultJson matchAccount(
			@RequestParam(value="username",defaultValue="0") String username,
			@RequestParam(value="password",defaultValue="0")String password ){
		return userServiceImpl.matchAccount(username,password);
	}
	
	@RequestMapping("/mailusable")
	public ResultJson mailUsable(String email){
		return userServiceImpl.findByMail(email);
	}	
	
	@RequestMapping("/createAccount")
	public ResultJson createAccount(String email,String password){
		return userServiceImpl.createAccount(email, password);
	}
}
