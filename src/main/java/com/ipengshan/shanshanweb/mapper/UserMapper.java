package com.ipengshan.shanshanweb.mapper;

import tk.mybatis.mapper.common.Mapper;

import com.ipengshan.shanshanweb.domain.User;

/**
 * 
 * @author XiaoJing
 *com.ipengshan.shanshanweb.mapper
 *下午5:04:49
 */

public interface UserMapper extends Mapper<User>{
	
	public User matchAcount(User user);
	
	public int findByMail(String mail);
	
	public int createAccount(User user);
	
	public void updateUserinfo(User user);
	

}
