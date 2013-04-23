/*
 * Arlekin - Barras móviles
 */
package com.teabear.arlekin;


/**
 * Implementation of {@link Drink}
 * 
 * @author Maximiliano Britez
 */
public class DrinkImpl implements Drink{
	
	/** The id of the drink */
	private Long id;
	
	/** The name of the drink */
	private String name;
	
	/** The type of the drink */
	private Type type;
	
	/** The recipe of the drink */
	private Recipe recipe;
	
	@Override
	/** {@inheritDoc} */
	public Long getId() {
		return id;
	}

	@Override
	/** {@inheritDoc} */
	public void setId(final Long id) {
		this.id = id;
	}
	
	@Override
	/** {@inheritDoc} */
	public String getName() {
		return name;
	}
	
	@Override
	/** {@inheritDoc} */
	public void setName(final String name) {
		this.name = name;
	}
	
	@Override
	/** {@inheritDoc} */
	public String getType() {
		return this.type.toString();
	}
	
	@Override
	/** {@inheritDoc} */
	public void setType(final Type type) {
		this.type = type;
	}
	
	@Override
	/** {@inheritDoc} */
	public Recipe getRecipe() {
		return recipe;
	}
	
	@Override
	/** {@inheritDoc} */
	public void setRecipe(final Recipe recipe) {
		this.recipe = recipe;
	}
}
