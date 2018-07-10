/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.ipengshan.shanshanweb.base 
 * @author: xiaowei   
 * @date: 2018年7月2日 下午4:58:45 
 */
package com.ipengshan.shanshanweb.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author XiaoJing com.ipengshan.shanshanweb.base 下午4:58:45
 */
public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private Mapper<T> mapper;

	@Override
	public List<T> list(T entity) {
		return mapper.select(entity);
	}

	@Override
	public T get(T entity) {
		return mapper.selectOne(entity);
	}

	@Override
	public int update(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int save(T entity) {
		return mapper.insertSelective(entity);
	}

	@Override
	public int delete(T entity) {
		return mapper.deleteByPrimaryKey(entity);
	}
}
