package com.example.app2.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOrderService {
	@Autowired
	private MyOrder_Repos rep;
	
	public void addOrder(MyOrder o){
		rep.save(o);
	}
	
	public MyOrder getOrder(int num){
		return rep.getOne(num);
	}
	

}
