/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.representation;

import javax.xml.bind.annotation.XmlRootElement;

import com.teabear.arlekin.DrinkImpl;
import com.teabear.arlekin.Product;

/**
 * This class represents how a {@link DrinkImpl}
 * must be represented
 * 
 * @author Maximiliano Britez
 */
@XmlRootElement(name = ProductRepresentation.ROOT)
public class ProductRepresentation implements Product{
	
	/** The ROOT representation */
	static final String ROOT = "product";
	
	/** The PATH uri */
	public static final String PATH = "/products";
	
	/** The id of the product */
	private Long id;
	
	/** The name of the product */
	private String name;
	
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
	
	@Override
	/** {@inheritDoc} */
	public String getName() {
		return name;
	}
	
	@Override
	/** {@inheritDoc} */
	public void setName(final String name) {
		this.name = name;
	}
}