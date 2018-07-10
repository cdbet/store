package test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.controller.UserController;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;

public class TestUser {

	@Test
	public void insertTest() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-mvc.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setUsername("渣渣辉");
		user.setPassword("123456");
		user.setPhone("12345666");
		user.setEmail("123456@tedu.cn");
		user.setImage("123");
		um.insertUser(user);
		ac.close();
	}
	
	@Test
	public void  selectByIdTest() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		System.out.println(um.selectByUsername("渣渣辉"));
		ac.close();
	}
	@Test
	public void UserServiceTest() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		//多态：一种类型指向不同对象
		//代码：Animal dog=new Dog();
		//      Animal bird=new Bird();
		IUserService us=ac.getBean("userService",IUserService.class);
		User user=new User();
		user.setUsername("zhangsan");
		user.setPassword("654321");
		user.setPhone("12345678910");
		user.setEmail("112356456@tedu.cn");
		user.setImage("464684");
		user.setCreatedUser("123564");
		user.setCreatedTime(new Date());
		us.register(user);
		ac.close();
	}
	@Test 
	public void selectEmail() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		System.out.println(um.selectEmail("12345w6@tedu.cn"));
		ac.close();
	}
	@Test
	public void selectEmailTest() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		System.out.println(us.checkEmail("123456@tedu.cn"));
		ac.close();
	}
	@Test 
	public void selectPhone() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		System.out.println(um.selectPhone("12345666"));
		ac.close();
	}
	@Test
	public void selectPhoneTest() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		System.out.println(us.checkphone("123456661"));
		ac.close();
	}
	@Test
	public void selectUserNameTest() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		System.out.println(us.checkUsername("渣渣辉1"));
		ac.close();
	}
	@Test
	public void test() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		User user=new User();
		
		us.login("shuaige1", "nihao11");
	}
	@Test
	public void Testt() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setId(3);
//		user.setPassword("gutianle");
		user.setPhone("75314331231");
		us.updateUser(user);
	}
	@Test
	public void Test1() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		
		
		
		System.out.println(us.selectById(3));
	}
	@Test
	public void update() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		us.changePassword(3,"gutianle","zhazhahui");
	}
	@Test
	public void Testtt() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		us.updateUser(3,"gutianle",0,"123456","123456789@tedu.cn");
				
	}
	@Test
	public void testImage() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		us.upDateImage("3",3);
	}
	

}
