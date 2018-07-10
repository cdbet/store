package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
@Transactional
public interface IAddressService {

	void addAddress(Address address);
	List<Address>getAllAddressByUid(Integer uid);
	void setDefault(Integer uid,Integer id);
	
	Address getAddressById(Integer id);
	
	void updateAddressById(Address address);
	
	void deleteAddressById(Integer id);
}
