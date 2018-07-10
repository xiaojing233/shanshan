/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.ipengshan.shanshanweb.service 
 * @author: xiaowei   
 * @date: 2018年7月4日 下午3:47:16 
 */
package com.ipengshan.shanshanweb.service;

import com.ipengshan.shanshanweb.dto.ResultJson;

/**
 * @author XiaoJing com.ipengshan.shanshanweb.service 下午3:47:16
 */
public interface BlogService {
	public ResultJson selectBlog(int startNum, String email);
}
