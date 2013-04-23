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
public class Recipe {
	
	/** the elements of the recipe */
	private List<Element> elements;

	/** @return a list of elements*/
	public List<Element> getElements() {
		return elements;
	}

	/** @param elements - {@link List} of {@Element} to set */
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}
}