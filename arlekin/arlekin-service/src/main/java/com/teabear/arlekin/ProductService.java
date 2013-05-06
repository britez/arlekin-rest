/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;

import java.util.List;

import com.teabear.arlekin.exception.ProductNotFoundException;

/**
 * This class represents how a {@link Product}
 * can be handled
 * 
 * @author Maximiliano Britez
 */
public interface ProductService {
	
	/**
	 * @param productId - {@link String}
	 * @return a {@link Product} 
	 * @throws ProductNotFoundException - if product not found
	 */
	public Product get(final String productId) throws ProductNotFoundException;
	
	/** @return a List of {@link Product} */
	public List<Product> list();
	
	/**
	 * @param product - {@link Product} to persist
	 * @return the created product
	 */
	public Product create(final Product product);
}
