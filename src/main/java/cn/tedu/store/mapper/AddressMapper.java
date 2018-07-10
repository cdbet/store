package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {

	/**
	 * �����ջ�����Ϣ
	 * @param address
	 */
	void insertAddress(Address address);
	/**
	 * ��ѯ��¼�û����ջ���ַ
	 * @param uid
	 * @return
	 */
	List<Address>selectByUid(Integer uid);
	//���õ�¼�û����ջ���ַΪ0
	Integer setCancel(Integer uid);
	//�ѵ�ǰ���ջ���ַ����Ϊ1
	Integer setDefault(Integer id);
	/**
	 * ��ѯ�ջ���ַ��Ϣ
	 * @param id
	 * @return
	 */
	Address selectById(Integer id);
	
	void updateAddressById(Address address);
	
	void deleteById(Integer id);
}
