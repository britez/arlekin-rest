/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.List;

/**
 * This class describes how to manipulate a {@link Product}
 * 
 * @author Maximiliano Britez
 */
interface ProductDao{

	/**
	 * Store a Product
	 * @param product - {@link Product} to store
	 */
	public Product save(final Product product);
	
	/**
	 * Retrieves a Product
	 * @param id - {@link Long} of the Product 
	 * to retrieve
	 */
	public Product get(final Long id);
	
	/**
	 * @return a list of {@link Product}
	 */
	public List<Product> list();
	
	
}