package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	@Resource
	private IGoodsService iGoodsService;
	
	@RequestMapping("/showSearch.do")
	//根据分类id显示商品
	public String showSearch(Integer categoryId,ModelMap map,Integer page) {
		//发送链接显示首页商品,page为null所有吧page设置为1
		if(page==null) {
			page=1;
		}
		int offset=(page-1)*iGoodsService.PER_COUNT;
		//某一个页面的商品
		List<Goods>list=iGoodsService.getByCategoryId(categoryId, offset,iGoodsService.PER_COUNT);
		map.addAttribute("list",list);
		//设置商品数量
		Integer count=iGoodsService.getCount(categoryId);
		map.addAttribute("count",count);
		//设置共多少页
		Integer pages=count%iGoodsService.PER_COUNT==0?count/iGoodsService.PER_COUNT:count/iGoodsService.PER_COUNT+1;
		map.addAttribute("pages",pages);
		//设置商品分页id
		map.addAttribute("categoryId",categoryId);
		//显示当前页的颜色
		map.addAttribute("curr",page);
		return "search";
	}
	@RequestMapping("/showDetails.do")
	public String showDetails(String id,ModelMap map,Integer categoryId) {
		Goods goods=iGoodsService.getGoodsById(id);
		map.addAttribute("goods",goods);
		List<Goods>listGoods=iGoodsService.getByCategoryId(categoryId,0,4);
		map.addAttribute("listGoods",listGoods);
		return "product_details";
		
	
	}
}
