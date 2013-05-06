/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

/**
 * This Class represents an element into a
 * {@link Recipe}
 * 
 * @author Maximiliano Britez
 */
public interface Element {
	
	/** @return the id of the element */
	public Long getId();
	
	/** @param id - {@link Long} to set */
	public void setId(final Long id);
	
	/** @return the quantity */
	public Long getQuantity();

	/** @param quantity - {@link Long} to set */
	public void setQuantity(final Long quantity);

	/** @return the product */
	public Product getProduct();

	/** @param product - {@link Product} to set */
	public void setProduct(Product product);
}