package cn.tedu.store.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestPonitCut {

	@Before("execution(* cn.tedu.store.service.*Service.login(..))")
	public void test() {
		System.out.println("����login����");
	}
}


