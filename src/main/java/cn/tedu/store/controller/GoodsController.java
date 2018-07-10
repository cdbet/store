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
	//���ݷ���id��ʾ��Ʒ
	public String showSearch(Integer categoryId,ModelMap map,Integer page) {
		//����������ʾ��ҳ��Ʒ,pageΪnull���а�page����Ϊ1
		if(page==null) {
			page=1;
		}
		int offset=(page-1)*iGoodsService.PER_COUNT;
		//ĳһ��ҳ�����Ʒ
		List<Goods>list=iGoodsService.getByCategoryId(categoryId, offset,iGoodsService.PER_COUNT);
		map.addAttribute("list",list);
		//������Ʒ����
		Integer count=iGoodsService.getCount(categoryId);
		map.addAttribute("count",count);
		//���ù�����ҳ
		Integer pages=count%iGoodsService.PER_COUNT==0?count/iGoodsService.PER_COUNT:count/iGoodsService.PER_COUNT+1;
		map.addAttribute("pages",pages);
		//������Ʒ��ҳid
		map.addAttribute("categoryId",categoryId);
		//��ʾ��ǰҳ����ɫ
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
