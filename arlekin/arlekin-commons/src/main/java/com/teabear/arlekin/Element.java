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
public class Element {
	
	/** the quantity for the element */
	private Long quantity;
	
	/** the product description for the element */
	private Product product;

	/** @return the quantity */
	public Long getQuantity() {
		return quantity;
	}

	/** @param quantity - {@link Long} to set */
	public void setQuantity(final Long quantity) {
		this.quantity = quantity;
	}

	/** @return the product */
	public Product getProduct() {
		return product;
	}

	/** @param product - {@link Product} to set */
	public void setProduct(Product product) {
		this.product = product;
	}
}