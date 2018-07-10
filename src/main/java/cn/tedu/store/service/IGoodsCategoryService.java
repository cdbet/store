package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.GoodsCategory;
@Transactional
public interface IGoodsCategoryService {

	List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId,Integer offset,Integer count);
}
