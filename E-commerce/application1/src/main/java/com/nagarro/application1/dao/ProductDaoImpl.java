
package com.nagarro.application1.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.application1.entities.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> getProducts() {
		Session session = entityManager.unwrap(Session.class);

		Query<Product> query = session.createQuery("from Product", Product.class);
		List<Product> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	public Product getProductByCode(int code) {
		Session session = entityManager.unwrap(Session.class);

		Product product = session.get(Product.class, code);

		return product;
	}

	@Override
	public List<Product> getProductByName(String name) {
		Session session = entityManager.unwrap(Session.class);

		Query<Product> query = session.createQuery("from Product where name like '%"+name+"%'", Product.class);
		List<Product> listOfProduct =query.getResultList();

		return listOfProduct;
	}

	@Override
	public List<Product> getProductByBrand(String brand) {
		Session session = entityManager.unwrap(Session.class);

		Query<Product> query = session.createQuery("from Product where brand=:brand", Product.class);
		query.setParameter("brand",brand);
		List<Product> listOfProduct =query.getResultList();

		return listOfProduct;
	}

}
