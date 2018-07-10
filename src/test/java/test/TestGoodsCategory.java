package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.service.IGoodsCategoryService;



public class TestGoodsCategory {

	@Test
	public void selectByPid() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsCategoryMapper gc=ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		System.out.println(gc.selectByParentId(162,null,3));
	}
	@Test 
	public void getGCByID() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsCategoryService gs=ac.getBean("goodsCategoryService",IGoodsCategoryService.class);
		System.out.println(gs.getGoodsCategoryByParentId(162,null,null));
	}
}
