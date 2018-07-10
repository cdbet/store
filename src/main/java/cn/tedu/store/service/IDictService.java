package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
@Transactional
public interface IDictService {

	/**
	 * ��ȡʡ��Ϣ
	 * @return
	 */
	List<Province> getProvince();
	List<City> getCity(String provinceCode);
	List<Area> getArea(String cityCode);
}
