package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.domain.Product;
import com.sun.el.stream.Optional;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
