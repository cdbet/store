package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;

public class CartTest {

	@Test
	public void insertCart() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cm=ac.getBean("cartMapper",CartMapper.class);
		Cart cart=new Cart();
		cart.setUid(1);
		cart.setNum(99);
		cart.setGoodsId("1000000");
		
		cm.insertCart(cart);
	}
	@Test
	public void addCart() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		ICartService cm=ac.getBean("cartService",ICartService.class);
		Cart cart=new Cart();
		cart.setUid(1);
		cart.setNum(999);
		cart.setGoodsId("10000007");
		
		cm.addCart(cart);
	}
	@Test
	public void selectByUid() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cm=ac.getBean("cartMapper",CartMapper.class);
		System.out.println(cm.selectByUid(3));
		
		
	}
	@Test
	public void deleteByIds() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cm=ac.getBean("cartMapper",CartMapper.class);
		Integer[]ids= {1,2};
		cm.deleteByIds(ids);
		
		
	}
	@Test
	public void upByIds() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cm=ac.getBean("cartMapper",CartMapper.class);
		cm.updateById(8,99);
		
		
	}
	@Test
	public void getOrd() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		ICartService cm=ac.getBean("cartService",ICartService.class);
		Integer[] a= {7,8};
		System.out.println(cm.getOrder(3,a));
	}
}
