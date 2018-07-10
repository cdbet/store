package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;
@Transactional
public interface ICartService {

	void addCart(Cart cart);
	List<CartVo> getByUid(Integer uid);
	void delByIds(Integer[] ids);
	void delByid(Integer id);
	void upById(Integer id,Integer num);
	List<CartVo> getOrder(Integer uid,Integer[] ids);
}
