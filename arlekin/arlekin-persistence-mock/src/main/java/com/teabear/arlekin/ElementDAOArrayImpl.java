/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	/** {@inherit doc} */
	public Element get(final Long id) {
		return this.elements.get(id);
	}
	
	/** {@inherit doc} */
	public List<Element> list(final Long recipeId) {
		List<Element> result = new ArrayList<Element>();
		result.addAll(this.elements.values());
		return result;
	}
}