package com.ipengshan.shanshanweb.domain;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * `bc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键', `b_id` int(11) NOT
 * NULL COMMENT 'blog主键id', `bc_content` varchar(500) NOT NULL COMMENT '评论的内容',
 * `bc_createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论的时间',
 * `bc_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '评论的文章还是评论的别人的评论', `u_mail`
 * varchar(40) NOT NULL COMMENT '评论人的邮箱'
 * 
 * @author XiaoJing
 *
 *         2018年7月5日 com.ipengshan.shanshanweb.domain
 */
public class BlogComment {
	@Id
	@Column(name = "bc_id")
	private Integer id;
	@JsonIgnore
	@Column(name = "b_id")
	private Integer bId;
	@Column(name = "bc_content")
	private String content;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-8")
	@Column(name = "bc_createtime")
	private Date createTime;
	@Column(name = "bc_type")
	private Integer belongId;
	@Column(name = "u_mail")
	private String email;

	public BlogComment() {
		super();
	}

	public BlogComment(Integer id, Integer bId, String content,
			Date createTime, Integer belongId, String email) {
		super();
		this.id = id;
		this.bId = bId;
		this.content = content;
		this.createTime = createTime;
		this.belongId = belongId;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getBelongId() {
		return belongId;
	}

	public void setBelongId(Integer belongId) {
		this.belongId = belongId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BlogComment [id=" + id + ", bId=" + bId + ", content="
				+ content + ", createTime=" + createTime + ", belongId="
				+ belongId + ", email=" + email + "]";
	}

}
