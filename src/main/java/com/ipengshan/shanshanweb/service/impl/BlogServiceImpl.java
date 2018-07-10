/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.ipengshan.shanshanweb.service.impl 
 * @author: xiaowei   
 * @date: 2018年7月4日 下午3:47:35 
 */
package com.ipengshan.shanshanweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ipengshan.shanshanweb.constant.Constant;
import com.ipengshan.shanshanweb.domain.Blog;
import com.ipengshan.shanshanweb.domain.BlogComment;
import com.ipengshan.shanshanweb.domain.BlogLike;
import com.ipengshan.shanshanweb.dto.BlogLikeAndComment;
import com.ipengshan.shanshanweb.dto.ResultJson;
import com.ipengshan.shanshanweb.mapper.BlogCommentMapper;
import com.ipengshan.shanshanweb.mapper.BlogLikeMapper;
import com.ipengshan.shanshanweb.mapper.BlogMapper;
import com.ipengshan.shanshanweb.service.BlogService;

/**
 * @author XiaoJing com.ipengshan.shanshanweb.service.impl 下午3:47:35
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private Constant cs;
	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private BlogLikeMapper blogLikeMapper;
	@Autowired
	private BlogCommentMapper blogCommentMapper;

	/**
	 * 分页获取blog 以及bloglike blogcomment
	 */
	@Override
	public ResultJson selectBlog(int startNum, String email) {
		ResultJson json = new ResultJson();
		PageHelper.startPage(startNum, 3);
		// 查询blog
		List<Blog> selectAllBlog = blogMapper.selectAll();
		if (selectAllBlog == null || selectAllBlog.size() <= 0) {
			json.setStatus(cs.FAIL);
			json.setResons("no more message");
			json.setData(null);
			return json;
		}
		List<BlogLikeAndComment> data = new ArrayList<BlogLikeAndComment>(
				selectAllBlog.size());
		// 文章对应的like
		List<BlogLike> likeList = blogLikeMapper.getLikeNum(selectAllBlog);
		// 文章对应的评论
		List<BlogComment> commentList = blogCommentMapper
				.getCommentList(selectAllBlog);
		BlogLikeAndComment blac;
		Blog blog;
		int allSize = selectAllBlog.size();
		int likeSize = likeList.size();
		int commentSize = commentList.size();
		for (int i = 0; i < allSize; i++) {
			blog = selectAllBlog.get(i);
			blac = new BlogLikeAndComment();
			blac.setBlog(blog);
			int blogid = blog.getId();
			for (int j = 0; j < likeSize; j++) {
				if (blogid == likeList.get(j).getbId()) {
					blac.addLike(likeList.get(j));
					if (email.equals(likeList.get(j).getEmail()))
						blac.setSelfLike(true);
				}
			}
			for (int f = 0; f < commentSize; f++) {
				if (blogid == commentList.get(f).getbId()) {
					blac.addComment(commentList.get(f));
				}
			}
			data.add(blac);
		}
		json.setStatus(cs.SUCCESS);
		json.setResons("execute success");
		json.setData(data);
		return json;
	}

	/**
	 * 通过@Transactional，实现了事务操作。 Spring的AOP即声明式事务管理默认是针对unchecked
	 * exception回滚。也就是默认对RuntimeException
	 * ()异常或是其子类进行事务回滚；checked异常,即Exception可try
	 * {}捕获的不会回滚，因此对于我们自定义异常，通过rollbackFor进行设定，后续会单独讲
	 * 如果我们需要捕获异常后，同时进行回滚，通过TransactionAspectSupport
	 * .currentTransactionStatus().setRollbackOnly();进行手动回滚操作。 使用Object
	 * savePoint =
	 * TransactionAspectSupport.currentTransactionStatus().createSavepoint();
	 * 设置回滚点，使用TransactionAspectSupport.currentTransactionStatus().
	 * rollbackToSavepoint(savePoint);回滚到savePoint。 点赞
	 * 
	 * @param blogLike
	 * @return
	 */

	@Transactional
	public ResultJson insertLikeForBlog(BlogLike blogLike) {
		ResultJson json = new ResultJson();
		int insert = blogLikeMapper.insert(blogLike);

		if (insert > 0) {
			json.setStatus(cs.SUCCESS);
			json.setResons("execute success");
			System.out.println("***************************************");
		} else {
			json.setStatus(cs.FAIL);
			json.setResons("execute fail");
		}
		/*
		 * if (insert > 0) { throw new RuntimeException(); }
		 */
		return json;
	}

	/**
	 * 取消点赞
	 * 
	 * @param blogLike
	 * @return
	 */
	public ResultJson deleteLikeForBlog(BlogLike blogLike) {
		ResultJson json = new ResultJson();
		int delete = -1;
		try {
			delete = blogLikeMapper.delete(blogLike);
		} catch (Exception e) {
			e.printStackTrace();
			json.setStatus(cs.FAIL);
			json.setResons("happed exception");
			return json;
		}
		if (delete >= 0) {
			json.setStatus(cs.SUCCESS);
			json.setResons("execute success");
		} else {
			json.setStatus(cs.FAIL);
			json.setResons("execute fail");
		}
		return json;
	}

	/**
	 * 插入一条评论
	 * 
	 * @param blogComment
	 * @return
	 */
	public ResultJson insertCommentBlog(BlogComment blogComment) {
		ResultJson json = new ResultJson();
		int insert = 0;
		insert = blogCommentMapper.insert(blogComment);
		if (insert >= 1) {
			json.setStatus(cs.SUCCESS);
			json.setResons("execute success");
		} else {
			json.setStatus(cs.FAIL);
			json.setResons("execute fail");
		}
		return json;
	}

	/**
	 * 删除某条评论
	 * 
	 * @param blogComment
	 * @return
	 */
	public ResultJson deleteCommentForBlog(BlogComment blogComment) {
		ResultJson json = new ResultJson();
		int delete = -1;
		try {
			delete = blogCommentMapper.delete(blogComment);
		} catch (Exception e) {
			e.printStackTrace();
			json.setStatus(cs.FAIL);
			json.setResons("happed exception");
			return json;
		}
		if (delete >= 1) {
			json.setStatus(cs.SUCCESS);
			json.setResons("execute success");
		} else {
			json.setStatus(cs.FAIL);
			json.setResons("execute fail");
		}
		return json;

	}
}
