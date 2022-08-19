package com.nagarro.application1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.application1.dao.ProductDao;
import com.nagarro.application1.entities.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public Product getProductByCode(int code) {
		return productDao.getProductByCode(code);
	}

	@Override
	public List<Product> getProductByName(String name) {
		return productDao.getProductByName(name);
	}

	@Override
	public List<Product> getProductByBrand(String brand) {
		return productDao.getProductByBrand(brand);
	}

}
