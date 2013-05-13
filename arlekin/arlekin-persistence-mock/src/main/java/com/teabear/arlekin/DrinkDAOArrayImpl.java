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
	}

	/** {@inherit doc} */
	public Drink save(final Drink drink) {
		Long id = new Long(this.drinks.size() + 1);
		this.drinks.put(id, drink);
		drink.setId(id);
		return drink;
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
}