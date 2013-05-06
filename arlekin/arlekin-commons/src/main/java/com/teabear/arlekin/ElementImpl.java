/*
 * Arlekin - Barras móviles
 */
package com.teabear.arlekin;


/**
 * Implementation of {@link Element}
 * 
 * @author Maximiliano Britez
 */
public class ElementImpl implements Element{
	
	/** the id for the element */
	private Long id;
	
	/** the quantity for the element */
	private Long quantity;
	
	/** the product description for the element */
	private Product product;
	
	@Override
	/** {@inheritDoc} */
	public Long getId() {
		return id;
	}

	@Override
	/** {@inheritDoc} */
	public void setId(final Long id) {
		this.id = id;
	}
	
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