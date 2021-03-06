/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.representation;

import javax.xml.bind.annotation.XmlElement;
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
	private ElementsRepresentation elements;
	
	/** Retrieves the elements */
	@XmlElement(name="elements")
	public ElementsRepresentation getElements() {
		return elements;
	}

	/** Sets the elements */
	public void setElements(final ElementsRepresentation list) {
		this.elements = list;
	}
}