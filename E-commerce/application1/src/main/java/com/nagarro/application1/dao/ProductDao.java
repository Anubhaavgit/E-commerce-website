package com.nagarro.application1.dao;

import java.util.List;

import com.nagarro.application1.entities.Product;

public interface ProductDao {
	
	public List<Product>getProducts();

	public Product getProductByCode(int code);

	public List<Product> getProductByName(String name);

	public List<Product> getProductByBrand(String brand);
}
