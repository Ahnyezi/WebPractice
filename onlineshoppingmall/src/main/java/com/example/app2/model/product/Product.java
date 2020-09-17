package com.example.app2.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.example.app2.model.join.Shop_Member;
import com.example.app2.model.order.MyOrder;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName = "seq_product")
	private Integer num;//클래스 타입으로 정의.
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pnum",cascade=CascadeType.REMOVE)
	List<MyOrder> orders;

	@ManyToOne
	@JoinColumn(name="seller", nullable = false)//name=해당 테이블과 매핑할 현재클래스의 변수명 
	private Shop_Member seller;
	
	private String name;
	private Integer price;
	private Integer amount;
	private String info;
	private String img;
	
	public Product() {
	}

	public Product(Integer num, Shop_Member seller, String name, Integer price, Integer amount, String info,
			String img) {
		this.num = num;
		this.seller = seller;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.info = info;
		this.img = img;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Shop_Member getSeller() {
		return seller;
	}

	public void setSeller(Shop_Member seller) {
		this.seller = seller;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Shop_Product [num=" + num + ", seller=" + seller + ", name=" + name + ", price=" + price + ", amount="
				+ amount + ", info=" + info + ", img=" + img + "]";
	}
	
}
