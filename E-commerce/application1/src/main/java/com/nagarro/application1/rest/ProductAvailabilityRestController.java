package com.nagarro.application1.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.application1.dao.ProductAvailabiltyDao;
import com.nagarro.application1.entities.ProductAvailability;
import com.nagarro.application1.entities.ProductAvailabiltyPK;

@RestController
@CrossOrigin("*")
public class ProductAvailabilityRestController {

	@Autowired
	private ProductAvailabiltyDao productAvailDao;
	
	@PostMapping("/delivery")
	public Optional<ProductAvailability> checkForAvailabilty(@RequestBody ProductAvailabiltyPK pk){
		
		return productAvailDao.findById(pk);
	}
}
