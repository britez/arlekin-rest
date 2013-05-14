/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.teabear.arlekin.RecipeImpl;

/**
 * This class represents how a {@link RecipeImpl}
 * must be represented
 * 
 * @author Maximiliano Britez
 */
@XmlRootElement(name = ElementsRepresentation.ROOT)
public class ElementsRepresentation {
	
	/** The ROOT representation */
	static final String ROOT = "elements";
	
	/** The list of elements */
	private List<ElementRepresentation> element;
	
	/** Retrieves the elements */
	public List<ElementRepresentation> getElement() {
		return element;
	}

	/** Sets the elements */
	public void setElement(final List<ElementRepresentation> list) {
		this.element = list;
	}
}