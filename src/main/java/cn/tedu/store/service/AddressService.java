package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;

@Service
public class AddressService implements IAddressService {
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;

	public String getDistric(Address address) {
		String ad1 = dictMapper.selectProvinceNameByCode(address.getRecvProvince());
		String ad2 = dictMapper.selectCityNameByCode(address.getRecvCity());
		String ad3 = dictMapper.selectAreaNameByCode(address.getRecvArea());
		String ad4 = ad1 + ad2 + ad3 + address.getRecvAddress();
		return ad4;
	}

	public void addAddress(Address address) {

		address.setRecvDistric(this.getDistric(address));

		List<Address> list = addressMapper.selectByUid(address.getUid());
		if (list.size() == 0) {
			address.setIsDefault(1);
		} else {
			address.setIsDefault(0);
		}

		addressMapper.insertAddress(address);

	}

	public List<Address> getAllAddressByUid(Integer uid) {
		return addressMapper.selectByUid(uid);

	}

	public void setDefault(Integer uid, Integer id) {
		int i = addressMapper.setCancel(uid);
		int j = addressMapper.setDefault(id);
		if (i == 0) {
			throw new RuntimeException("ÐÞ¸ÄÊ§°Ü");
		}
		if (j == 0) {
			throw new RuntimeException("ÐÞ¸ÄÊ§°Ü");
		}

	}

	public Address getAddressById(Integer id) {
		return addressMapper.selectById(id);

	}

	public void updateAddressById(Address address) {

		address.setRecvDistric(this.getDistric(address));

		addressMapper.updateAddressById(address);

	}

	public void deleteAddressById(Integer id) {
		addressMapper.deleteById(id);
		
	}

}
