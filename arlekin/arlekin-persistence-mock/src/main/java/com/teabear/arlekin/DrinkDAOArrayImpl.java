/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link DrinkDAO}
 * 
 * @author Maximiliano Britez
 */
public class DrinkDAOArrayImpl implements DrinkDao{
	
	/** The list */
	private Map<Long, Drink> drinks;
	
	public DrinkDAOArrayImpl() {
		this.drinks = new HashMap<Long, Drink>();
		//Load test drinks
		this.load();
	}

	/** {@inherit doc} */
	public void save(final Drink drink) {
		this.drinks.put(drink.getId(), drink);
	}

	/** {@inherit doc} */
	public Drink get(final Long id) {
		return this.drinks.get(id);
	}
	
	/** {@inherit doc} */
	public List<Drink> list() {
		List<Drink> result = new ArrayList<Drink>();
		result.addAll(this.drinks.values());
		return result;
	}
	
	/** Load some test drinks into array */
	private void load() {
		final Drink dr = new DrinkImpl();
		dr.setId(1L);
		dr.setName("Sex on the Beach");
		dr.setRecipe(new Recipe());
		dr.setType(Type.DIRECT);
		this.save(dr);
	}
}