/*
 * Arlekin - Barras móviles
 */
package com.teabear.arlekin;


/**
 * Implementation of {@link Drink}
 * 
 * @author Maximiliano Britez
 */
public class ProductImpl implements Product{
	
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
