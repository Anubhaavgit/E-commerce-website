package com.nagarro.application1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.application1.entities.Product;
import com.nagarro.application1.services.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/products/{code}")
	public Product getProductByCode(@PathVariable int code) {
		Product product = productService.getProductByCode(code);

		if (product == null) {
			throw new RuntimeException("Product not found with code" + code);
		}
		return product;
	}

	@GetMapping("/products/name/{name}")
	public List<Product> getProductByName(@PathVariable String name) {
		List<Product> ListOfProduct = productService.getProductByName(name);
		if (ListOfProduct == null) {
			throw new RuntimeException("Product not found with name" + name);
		}
		return ListOfProduct;
	}
	
	@GetMapping("/products/brand/{brand}")
	public List<Product> getProductByBrand(@PathVariable String brand) {
		List<Product> ListOfProduct = productService.getProductByBrand(brand);
		if (ListOfProduct == null) {
			throw new RuntimeException("Product not found with name" + brand);
		}
		return ListOfProduct;
	}
	
	@GetMapping("/products/{code}/desc")
	public String getProductDescByCode(@PathVariable int code) {
		Product product = productService.getProductByCode(code);

		if (product == null) {
			throw new RuntimeException("Product not found with code" + code);
		}
		return product.getDescription();
	}
	
	@GetMapping("/products/{code}/price")
	public double getProductPriceByCode(@PathVariable int code) {
		Product product = productService.getProductByCode(code);

		if (product == null) {
			throw new RuntimeException("Product not found with code" + code);
		}
		return product.getPrice();
	}
	
	
}
