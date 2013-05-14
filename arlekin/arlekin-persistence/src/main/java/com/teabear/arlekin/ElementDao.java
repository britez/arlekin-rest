/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

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
}