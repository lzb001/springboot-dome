package com.jk.aop;

import com.jk.model.User;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;



public class AopLog implements AfterReturningAdvice {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * result   原请求的执行结果
	 * method 	原请求执行的方法
	 * params	原请求的参数
	 * arg3		原请求切点的所在类
	 */
	public void afterReturning(Object result, Method method, Object[] params, Object arg3) throws Throwable {
		System.out.println(result);
		System.out.println(method.getName());
		System.out.println(params);
		System.out.println(arg3);
		
//		将操作记录存储到mongodb中
//		1.需要存储的字段：方法名、 时间、谁请求的、方法的参数、方法结果 
		User logPojo = new User();
		logPojo.setMethodname(method.getName());
		logPojo.setParams(params);
		logPojo.setResult(result);
		logPojo.setCredate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
//		2.调用mongotemplate 存数据
		mongoTemplate.insert(logPojo);
		
		
	}

}

