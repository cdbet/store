package cn.tedu.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVo;
@Service
@Controller
public class CartService implements ICartService {
	@Resource
	private CartMapper cartMapper;
	public void addCart(Cart cart) {
		cartMapper.insertCart(cart);
	}
	public List<CartVo> getByUid(Integer uid) {
		return cartMapper.selectByUid(uid);
		
	}
	public void delByIds(Integer[] ids) {
		cartMapper.deleteByIds(ids);
		
	}
	public void delByid(Integer id) {
		cartMapper.deleteById(id);
		
	}
	public void upById(Integer id, Integer num) {
		cartMapper.updateById(id, num);
		
	}
	public List<CartVo> getOrder(Integer uid, Integer[] ids) {
		List<CartVo> listOrder=new ArrayList<CartVo>();
		List<CartVo> list=cartMapper.selectByUid(uid);
		
		for(CartVo vo:list) {
			Integer id=vo.getId();
			for(Integer i:ids) {
				if(id==i) {
					listOrder.add(vo);
					break;
				}
				
			}
		}
		return listOrder;
	}

}
