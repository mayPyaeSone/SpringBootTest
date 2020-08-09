package com.example.demo.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.service.ProductService;
import com.example.demo.user.domain.Product;
import com.sun.el.stream.Optional;

@RestController
public class HelloWorldController {
	@Autowired
     private ProductService productService;
	@RequestMapping(method = RequestMethod.GET,path="/hello-world")
	public String helloWorld() {
		return "helloWorld";
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/hello-worldbean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("this is hard code");
	}
	
	
	@RequestMapping(method = RequestMethod.GET,path="O")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("this is hard code,%s", name));
	}
	@RequestMapping(method = RequestMethod.GET,path="/product/{id}")
	public String getProductById(@PathVariable Integer id) {
		try {
			//productService.getProdcut(id);
		}catch (Exception e) {
			return "fail";
		}
		return productService.getProdcut(id).toString();
	}
}
