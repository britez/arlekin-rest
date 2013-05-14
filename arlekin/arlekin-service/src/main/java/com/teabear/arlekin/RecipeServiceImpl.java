/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import org.springframework.beans.factory.annotation.Autowired;

import com.teabear.arlekin.exception.ProductNotFoundException;

/**
 * Implementation of {@link RecipeService}
 * 
 * @author Maximiliano Britez
 */
public class RecipeServiceImpl implements RecipeService {
	
	/** The dao */
	@Autowired
	private RecipeDao dao;
	
	/** The element service */
	@Autowired
	private ElementService elementService;

	/**
	 * Creates a Recipe for the given drink
	 */
	@Override
	public Recipe create(final Recipe recipe) throws ProductNotFoundException {
		this.elementService.create(recipe.getElements());
		return this.dao.save(recipe);
	}
}
