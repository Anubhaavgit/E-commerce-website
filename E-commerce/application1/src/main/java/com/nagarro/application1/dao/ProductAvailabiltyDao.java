package com.nagarro.application1.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.application1.entities.ProductAvailability;
import com.nagarro.application1.entities.ProductAvailabiltyPK;

public interface ProductAvailabiltyDao extends CrudRepository<ProductAvailability, ProductAvailabiltyPK>{
	
}
