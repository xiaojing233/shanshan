package com.ipengshan.shanshanweb.dto;

import java.util.ArrayList;
import java.util.List;

import com.ipengshan.shanshanweb.domain.Blog;
import com.ipengshan.shanshanweb.domain.BlogComment;
import com.ipengshan.shanshanweb.domain.BlogLike;

public class BlogLikeAndComment {
	private Blog blog;
	private List<BlogLike> likeList;
	private List<BlogComment> commentList;
	private boolean selfLike;

	public BlogLikeAndComment() {
		super();
	}

	public BlogLikeAndComment(Blog blog, List<BlogLike> likeList,
			List<BlogComment> commentList, Boolean selfLike) {
		super();
		this.blog = blog;
		this.likeList = likeList;
		this.commentList = commentList;
		this.selfLike = selfLike;
	}

	public void addLike(BlogLike bl) {
		if (likeList == null) {
			likeList = new ArrayList<BlogLike>();
		}
		likeList.add(bl);
	}

	public void addComment(BlogComment bc) {
		if (commentList == null) {
			commentList = new ArrayList<BlogComment>();
		}
		commentList.add(bc);
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<BlogLike> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<BlogLike> likeList) {
		this.likeList = likeList;
	}

	public List<BlogComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<BlogComment> commentList) {
		this.commentList = commentList;
	}

	public Boolean getSelfLike() {
		return selfLike;
	}

	public void setSelfLike(boolean selfLike) {
		this.selfLike = selfLike;
	}

	@Override
	public String toString() {
		return "BlogLikeAndComment [blog=" + blog + ", likeList=" + likeList
				+ ", commentList=" + commentList + ", selfLike=" + selfLike
				+ "]";
	}

}
