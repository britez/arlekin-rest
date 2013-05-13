/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;


/**
 * This class represents how a {@link RecipeImpl}
 * can be handled
 * 
 * @author Maximiliano Britez
 */
public interface RecipeService {
	
	/**
	 * Creates a {@link Recipe} with all of yours dependencies
	 * 
	 * @param recipe - {@link Recipe}
	 * @return a {@link RecipeImpl} 
	 */
	public Recipe create(final Recipe recipe);
}
