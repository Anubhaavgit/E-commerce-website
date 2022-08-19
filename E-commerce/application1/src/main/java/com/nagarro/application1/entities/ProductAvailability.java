package com.nagarro.application1.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductAvailability {

	@EmbeddedId
	private ProductAvailabiltyPK key;
	
	private boolean availability;

	public ProductAvailabiltyPK getKey() {
		return key;
	}

	public void setKey(ProductAvailabiltyPK key) {
		this.key = key;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
