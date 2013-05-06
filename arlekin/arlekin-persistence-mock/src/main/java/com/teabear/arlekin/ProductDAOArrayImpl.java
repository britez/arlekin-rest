/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link ProductDAO}
 * 
 * @author Maximiliano Britez
 */
public class ProductDAOArrayImpl implements ProductDao{
	
	/** The list */
	private Map<Long, Product> products;
	
	public ProductDAOArrayImpl() {
		this.products = new HashMap<Long, Product>();
		//Load test products
		this.load();
	}

	/** {@inherit doc} */
	public Product save(final Product product) {
		Long id = new Long(this.products.size() + 1);
		this.products.put(id, product);
		product.setId(id);
		return product;
	}

	/** {@inherit doc} */
	public Product get(final Long id) {
		return this.products.get(id);
	}
	
	/** {@inherit doc} */
	public List<Product> list() {
		List<Product> result = new ArrayList<Product>();
		result.addAll(this.products.values());
		return result;
	}
	
	/** Load some test drinks into array */
	private void load() {
		final Product pr = new ProductImpl();
		pr.setName("Vodka");
		this.save(pr);
	}
}