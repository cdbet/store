package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

public class TestGoods {

	@Test
	public void selectId() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsMapper gm=ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(gm.selectByIdCacategoryId(163,0,3));
	}
	@Test
	public void getId() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsService gm=ac.getBean("goodsService",IGoodsService.class);
		System.out.println(gm.getByCategoryId(163,0,3));
	}
	@Test
	public void selectCount() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsMapper gm=ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(gm.selectCount(163));
	}
	@Test
	public void getCount() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsService gm=ac.getBean("goodsService",IGoodsService.class);
		System.out.println(gm.getCount(163));
//		System.out.println(gm.getGoodsById("10000008"));
	}
	@Test
	public void getGoodsById() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsService gm=ac.getBean("goodsService",IGoodsService.class);
//		System.out.println(gm.getCount(163));
		System.out.println(gm.getGoodsById("10000008"));
	}
}
