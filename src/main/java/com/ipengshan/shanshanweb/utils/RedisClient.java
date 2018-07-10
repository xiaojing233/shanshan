package com.ipengshan.shanshanweb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作
stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val
stringRedisTemplate.boundValueOps("test").increment(1);//val +1
stringRedisTemplate.getExpire("test")//根据key获取过期时间
stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位
stringRedisTemplate.delete("test");//根据key删除缓存
stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值
stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间
stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据
stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合


StringRedisTemplate(String序列化)与RedisTemplate(JDK序列化)保存的数据不互通
 * @author xiaowei
 *
 */
@Component
public class RedisClient {
	
	/**
	 * 操作字符串
	 */
	@Autowired
	private StringRedisTemplate strRedisTpl;
	/**
	 * 操作复杂实体类对象
	 */
	@Autowired
	private RedisTemplate<Object, Object>redisTpl;
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key,String value){
		try{
			strRedisTpl.opsForValue().set(key, value);
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public String get(String key){
	return strRedisTpl.opsForValue().get(key);
	}
}
