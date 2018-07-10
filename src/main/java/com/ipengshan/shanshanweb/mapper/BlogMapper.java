/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.ipengshan.shanshanweb.mapper 
 * @author: xiaowei   
 * @date: 2018年7月4日 下午3:46:10 
 */
package com.ipengshan.shanshanweb.mapper;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import com.ipengshan.shanshanweb.domain.Blog;

/**
 * @author XiaoJing com.ipengshan.shanshanweb.mapper 下午3:46:10
 */
public interface BlogMapper extends Mapper<Blog> {

	public List<Blog> selectAllBlog();

}
