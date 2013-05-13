/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;


/**
 * This class describes how to manipulate a Recipe
 * 
 * @author Maximiliano Britez
 */
interface RecipeDao{

	/**
	 * Store a Recipe
	 * @param recipe - {@link Recipe} to store
	 */
	public Recipe save(final Recipe recipe);
	
}