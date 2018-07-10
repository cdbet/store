package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IGoodsCategoryService igcService;
	@Resource
	private IGoodsService iGoodsService;

	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map) {
		List<List<GoodsCategory>> list3=new ArrayList<List<GoodsCategory>>();
		// 1.调用业务层方法，返回二级分类的集合list2;		
		List<GoodsCategory> list2=igcService.getGoodsCategoryByParentId(161,0,3);
		// 2.遍历list2,可以得到二级分类的id，调用持久层的方法
		// 得到三级分类集合，把此集合添加到list
		for(GoodsCategory goodsCategory:list2) {
			Integer id=goodsCategory.getId();
			list3.add(igcService.getGoodsCategoryByParentId(id, null, null));
		}
		// 3.分别把list2和list3添加
		map.addAttribute("list2",list2);
		map.addAttribute("list3",list3);
/*		for(GoodsCategory category:list2) {
			System.out.println(category.getName());
		}
		System.out.println("--------------");
		for(List<GoodsCategory> list3_1:list3) {
			for(GoodsCategory list3_2:list3_1) {
				System.out.println(list3_2.getName());
			}
		}*/
		//设置热门商品的集合
		List<Goods> goodsList=iGoodsService.getByCategoryId(163,0,3);
		map.addAttribute("goodsList",goodsList);
		
		return "index";
	}


}
