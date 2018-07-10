package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Goods;
@Transactional
public interface IGoodsService {
	Integer PER_COUNT =12;

	List<Goods> getByCategoryId(Integer categoryId,Integer offset,Integer count);
	/**
	 * 获取商品的数量
	 * @param categoryId
	 * @return
	 */
	Integer getCount(Integer categoryId);
	
	Goods getGoodsById(String id);
}
