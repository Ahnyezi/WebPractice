package com.example.app2.model.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app2.model.join.Shop_Member;

public interface Product_Repos extends JpaRepository<Product, Integer> {
	List<Product> findByNameLike(String name);
//	List<Product> findBySeller(Shop_Member seller);
}
