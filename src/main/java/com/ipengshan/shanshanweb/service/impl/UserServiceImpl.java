package com.ipengshan.shanshanweb.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipengshan.shanshanweb.constant.Constant;
import com.ipengshan.shanshanweb.domain.User;
import com.ipengshan.shanshanweb.dto.ResultJson;
import com.ipengshan.shanshanweb.mapper.UserMapper;
import com.ipengshan.shanshanweb.service.UserService;
import com.ipengshan.shanshanweb.utils.RandomKey;
import com.ipengshan.shanshanweb.utils.RedisClient;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private Constant cs;
	
	@Autowired
	RedisClient rsClient;

	@Override
	public ResultJson matchAccount(String username, String password) {
		User user=new User();
		user.setUserName(username);
		user.seteMail(username);
		user.setPassWord(password);
		User result=userMapper.matchAcount(user);
		if(result!=null){
			
			return new ResultJson(cs.SUCCESS, "账号密码正确", result,null); 
		}
		return new ResultJson(cs.FAIL, "账号或密码错误", result,null) ;
	}

	@Override
	public ResultJson findByMail(String mail) {
		User user=new User();
		user.seteMail(mail);
		User selectOne = userMapper.selectOne(user);
		
//		int result=userMapper.findByMail(mail);
		ResultJson json=new ResultJson();
		if(selectOne!=null){
			json.setStatus(cs.FAIL);
			json.setResons("邮箱已被注册");
			return json;
		}
		json.setStatus(cs.SUCCESS);
		json.setResons("邮箱可用");
		return json;
	}
	
	@Override
	public ResultJson sendSecurityCode(String emailAddress) {
		ResultJson json=new ResultJson();
		int num=RandomKey.generate6Num();
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		 props.setProperty("mail.smtp.host", "smtp.163.com");
//		 props.setProperty("mail.smtp.host", "smtp.qq.com");
		 props.setProperty("mail.smtp.port", "25");
		 // 指定验证为true
		 props.setProperty("mail.smtp.auth", "true");
//		 props.setProperty("mail.smtp.timeout","1000");
		 // 验证账号及密码，密码需要是第三方授权码
		 Authenticator authenticator=new Authenticator() {
			 @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("xiaojing_31@163.com", "xiaojing5233");
			}
		};
		
		Session session=Session.getInstance(props,authenticator);
		session.setDebug(true);
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("xiaojing_31@163.com"));
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(emailAddress));
			//隐式抄送
			message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("932458047@qq.com"));
			message.setSubject("ShanShan--App注册验证码");
			message.setContent("尊敬的用户 ,您好:<br/>"
					+ "为确保是您本人操作,请在邮件验证码输入框输入下方验证码:<br/>"
					+ "<b>609979</b><br/>"
					+ "请勿向任何人泄露<br/>"
					+ "此致----Bob-J", "text/html;charset=utf-8");
			Transport.send(message);
		} catch (MessagingException e) {
			json.setStatus(cs.FAIL);
			json.setResons("邮件发送异常");
			e.printStackTrace();
			return json;
		}
		json.setStatus(cs.SUCCESS);
		json.setResons("邮件发送成功");
		rsClient.set(emailAddress, num+"");
		
		return json;
	}
	
	
	public ResultJson createAccount(String mail,String password){
		ResultJson json=new ResultJson();
		
		User user=new User();
		user.seteMail(mail);
		if(userMapper.selectOne(user)!=null){
			json.setStatus(cs.FAIL);
			json.setResons("该邮箱已被注册");
			return json;
		}
		if(password==null||password.trim().equals("")){
			json.setStatus(cs.FAIL);
			json.setResons("密码不能为空");
			return json;
		}
		user.setPassWord(password);
		try{
			int insert = userMapper.insert(user);
			if(insert<=0){
				json.setStatus(cs.FAIL);
				json.setResons("创建用户失败,请仔细检查后重新提交");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.setStatus(cs.FAIL);
			json.setResons("创建用户失败,请仔细检查后重新提交E");
		}
		json.setStatus(cs.SUCCESS);
		json.setResons("创建用户成功");
		return json;
	}
	

}
