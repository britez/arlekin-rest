/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.teabear.arlekin.exception.ProductNotFoundException;

/**
 * Implementation of {@link ProductService}
 * 
 * @author Maximiliano Britez
 */
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	/** The dao */
	private ProductDao dao;
	
	@Override
	/** {@inherit doc} */
	public Product get(final String productId) throws ProductNotFoundException {
		final Long id = Long.valueOf(productId);
		final Product product = this.dao.get(id);
		if (product == null){
			throw new ProductNotFoundException();
		}
		return product;
	}

	@Override
	/** {@inherit doc} */
	public List<Product> list() {
		return this.dao.list();
	}
}
