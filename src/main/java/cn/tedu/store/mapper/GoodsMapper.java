package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {

	List<Goods> selectByIdCacategoryId(@Param("categoryId")Integer categoryId, @Param("offset")Integer offset,
			@Param("count")Integer count);
	/**
	 * 获取商品数量
	 * @param categoryId
	 * @return
	 */
	Integer selectCount(Integer categoryId);
	
	Goods selectGoodById(String id);
}
