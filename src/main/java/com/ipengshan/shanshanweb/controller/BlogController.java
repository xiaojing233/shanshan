/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.ipengshan.shanshanweb.controller 
 * @author: xiaowei   
 * @date: 2018年7月4日 下午4:38:16 
 */
package com.ipengshan.shanshanweb.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipengshan.shanshanweb.domain.BlogComment;
import com.ipengshan.shanshanweb.domain.BlogLike;
import com.ipengshan.shanshanweb.dto.ResultJson;
import com.ipengshan.shanshanweb.service.impl.BlogServiceImpl;

/**
 * @author XiaoJing com.ipengshan.shanshanweb.controller 下午4:38:16
 */
@RestController
@RequestMapping("/api/v1/")
public class BlogController {

	@Autowired
	private BlogServiceImpl blogServiceImpl;

	@RequestMapping("blog")
	public ResultJson selectBlog(
			@RequestParam(defaultValue = "1") int startNum,
			@RequestParam(required = true) String email) {
		return blogServiceImpl.selectBlog(startNum, email);
	}

	@RequestMapping("addBlogComment")
	public ResultJson insertCommentForBlog(BlogComment blogComment) {
		if (blogComment.getCreateTime() == null) {
			blogComment.setCreateTime(new Date());
		}
		return blogServiceImpl.insertCommentBlog(blogComment);
	}

	@RequestMapping("deleteBlogComment")
	public ResultJson deleteCommentForBlog(BlogComment blogComment) {
		return blogServiceImpl.deleteCommentForBlog(blogComment);
	}

	@RequestMapping("addBlogLike")
	public ResultJson insertLikeForBlog(BlogLike blogLike) {
		return blogServiceImpl.insertLikeForBlog(blogLike);
	}

	@RequestMapping("deleteBlogLike")
	public ResultJson deleteLikeForBlog(BlogLike blogLike) {
		return blogServiceImpl.deleteLikeForBlog(blogLike);
	}
}
