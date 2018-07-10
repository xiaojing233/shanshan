package com.ipengshan.shanshanweb.mapper;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import com.ipengshan.shanshanweb.domain.Blog;
import com.ipengshan.shanshanweb.domain.BlogLike;

public interface BlogLikeMapper extends Mapper<BlogLike> {
	public List<BlogLike> getLikeNum(List<Blog> list);

	public int clickLike(BlogLike blogLike);

	public int cancleLike(BlogLike blogLike);
}
