package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {

	void insertCart(Cart cart);
	List<CartVo> selectByUid(Integer uid);
	/**
	 * 删除商品
	 * @param ids
	 */
	void deleteByIds(Integer[] ids);
	/**
	 * 删除单个商品
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 修改商品数量
	 * @param id
	 * @param num
	 */
	void updateById(@Param("id")Integer id,@Param("num")Integer num);
}
