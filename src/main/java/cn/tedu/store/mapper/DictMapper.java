package cn.tedu.store.mapper;
                                                                                               
import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;                                                            
                                                                                               
public interface DictMapper {                                                                  
	List<Province>selectProvince();
	List<City>selectCity(String provinceCode);
	List<Area>selectArea(String cityCode);
	String selectProvinceNameByCode(String provinceCode);
	String selectCityNameByCode(String cityCode);
	String selectAreaNameByCode(String areaCode);
	
	
	
	
	
	
	
	
}                                                                                              
     


                
                                
                
                
                


