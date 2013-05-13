/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of {@link RecipeDao}
 * 
 * @author Maximiliano Britez
 */
public class RecipeDAOArrayImpl implements RecipeDao{
	
	/** The list */
	private Map<Long, Recipe> recipes;
	
	public RecipeDAOArrayImpl() {
		this.recipes = new HashMap<Long, Recipe>();
	}

	/** {@inherit doc} */
	public Recipe save(final Recipe recipe) {
		Long id = new Long(this.recipes.size() + 1);
		this.recipes.put(id, recipe);
		return recipe;
	}
}