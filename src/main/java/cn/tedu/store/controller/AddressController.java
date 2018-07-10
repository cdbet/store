package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Resource
	private IAddressService iAddressService;
	
	@RequestMapping("/showAddress.do")
	public String showAddress() {
		return "addressAdmin";
	}
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void>addAddress(HttpSession session,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag){
		
		ResponseResult<Void>rr;
		
		Address address=new Address();
		address.setUid(this.getId(session));
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		
		
		iAddressService.addAddress(address);
		
		rr=new ResponseResult<Void>(1,"成功");
		return rr;
		
	}
	@RequestMapping("/getAllAddress.do")
	@ResponseBody
	public ResponseResult<List<Address>>getAllAddress(HttpSession session){
		ResponseResult<List<Address>>rr=new ResponseResult<List<Address>>();
		
		List<Address>list=iAddressService.getAllAddressByUid(this.getId(session));
		rr.setState(1);
		rr.setMessage("成功");
		rr.setData(list);
		
		return rr;
	}
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session,Integer id){
		ResponseResult<Void>rr;
		try {
			iAddressService.setDefault(this.getId(session), id);;
			rr=new ResponseResult<Void>(1,"成功");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
		
	}
	@RequestMapping("/getAddressById.do")
	@ResponseBody
	public ResponseResult<Address> getAddressById(Integer id){
		ResponseResult<Address>rr=new ResponseResult<Address>();
		Address address=iAddressService.getAddressById(id);
		rr.setData(address);
		rr.setState(1);
		rr.setMessage("成功");
		return rr;
				
	}
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Void> updateAddress(
			Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag){
		ResponseResult<Void>rr=new ResponseResult<Void>();
		Address address=new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		
		iAddressService.updateAddressById(address);
		rr.setState(1);
		rr.setMessage("修改成功");
		return rr;
	}
	@RequestMapping("/deleteAddress.do")
	@ResponseBody
	public ResponseResult<Void> deleteAddress(Integer id){
		ResponseResult<Void>rr=new ResponseResult<Void>();
		iAddressService.deleteAddressById(id);
		rr.setState(1);
		rr.setMessage("删除成功");
		return rr;
	}
	
	
}
