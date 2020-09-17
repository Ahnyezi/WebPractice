package com.example.app2.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app2.model.join.Shop_Member;
import com.example.app2.model.join.Shop_MemberService;
import com.example.app2.model.order.MyOrder;
import com.example.app2.model.order.MyOrderService;
import com.example.app2.model.order.OrderType;

@Controller
public class OrderController {
	@Autowired
	private MyOrderService service;
	
//	@RequestMapping("/order/result/{num}")
//	public String result(@PathVariable("num")int num, Model m){
//		MyOrder o = service.getOrder(num);
//		m.addAttribute("o",o);
//		return "order/result";
//	}
	
	@GetMapping("/order")
	public String form(){
		return "order/form";
	}
	
	@PostMapping("/order")
	public String order(MyOrder o){
		service.addOrder(o);
		System.out.println(o.getCon_id().getOrders());
		return "redirect:/order/mylist/"+o.getCon_id().getId()+"/"+o.getType();
	}

}
