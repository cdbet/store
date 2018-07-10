package cn.tedu.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tedu.store.service.StudentService;
//可以获取到动态代理类的辅助类
@Component
public class StudentProxyHandler implements InvocationHandler {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentAop studentAop;
	//获取动态代理类的方法
	//1.获取业务逻辑类类加载器对象
	//2.获取业务逻辑类的相关接口
	//3.设置实现了InvocationHandler接口的实现类对象
	public Object getObject() {
		return Proxy.newProxyInstance(studentService.getClass().getClassLoader(),studentService.getClass().getInterfaces()
				,this);
		
	}
							//代理对象		封装对象		
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		studentAop.log();
		method.invoke(studentService,args);
		//studentService.add();
		return null;
	}

}
