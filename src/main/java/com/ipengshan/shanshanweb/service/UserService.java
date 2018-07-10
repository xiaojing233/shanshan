package com.ipengshan.shanshanweb.service;

import com.ipengshan.shanshanweb.dto.ResultJson;

public interface UserService {
	
	public ResultJson matchAccount(String username,String password);
	
	public ResultJson  findByMail(String mail);
	
	public ResultJson sendSecurityCode(String emailAddress);
}
