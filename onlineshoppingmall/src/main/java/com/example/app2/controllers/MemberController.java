package com.example.app2.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app2.model.join.MemberType;
import com.example.app2.model.join.Shop_Member;
import com.example.app2.model.join.Shop_MemberService;
import com.example.app2.model.order.MyOrder;
import com.example.app2.model.order.OrderType;
import com.example.app2.model.product.Product;

@Controller
public class MemberController {
	@Autowired
	private Shop_MemberService service;
	
	@GetMapping("/member")
	public String form(){
		return "member/form";
	}
	
	@PostMapping("/member")
	public String join(Shop_Member sm){
		service.saveMember(sm);
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/login")
	public void loginForm(){}
	
	@PostMapping("/member/login")
	public String login(Shop_Member sm, HttpServletRequest req){
		HttpSession session = req.getSession();
		Shop_Member a = service.getMember(sm.getId());
		boolean flag = false;
		String pwd = "";
		try{
			pwd = a.getPwd();
			if(pwd.equals(sm.getPwd())){
				flag=true;	
			}else{
				System.out.println("패스워드 불일치");
			}
		}catch(EntityNotFoundException e){
			flag= true;
			System.out.println("아이디 불일치");
		}
		String result="redirect:/member/login";
		if(flag){
			session.setAttribute("id", sm.getId());//id정보(sm객체 사용.나머지 null값)
			session.setAttribute("type", a.getType());//type정보->productC의 details에서 구분
			//구매자=>전체 상품 리스트 페이지
			//판매자=>내가 등록한 상품 페이지
			if(a.getType()==MemberType.CONSUMER){
				System.out.println("구매자로 로그인");
				result="redirect:/order/prod_list";
			}else if(a.getType()==MemberType.SELLER){
				System.out.println("판매자로 로그인");
				result="redirect:/product/listbyseller/"+sm.getId();
			}
		}
		return result;
	}
	
	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/member/login";
	}
	
	@RequestMapping("/member/idCheck")
	public String idCheck(@RequestParam("id") String id, Model m){
		System.out.println("id:"+id);
		Shop_Member a = service.getMember(id);
		boolean flag = false;
		try{
			a.getPwd();
		}catch (EntityNotFoundException e){
			flag=true;
		}
		m.addAttribute("flag", flag);
		return "member/idcheck";
	}
	
	//판매자로 검색
	@GetMapping("/product/listbyseller/{seller}")
	public String listBySeller(@PathVariable("seller") String seller, Model m){
		Shop_Member sm = service.getMember(seller);
		List<Product> list = sm.getProducts();
		m.addAttribute("list", list);
		return "product/list";
	}
	
	//구매자: 즉시결제/장바구니 목록
	@GetMapping("/order/mylist/{con}/{type}")//구매자id와 구매종류
	public String myOrderList(@PathVariable("con") String con,@PathVariable("type") OrderType type,Model m){
		Shop_Member sm = service.getMember(con);//구매자 id로 멤버 전체 정보 검색
		List<MyOrder> list = sm.getOrders();
		List<MyOrder> list_type = new ArrayList<MyOrder>();
		for(MyOrder o: list){
			if(o.getType()==type){
				list_type.add(o);
			}
		}
		m.addAttribute("list",list_type);
		m.addAttribute("order_type", type);
		return "order/mylist";
	}
	
	//판매자로 검색
	@GetMapping("/order/prod_list/seller/{seller}")
	public String ProdlistBySeller(@PathVariable("seller")String seller, Model m){
		Shop_Member sm = service.getMember(seller);
		List<Product> list = sm.getProducts();
		m.addAttribute("list",list);
		return "order/prod_list";
	}
	
}
