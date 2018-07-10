package cn.tedu.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tedu.store.service.StudentService;
//���Ի�ȡ����̬������ĸ�����
@Component
public class StudentProxyHandler implements InvocationHandler {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentAop studentAop;
	//��ȡ��̬������ķ���
	//1.��ȡҵ���߼��������������
	//2.��ȡҵ���߼������ؽӿ�
	//3.����ʵ����InvocationHandler�ӿڵ�ʵ�������
	public Object getObject() {
		return Proxy.newProxyInstance(studentService.getClass().getClassLoader(),studentService.getClass().getInterfaces()
				,this);
		
	}
							//�������		��װ����		
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		studentAop.log();
		method.invoke(studentService,args);
		//studentService.add();
		return null;
	}

}
