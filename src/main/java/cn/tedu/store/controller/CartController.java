package cn.tedu.store.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.vo.CartVo;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private ICartService icartService;
	
	
	
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(String goodsId,Integer num,HttpSession session) {
		ResponseResult<Void> rr;
		Cart cart=new Cart();
		cart.setGoodsId(goodsId);
		cart.setNum(num);
		cart.setUid(this.getId(session));
		icartService.addCart(cart);
		rr=new ResponseResult<Void>(1,"成功");
		return rr;
	}
	//显示购物车商品
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map) {
		List<CartVo>listCartVo=icartService.getByUid(this.getId(session));
		map.addAttribute("listCartVo",listCartVo);
		return "cart";
	}
	@RequestMapping("/deleteByIds.do")
	public String deleteByIds(Integer[] ids) {
		icartService.delByIds(ids);
		return "redirect:../cart/showCart.do";
	}
	@RequestMapping("/deleteById.do")
	public String deleteById(Integer id) {
		icartService.delByid(id);
		return "redirect:../cart/showCart.do";
	}
	//修改数量
	@RequestMapping("/updateById.do")
	@ResponseBody
	public ResponseResult<Void> updateById(Integer id,Integer num){
		ResponseResult<Void>rr=new ResponseResult<Void>();
		icartService.upById(id, num);
		rr.setState(1);
		rr.setMessage("成功");
		return rr;
	}
	//显示订单
	@RequestMapping("/showOrder.do")
	public String showOrder(Integer[] ids,HttpSession session,ModelMap map) {
		List<CartVo> listOrder=icartService.getOrder(this.getId(session), ids);
		map.addAttribute("listOrder",listOrder);
		return "orderConfirm";
	}
	
	
}
