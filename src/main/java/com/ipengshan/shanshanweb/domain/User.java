package com.ipengshan.shanshanweb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_username` varchar(20) NOT NULL,
  `u_nickname` varchar(20) NOT NULL,
  `u_password` varchar(20) NOT NULL,
  `u_description` varchar(500) DEFAULT NULL,
  `u_icon` varchar(100) DEFAULT NULL,
  `u_mail` varchar(30) NOT NULL,
  `u_gender` int(11) DEFAULT '0',
  `u_phonenum` varchar(12) DEFAULT NULL,
  `u_createtime` datetime DEFAULT NULL,
  `u_other` varchar(100) DEFAULT NULL,
  `u_account_status` int(11) DEFAULT '1',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 * @author XiaoJing
 *
 */
@Table(name="user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@Column(name="u_id")
	private Integer id;
	
	
//	@JsonProperty("userName")
	@Column(name="u_username")
	private String userName;
	
	@Column(name="u_nickname")
	private String nickName;
	
	@Column(name="u_password")
	@JsonIgnore
	private String passWord;
	
	@Column(name="u_description")
	@JsonProperty("description")
	private String description;
	
	@Column(name="u_icon")
	private String icon;
	
	@Column(name="u_mail")
	private String eMail;
	
	@Column(name="u_gender")
	private Integer gender;
	
	@Column(name="u_phonenum")
	private String phoneNum;
	
	@Column(name="u_createtime")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT-8")
	private Date createTime;
	
	@Column(name="u_other")
	private String other;
	
	@Column(name="u_account_status")
	@JsonIgnore
	private Integer accountStatus;

	public User(Integer id, String userName, String nickName, String passWord,
			String description, String icon, String eMail, Integer gender,
			String phoneNum, Date createTime, String other,
			Integer accountStatus) {
		super();
		this.id = id;
		this.userName = userName;
		this.nickName = nickName;
		this.passWord = passWord;
		this.description = description;
		this.icon = icon;
		this.eMail = eMail;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.createTime = createTime;
		this.other = other;
		this.accountStatus = accountStatus;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", nickName="
				+ nickName + ", passWord=" + passWord + ", description="
				+ description + ", icon=" + icon + ", eMail=" + eMail
				+ ", gender=" + gender + ", phoneNum=" + phoneNum
				+ ", createTime=" + createTime + ", other=" + other
				+ ", accountStatus=" + accountStatus + "]";
	}
}