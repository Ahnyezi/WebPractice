package com.example.app2.model.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrder_Repos extends JpaRepository<MyOrder, Integer> {
	List<MyOrder> findByType(OrderType type);
	//findBy컬럼명()
	//findBy컬럼명Like()
}

