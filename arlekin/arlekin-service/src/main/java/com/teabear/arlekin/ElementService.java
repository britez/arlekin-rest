/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;

import java.util.List;

import com.teabear.arlekin.exception.ProductNotFoundException;

/**
 * This class represents how a {@link ElementImpl}
 * can be handled
 * 
 * @author Maximiliano Britez
 */
public interface ElementService {

	/**
	 * Create a list of elements
	 * 
	 * @param elements - {@link Element}
	 * @throws ProductNotFoundException if the product non exists
	 */
	public List<Element> create(final List<Element> elements) throws ProductNotFoundException;
	
	/**
	 * Create an element
	 * 
	 * @param element - {@link Element}
	 * @return the created {@link Element}
	 * @throws ProductNotFoundException if the product non exists
	 */
	public Element create(final Element element) throws ProductNotFoundException;
	
}
