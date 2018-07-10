package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;

public class TestAddress {

	@Test
	public void ssssss() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper am=ac.getBean("addressMapper",AddressMapper.class);
		Address ad=new Address();
		ad.setUid(2);
		ad.setRecvName("小白");
		ad.setRecvCity("130100");
		ad.setRecvArea("130102");
		ad.setRecvAddress("中鼎大厦");
		ad.setRecvDistric("河北省");
		ad.setRecvPhone("12345678911");
		ad.setRecvTel("7552146");
		
		
		am.insertAddress(ad);
	}
	@Test
	public void SelectByUid() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper am=ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(am.selectByUid(2));
	}
	@Test
	public void testAddress() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as=ac.getBean("addressService",IAddressService.class);
		Address ad=new Address();
		ad.setUid(3);
		ad.setRecvName("小菜");
		ad.setRecvProvince("130000");
		ad.setRecvCity("130100");
		ad.setRecvArea("130102");
		ad.setRecvAddress("中鼎大厦");
		ad.setRecvDistric("河北省");
		ad.setRecvPhone("12345678911");
		ad.setRecvTel("7552146");
		ad.setRecvZip("100000");
		ad.setRecvTag("公司");
		as.addAddress(ad);
	}
	@Test
	public void testGByUid() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as=ac.getBean("addressService",IAddressService.class);
		System.out.println(as.getAllAddressByUid(3));
	}
	@Test
	public void testSetCancel() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper am=ac.getBean("addressMapper",AddressMapper.class);
//		am.setCancel(3);
		am.setDefault(3);
	}
	@Test
	public void getAddressById() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as=ac.getBean("addressService",IAddressService.class);
		System.out.println(as.getAddressById(6));
	}
	@Test
	public void Update() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper am=ac.getBean("addressMapper",AddressMapper.class);
		Address address=new Address();
		address.setId(6);
		address.setRecvName("古天乐");
		am.updateAddressById(address);
	}
	@Test
	public void Updadada() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as=ac.getBean("addressService",IAddressService.class);
		Address address=new Address();
		address.setId(6);
		address.setRecvName("沙僧");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130102");
		address.setRecvAddress("渣渣村");
		address.setRecvPhone("12345678910");
		address.setRecvTel("7531433");
		address.setRecvZip("100000");
		address.setRecvTag("宿");
		

		
		as.updateAddressById(address);
	}
	@Test
	public void Delete() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper am=ac.getBean("addressMapper",AddressMapper.class);
		am.deleteById(7);
	}
	@Test
	public void DeleteById() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as=ac.getBean("addressService",IAddressService.class);
		as.deleteAddressById(13);
	}
}
