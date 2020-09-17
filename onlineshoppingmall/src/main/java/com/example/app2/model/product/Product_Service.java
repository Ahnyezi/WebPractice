package com.example.app2.model.product;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app2.model.join.Shop_Member;

@Service
public class Product_Service {
	@Autowired
	private Product_Repos rep;
	private String path = "C:\\Users\\Playdata\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";

	public void addProduct(ProductFile pf){//이미지명:제품 번호.jpg, 업로드 위치(db에 img값 저장형태:/img/이미지명)
		//이미지 파일 경로를 제외한 모든 상품정보 db에 저장
		Product p = rep.save(pf.getP());
		
		//이미지 파일 저장
		String fname = pf.getF().getOriginalFilename();
		System.out.println("fname:"+fname);
		String f_end = fname.substring(fname.lastIndexOf("."));
		System.out.println("f_end:"+f_end);
		String name = p.getNum()+f_end;
		System.out.println("name:"+name);
		File f = new File(path+name);
		try {
			pf.getF().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//db에 이미지 파일 경로 세팅
		p.setImg("/img/"+name);
		editProduct(p);
	}
	public void editProduct(Product p){
		rep.save(p);
	}
	public void delProduct(int num){
		rep.deleteById(num);
	}
	public Product getByNum(int num){
		return rep.getOne(num);
	}
	public List<Product> getAll(){
		return rep.findAll();
	}
	public List<Product> getByName(String name){
		return rep.findByNameLike("%"+name+"%");
	}
//	public List<Product> getBySeller(Shop_Member seller){
//		return rep.findBySeller(seller);
//	}
}
