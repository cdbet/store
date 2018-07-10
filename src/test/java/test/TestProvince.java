package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.xml.internal.bind.v2.model.core.ID;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.service.IDictService;

public class TestProvince {
	@Test
	public void selectProvince() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dm=ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dm.selectProvince());
	}
	@Test
	public void getProvince() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IDictService ds=ac.getBean("dictService",IDictService.class);
		System.out.println(ds.getProvince());
	}
	@Test
	public void selectCity() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dm=ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dm.selectCity("370000"));
	}
	@Test
	public void getCity() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IDictService ds=ac.getBean("dictService",IDictService.class);
		System.out.println(ds.getCity("370000"));
	}
	@Test
	public void selectArea() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dm=ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dm.selectArea("370400"));
	}
	@Test
	public void getArea() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IDictService ds=ac.getBean("dictService",IDictService.class);
		System.out.println(ds.getArea("370400"));
	}
	@Test
	public void selectPovinceNameByCode() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dm=ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dm.selectProvinceNameByCode("370000"));
	}
	@Test
	public void selectCityNameByCode() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dm=ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dm.selectCityNameByCode("370400"));
	}
	@Test
	public void selectAreaNameByCode() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dm=ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dm.selectAreaNameByCode("370401"));
	}
	@Test
	public void sssss() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper am=ac.getBean("addressMapper",AddressMapper.class);
		Address ad=new Address();
		ad.setUid(1);
		ad.setRecvAddress("…œ∫£");
		am.insertAddress(ad);
	}

}
