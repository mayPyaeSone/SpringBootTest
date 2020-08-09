package com.example.demo.user.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Product {
	@Id
	private Integer Id;
	private String name;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + "]";
	}
	

}
