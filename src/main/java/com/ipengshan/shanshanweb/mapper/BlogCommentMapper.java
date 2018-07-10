package com.ipengshan.shanshanweb.mapper;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import com.ipengshan.shanshanweb.domain.Blog;
import com.ipengshan.shanshanweb.domain.BlogComment;

public interface BlogCommentMapper extends Mapper<BlogComment> {
	public List<BlogComment> getCommentList(List<Blog> list);

}
