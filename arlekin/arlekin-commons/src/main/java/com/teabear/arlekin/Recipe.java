/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.List;

/**
 * This Class represents how a Drink 
 * can be done.
 * Have the information about the elements
 * 
 * @author Maximiliano Britez
 */
public interface Recipe {
	
	/** @return a list of elements*/
	public List<Element> getElements();

	/** @param elements - {@link List} of {@Element} to set */
	public void setElements(final List<Element> elements);
}