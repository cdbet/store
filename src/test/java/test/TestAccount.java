package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.mapper.AccountMapper;
import cn.tedu.store.service.IAccountService;

public class TestAccount {

	@Test
	public void select1() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AccountMapper am=ac.getBean("accountMapper",AccountMapper.class);
		System.out.println(am.select1());
	}
	@Test
	public void select2() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AccountMapper am=ac.getBean("accountMapper",AccountMapper.class);
		System.out.println(am.select1());
	}
	@Test
	public void update1() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AccountMapper am=ac.getBean("accountMapper",AccountMapper.class);
		am.update1("10001",am.select1()+1000);
		am.update2("10002",am.select2()+1000);
	}
	@Test
	public void account1() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAccountService as=ac.getBean("accountService",IAccountService.class);
		as.account("10001","10002",1);
	}
	@Test
	public void account2() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAccountService as=ac.getBean("accountService",IAccountService.class);
		as.account("10001","10003",1);
	}
}

