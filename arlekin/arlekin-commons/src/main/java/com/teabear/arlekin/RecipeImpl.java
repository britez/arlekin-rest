/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.List;

/**
 * Implementation of {@link Recipe}
 * 
 * @author maximiliano.britez
 */
public class RecipeImpl implements Recipe {
	
	/** the elements of the recipe */
	private List<Element> elements;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Element> getElements() {
		return this.elements;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setElements(final List<Element> elements) {
		this.elements = elements;
	}

}
