package cn.tedu.store.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//切面
@Component
@Aspect
public class Log {
	//在userService业务层的所有的业务方法之前执行
	@Before("bean(userService)")
	public void test1() {
		System.out.println("业务方法之前执行...");
	}
	//最终通知
	//在userService业务层的所有的业务方法之后执行
	@After("bean(userService)")
	public void test2() {
		System.out.println("业务方法之后执行");
	}
	//后置通知
	//在userService业务层的所有的业务方法之后执行
	@AfterReturning("bean(userService)")
	public void test3() {
		System.out.println("业务方法之后执行(后置通知)");
	}
	//异常通知
	//当业务方法出现异常的时候执行
	@AfterThrowing("bean(userService)")
	public void test4() {
		System.out.println("业务异常之后执行(异常通知)");
	}
	//环绕通知
	/**
	 * 1.必须有返回值，返回业务层方法的返回值
	 * 2.必须有参数
	 * 3.调用proceed
	 * @throws Throwable 
	 */
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("开始时间"+System.nanoTime());
		Object obj=jp.proceed();//表示调用业务层方法
		System.out.println("结束时间"+System.nanoTime());
		
		return obj;
		
	}
}
