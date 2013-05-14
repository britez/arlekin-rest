/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.representation;

import javax.xml.bind.annotation.XmlRootElement;

import com.teabear.arlekin.Element;

/**
 * This class represents how a {@link Element}
 * must be represented
 * 
 * @author Maximiliano Britez
 */
@XmlRootElement(name = ElementRepresentation.ROOT)
public class ElementRepresentation {
	
	/** The ROOT representation */
	static final String ROOT = "element";
	
	/** the quantity for the element */
	private Long quantity;
	
	/** the product description for the element */
	private ProductRepresentation product;
	
	/** @return the quantity */
	public Long getQuantity() {
		return quantity;
	}

	/** @param quantity - {@link Long} to set */
	public void setQuantity(final Long quantity) {
		this.quantity = quantity;
	}

	/** @return the product */
	public ProductRepresentation getProduct() {
		return product;
	}

	/** @param product - {@link ProductRepresentation} to set */
	public void setProduct(final ProductRepresentation product) {
		this.product = product;
	}
}