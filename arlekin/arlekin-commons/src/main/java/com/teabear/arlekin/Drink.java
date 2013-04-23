/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;

/**
 * This class represents a drink 
 * and how to do it.
 * 
 * @author Maximiliano Britez
 */
public interface Drink {
	
	/** @return the Id */
	public Long getId();

	/** @param id - {@link Long} to set */
	public void setId(final Long id);

	/** @return the name of the drink */
	public String getName();

	/** @param name - {@link String} to set */
	public void setName(final String name);

	/** @return the {@link String} type of the drink */
	public String getType();
	
	/** @param type - {@link Type} to set */
	public void setType(final Type type);

	/** @return the recipe of the drink */
	public Recipe getRecipe();

	/** @param recipe - {@link Recipe} to set */
	public void setRecipe(final Recipe recipe);
}
