/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.teabear.arlekin.exception.DrinkNotFoundException;

/**
 * Implementation of {@link DrinkService}
 * 
 * @author Maximiliano Britez
 */
public class DrinkServiceImpl implements DrinkService {
	
	/** The dao */
	@Autowired
	private DrinkDao dao;
	
	/** The recipe service */
	@Autowired
	private RecipeService recipeService;
	
	/** {@inherit doc} */
	@Override
	public Drink get(final String drinkId) throws DrinkNotFoundException {
		final Long id = Long.valueOf(drinkId);
		final Drink drink = this.dao.get(id);
		if (drink == null){
			throw new DrinkNotFoundException();
		}
		return drink;
	}

	/** {@inherit doc} */
	@Override
	public List<Drink> list() {
		return this.dao.list();
	}

	/**
	 * {@inherit doc}
	 */
	@Override
	public Drink create(final Drink drink) {
		drink.setRecipe(this.recipeService.create(drink.getRecipe()));
		return this.dao.save(drink);
	}
}
