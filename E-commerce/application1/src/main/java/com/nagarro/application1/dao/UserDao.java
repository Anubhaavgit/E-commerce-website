package com.nagarro.application1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.application1.entities.User;

@Repository
public interface UserDao extends CrudRepository<User, String>{
	
}
