/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.ipengshan.shanshanweb.base 
 * @author: Jing   
 * @date: 2018年7月2日 下午4:54:50 
 */
package com.ipengshan.shanshanweb.base;

import java.util.List;

/**
 * @author XiaoJing
 *com.ipengshan.shanshanweb.base
 *下午4:54:50
 */
public interface BaseService<T> {
	  List<T> list(T entity);

	    T get(T entity);

	    int update(T entity);

	    int save(T entity);

	    int delete(T entity);
}
