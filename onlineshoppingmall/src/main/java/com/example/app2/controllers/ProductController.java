package com.example.app2.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app2.model.join.MemberType;
import com.example.app2.model.product.Product;
import com.example.app2.model.product.ProductFile;
import com.example.app2.model.product.Product_Service;

@Controller
public class ProductController {
	@Autowired
	private Product_Service service;
	
	@GetMapping("/product")
	public String form(){
		return "product/form";
	}

	@PostMapping("/product")
	public String add(ProductFile pf){
		service.addProduct(pf);
		String seller = pf.getP().getSeller().getId();
		return "redirect:/product/listbyseller/"+seller;
	}
	
	//모든 멤버: 현재 로그인 한 사람의 타입에 따라서 view page 다르게 
	@GetMapping("/product/details/{num}")
	public String details(HttpServletRequest req, @PathVariable("num")int num,Model m){
		String result = "";
		Product p = service.getByNum(num);
		m.addAttribute("p", p);
		HttpSession session = req.getSession();
		MemberType mt = (MemberType) session.getAttribute("type");
		if(mt==MemberType.CONSUMER){
			result = "order/details";
		}else if(mt==MemberType.SELLER){
			result = "product/details";
		}
		return result;
	}
	
	//구매자
	//전체 상품 페이지
	@GetMapping("/order/prod_list")
	public String listAll(Model m){
		List<Product> list = service.getAll();
		m.addAttribute("list",list);
		return "order/prod_list";
	}
	//상품이름으로 검색
	@GetMapping("/order/prod_list/name/{name}")
	public String listByName(@PathVariable("name")String name,Model m){
		List<Product> list = service.getByName("%"+name+"%");
		m.addAttribute("list",list);
		return "order/prod_list";
	}

	//판매자
	//상품수정
	@PostMapping("/product/edit")
	public String edit(Product p){
		service.editProduct(p);//데이터 지워지는 것을 막기
		return "redirect:/product/listbyseller/"+p.getSeller().getId();
	}
	//상품삭제
	@GetMapping("/product/{num}/del")
	public String del(@PathVariable("num")int num,HttpServletRequest req){
		service.delProduct(num);
		HttpSession session = req.getSession(false);
		String seller = (String) session.getAttribute("id");
		return "redirect:/product/listbyseller/"+seller;
	}

	@GetMapping("/order/details/{num}")
	public String orderForm(@PathVariable("num")int num, Model m){
		Product p = service.getByNum(num);
		m.addAttribute("p", p);
		return "order/details";
	}	
}
