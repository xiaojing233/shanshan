/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.ipengshan.shanshanweb.domain 
 * @author: xiaowei   
 * @date: 2018年7月4日 下午3:13:48 
 */
package com.ipengshan.shanshanweb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author XiaoJing
 *com.ipengshan.shanshanweb.domain
 *下午3:13:48
 */
@Table(name="blog")
public class Blog {
	
	@Id
	@Column(name="b_id")
	private Integer id;
	@Column(name="u_mail")
	private String email;
	@Column(name="b_content")
	private String content;
	@Column(name="b_url")
	private  String url;
	@Column(name="b_createtime")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT-8")
	private Date createTime;
	@Column(name="b_flag")
	private Integer flag;
	
	public Blog() {
		super();
	}

	public Blog(Integer id, String email, String content, String url,
			Date createTime, Integer flag) {
		super();
		this.id = id;
		this.email = email;
		this.content = content;
		this.url = url;
		this.createTime = createTime;
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", email=" + email + ", content=" + content
				+ ", url=" + url + ", createTime=" + createTime + ", flag="
				+ flag + "]";
	}
	
	

}
