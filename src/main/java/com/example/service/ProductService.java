package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository repo;
	
	public boolean saveProduct(Product p) {
		Product product  = repo.save(p);
		return product.getPid()!=null;
	}
	public List<Product> getAllProduct(){
		return repo.findAll();
	}
}
