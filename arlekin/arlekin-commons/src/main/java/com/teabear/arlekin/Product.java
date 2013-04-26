/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

/**
 * This Class represents a general {@link Element}
 * stores the info regarding the type of element
 * 
 * @author Maximiliano Britez
 */
public interface Product {
	
	/** @return the id of the product */
	public Long getId() ;
	
	/** @param id - {@link Long} to set */
	public void setId(final Long id) ;

	/** @return the name of the product */
	public String getName() ;

	/** @param name - {@link String} to set */
	public void setName(final String name) ;

}
