/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of {@link RecipeService}
 * 
 * @author Maximiliano Britez
 */
public class RecipeServiceImpl implements RecipeService {
	
	/** The dao */
	@Autowired
	private RecipeDao dao;

	/**
	 * Creates a Recipe for the given drink
	 */
	@Override
	public Recipe create(final Recipe recipe) {
		return this.dao.save(recipe);
	}
}
