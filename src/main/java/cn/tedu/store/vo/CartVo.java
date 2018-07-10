package cn.tedu.store.vo;

import java.io.Serializable;
//一般用于多表连接查询
public class CartVo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7206266808049163839L;
	private Integer id;
	private Integer uid;
	private String goodsId;
	private Integer num;
	private String image;
	private String title;
	private Integer price;
	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartVo(Integer id, Integer uid, String goodsId, Integer num, String image, String title, Integer price) {
		this.id = id;
		this.uid = uid;
		this.goodsId = goodsId;
		this.num = num;
		this.image = image;
		this.title = title;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartVo [id=" + id + ", uid=" + uid + ", goodsId=" + goodsId + ", num=" + num + ", image=" + image
				+ ", title=" + title + ", price=" + price + "]";
	}
	
	
}
