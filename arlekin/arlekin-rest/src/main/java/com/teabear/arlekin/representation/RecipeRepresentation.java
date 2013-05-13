/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.representation;

import javax.xml.bind.annotation.XmlRootElement;

import com.teabear.arlekin.RecipeImpl;

/**
 * This class represents how a {@link RecipeImpl}
 * must be represented
 * 
 * @author Maximiliano Britez
 */
@XmlRootElement(name = RecipeRepresentation.ROOT)
public class RecipeRepresentation {
	
	/** The ROOT representation */
	static final String ROOT = "recipe";
	
	/** The list of elements */
	//private List<Element> elements;
	
	/** Retrieves the elements */
//	public List<Element> getElements() {
//		return elements;
//	}

	/** Sets the elements */
//	public void setElements(final List<Element> list) {
//		this.elements = list;
//	}
}