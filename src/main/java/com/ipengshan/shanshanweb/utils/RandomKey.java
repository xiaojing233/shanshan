package com.ipengshan.shanshanweb.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomKey {
	
	public static int generate6Num(){
		int num=new Random().nextInt(999999);
		if(num<100000){
			num+=100000;
		}
		return num;
	}

}
