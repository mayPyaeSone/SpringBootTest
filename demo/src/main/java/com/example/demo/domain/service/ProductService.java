package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public String getProdcut(Integer id) {

		try {
			productRepo.findById(id);
		} catch (Exception e) {
			return "fail";
		}
		return productRepo.findById(id).toString();
	}
}
