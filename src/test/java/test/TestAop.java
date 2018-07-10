package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.aop.StudentProxyHandler;
import cn.tedu.store.service.IStudentService;

public class TestAop{
	
	@Test
	public void test1() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-service.xml","spring-aop.xml","spring-dao.xml");
		//获取代理对象
		IStudentService ss=ac.getBean("studentProxy",IStudentService.class);
		ss.add();
	}
	@Test
	public void test2() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-service.xml","spring-aop.xml","spring-dao.xml");
		StudentProxyHandler ph=ac.getBean("studentProxyHandler",StudentProxyHandler.class);
		IStudentService ss=(IStudentService) ph.getObject();
		ss.add();
	}

}
