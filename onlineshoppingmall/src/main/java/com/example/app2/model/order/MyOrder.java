package com.example.app2.model.order;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.app2.model.join.Shop_Member;
import com.example.app2.model.product.Product;

@Entity
@Table(name="myorder")
public class MyOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_order_sequence")
	@SequenceGenerator(name = "my_order_sequence", sequenceName = "seq_my_order")
	private Integer num;

	@ManyToOne
	@JoinColumn(name = "pnum", nullable = false)
	private Product pnum;
	private Integer order_num;
	private Integer total_price;

	@Enumerated(EnumType.STRING)
	private OrderType type;

	@ManyToOne
	@JoinColumn(name = "con_id", nullable = false)
	private Shop_Member con_id;

	public MyOrder() {
	}

	public MyOrder(Integer num, Product pnum, Integer order_num, Integer total_price, OrderType type,
			Shop_Member con_id) {
		this.num = num;
		this.pnum = pnum;
		this.order_num = order_num;
		this.total_price = total_price;
		this.type = type;
		this.con_id = con_id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Product getPnum() {
		return pnum;
	}

	public void setPnum(Product pnum) {
		this.pnum = pnum;
	}

	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public Integer getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public Shop_Member getCon_id() {
		return con_id;
	}

	public void setCon_id(Shop_Member con_id) {
		this.con_id = con_id;
	}

	@Override
	public String toString() {
		return "MyOrder [num=" + num + ", pnum=" + pnum + ", order_num=" + order_num + ", total_price=" + total_price
				+ ", type=" + type + ", con_id=" + con_id + "]";
	}
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_order_sequence")
//	@SequenceGenerator(name = "my_order_sequence", sequenceName = "seq_my_order")
//	private Integer num;
//	
//	@ManyToOne
//	@JoinColumn(name="pnum", nullable = false)//name=해당 테이블과 매핑할 현재클래스의 변수명 
//	private Product pnum;//주문한 제품번호 FK(product(num)) pnum
//	
//	private Integer order_num;
//	private Integer total_price;
//	
//	@Enumerated(EnumType.STRING)
//	private OrderType type;
//	
//	@ManyToOne
//	@JoinColumn(name="con_id", nullable = false)//name=해당 테이블과 매핑할 현재클래스의 변수명 
//	private Shop_Member con_id;//주문자id FK(shop_member(id)) con_id
//
//	public MyOrder() {
//		super();
//	}
//
//	public MyOrder(Integer num, Product pnum, Integer order_num, Integer total_price, OrderType type,
//			Shop_Member con_id) {
//		super();
//		this.num = num;
//		this.pnum = pnum;
//		this.order_num = order_num;
//		this.total_price = total_price;
//		this.type = type;
//		this.con_id = con_id;
//	}
//
//	public Integer getNum() {
//		return num;
//	}
//
//	public void setNum(Integer num) {
//		this.num = num;
//	}
//
//	public Product getPnum() {
//		return pnum;
//	}
//
//	public void setPnum(Product pnum) {
//		this.pnum = pnum;
//	}
//
//	public Integer getOrder_num() {
//		return order_num;
//	}
//
//	public void setOrder_num(Integer order_num) {
//		this.order_num = order_num;
//	}
//
//	public Integer getTotal_price() {
//		return total_price;
//	}
//
//	public void setTotal_price(Integer total_price) {
//		this.total_price = total_price;
//	}
//
//	public OrderType getType() {
//		return type;
//	}
//
//	public void setType(OrderType type) {
//		this.type = type;
//	}
//
//	public Shop_Member getCon_id() {
//		return con_id;
//	}
//
//	public void setCon_id(Shop_Member con_id) {
//		this.con_id = con_id;
//	}
//
//	@Override
//	public String toString() {
//		return "MyOrder [num=" + num + ", pnum=" + pnum + ", order_num=" + order_num + ", total_price=" + total_price
//				+ ", type=" + type + ", con_id=" + con_id + "]";
//	}
}
