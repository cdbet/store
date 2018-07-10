package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {

	/**
	 * 插如收货人信息
	 * @param address
	 */
	void insertAddress(Address address);
	/**
	 * 查询登录用户的收货地址
	 * @param uid
	 * @return
	 */
	List<Address>selectByUid(Integer uid);
	//设置登录用户的收货地址为0
	Integer setCancel(Integer uid);
	//把当前的收货地址设置为1
	Integer setDefault(Integer id);
	/**
	 * 查询收货地址信息
	 * @param id
	 * @return
	 */
	Address selectById(Integer id);
	
	void updateAddressById(Address address);
	
	void deleteById(Integer id);
}
