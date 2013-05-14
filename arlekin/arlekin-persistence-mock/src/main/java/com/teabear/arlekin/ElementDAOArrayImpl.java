/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of {@link ElementDAO}
 * 
 * @author Maximiliano Britez
 */
public class ElementDAOArrayImpl implements ElementDao{
	
	/** The list */
	private Map<Long, Element> elements;
	
	public ElementDAOArrayImpl() {
		this.elements = new HashMap<Long, Element>();
	}

	/** {@inherit doc} */
	public Element save(final Element element) {
		Long id = new Long(this.elements.size() + 1);
		this.elements.put(id, element);
		element.setId(id);
		return element;
	}
}