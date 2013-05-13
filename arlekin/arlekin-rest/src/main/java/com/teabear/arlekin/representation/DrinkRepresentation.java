/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.representation;

import javax.xml.bind.annotation.XmlRootElement;

import com.teabear.arlekin.DrinkImpl;

/**
 * This class represents how a {@link DrinkImpl}
 * must be represented
 * 
 * @author Maximiliano Britez
 */
@XmlRootElement(name = DrinkRepresentation.ROOT)
public class DrinkRepresentation {
	
	/** The ROOT representation */
	static final String ROOT = "drink";
	
	public static final String PATH = "/drinks";
	
	/** The id of the drink */
	private Long id;
	
	/** The name of the drink */
	private String name;
	
	/** The type of the drink */
	private String type;
	
	/** The recipe representation */
	private RecipeRepresentation recipe;
	
	/** Retrieves the id */
	public Long getId() {
		return id;
	}

	/** Sets the  id */
	public void setId(final Long id) {
		this.id = id;
	}
	
	/** Retrieves the name */
	public String getName() {
		return name;
	}

	/** Sets the name */
	public void setName(final String name) {
		this.name = name;
	}

	/** Retrieves the type */
	public String getType() {
		return this.type.toString();
	}
	
	/** Sets the type */
	public void setType(final String type) {
		this.type = type;
	}

	/** Retrieve the recipe */
	public RecipeRepresentation getRecipe() {
		return this.recipe;
	}

	/** set the recipe */
	public void setRecipe(final RecipeRepresentation recipe) {
		this.recipe = recipe;
	}
}