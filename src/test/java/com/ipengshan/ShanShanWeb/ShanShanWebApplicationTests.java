package com.ipengshan.ShanShanWeb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipengshan.shanshanweb.domain.User;
import com.ipengshan.shanshanweb.mapper.BlogMapper;
import com.ipengshan.shanshanweb.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShanShanWebApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BlogMapper blogMapper;
	
	@Test
	public void contextLoads() {
//		User user=new User();
//		user.setU_mail("932458047@qq.com");
//		user.setU_password("xiaojing5220");
//		System.out.println(userMapper.matchAcount(user).toString());
//		System.out.println(userMapper.findByMail("932458047@qq.com"));
		System.out.println(blogMapper.selectAllBlog().toString());
	}

}
