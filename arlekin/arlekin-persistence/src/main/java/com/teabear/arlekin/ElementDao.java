/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.List;

/**
 * This class describes how to manipulate a {@link Element}
 * 
 * @author Maximiliano Britez
 */
interface ElementDao{

	/**
	 * Store a Element
	 * @param element - {@link Element} to store
	 */
	public Element save(final Element element);
	
	/**
	 * Retrieves a Element
	 * @param id - {@link Long} of the Element 
	 * to retrieve
	 */
	public Element get(final Long id);
	
	/**
	 * @return a list of {@link Element} for
	 * the given Recipe
	 */
	public List<Element> list(final Long recipeId);
	
	
}