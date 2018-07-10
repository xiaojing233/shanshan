package com.ipengshan.shanshanweb.domain;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "blog_like")
public class BlogLike {
	// @JsonIgnore(value = true)
	// @Id
	// @Column(name = "bl_id")
	// private Integer id;
	@Column(name = "u_mail")
	private String email;
	@Column(name = "b_id")
	private Integer bId;

	// @Column(name = "bl_create")
	// @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-8")
	// private Date createTime;
	public BlogLike() {
		super();
	}

	public BlogLike(String email, Integer bId) {
		super();
		this.email = email;
		this.bId = bId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	@Override
	public String toString() {
		return "BlogLike [email=" + email + ", bId=" + bId + "]";
	}

}
