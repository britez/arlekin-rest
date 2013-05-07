/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.representation;

import javax.xml.bind.annotation.XmlRootElement;

import com.teabear.arlekin.Drink;
import com.teabear.arlekin.DrinkImpl;
import com.teabear.arlekin.Recipe;
import com.teabear.arlekin.Type;

/**
 * This class represents how a {@link DrinkImpl}
 * must be represented
 * 
 * @author Maximiliano Britez
 */
@XmlRootElement(name = DrinkRepresentation.ROOT)
public class DrinkRepresentation implements Drink {
	
	/** The ROOT representation */
	static final String ROOT = "drinks";
	
	/** The id of the drink */
	private Long id;
	
	/** The name of the drink */
	private String name;
	
	/** The type of the drink */
	private Type type;
	
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
	public Type getType() {
		return this.type;
	}
	
	@Override
	/** {@inheritDoc} */
	public void setType(final Type type) {
		this.type = type;
	}

	@Override
	/** {@inheritDoc} */
	public Recipe getRecipe() {
		return null;
	}

	@Override
	/** {@inheritDoc} */
	public void setRecipe(Recipe recipe) {}
}