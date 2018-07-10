package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {

	void insertCart(Cart cart);
	List<CartVo> selectByUid(Integer uid);
	/**
	 * ɾ����Ʒ
	 * @param ids
	 */
	void deleteByIds(Integer[] ids);
	/**
	 * ɾ��������Ʒ
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * �޸���Ʒ����
	 * @param id
	 * @param num
	 */
	void updateById(@Param("id")Integer id,@Param("num")Integer num);
}
