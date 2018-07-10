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

//����
@Component
@Aspect
public class Log {
	//��userServiceҵ�������е�ҵ�񷽷�֮ǰִ��
	@Before("bean(userService)")
	public void test1() {
		System.out.println("ҵ�񷽷�֮ǰִ��...");
	}
	//����֪ͨ
	//��userServiceҵ�������е�ҵ�񷽷�֮��ִ��
	@After("bean(userService)")
	public void test2() {
		System.out.println("ҵ�񷽷�֮��ִ��");
	}
	//����֪ͨ
	//��userServiceҵ�������е�ҵ�񷽷�֮��ִ��
	@AfterReturning("bean(userService)")
	public void test3() {
		System.out.println("ҵ�񷽷�֮��ִ��(����֪ͨ)");
	}
	//�쳣֪ͨ
	//��ҵ�񷽷������쳣��ʱ��ִ��
	@AfterThrowing("bean(userService)")
	public void test4() {
		System.out.println("ҵ���쳣֮��ִ��(�쳣֪ͨ)");
	}
	//����֪ͨ
	/**
	 * 1.�����з���ֵ������ҵ��㷽���ķ���ֵ
	 * 2.�����в���
	 * 3.����proceed
	 * @throws Throwable 
	 */
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("��ʼʱ��"+System.nanoTime());
		Object obj=jp.proceed();//��ʾ����ҵ��㷽��
		System.out.println("����ʱ��"+System.nanoTime());
		
		return obj;
		
	}
}
