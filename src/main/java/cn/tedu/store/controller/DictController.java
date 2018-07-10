package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@Controller
@RequestMapping("/dict")
public class DictController {
	@Resource
	private IDictService iDictService;
	
	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>>showProvince(){
		ResponseResult<List<Province>> rr=new ResponseResult<List<Province>>();
		List<Province> list=iDictService.getProvince();
		rr.setData(list);
		rr.setState(1);
		rr.setMessage("成功");
		return rr;
	}
	@RequestMapping("/getCity.do")
	@ResponseBody
	public ResponseResult<List<City>>getCity(String provinceCode){
		ResponseResult<List<City>> rr=new ResponseResult<List<City>>();
		List<City> list=iDictService.getCity(provinceCode);
		rr.setState(1);
		rr.setMessage("成功");
		rr.setData(list);
		return rr;
	}
	@RequestMapping("/getArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> getArea(String cityCode){
		ResponseResult<List<Area>> rr=new ResponseResult<List<Area>>();
		List<Area> list=iDictService.getArea(cityCode);
		rr.setData(list);
		rr.setState(1);
		rr.setMessage("成功");
		return rr;
	}
	

}
