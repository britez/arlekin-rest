/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teabear.arlekin.exception.DrinkNotFoundException;

/**
 * Implementation of {@link DrinkService}
 * 
 * @author Maximiliano Britez
 */
public class DrinkServiceImpl implements DrinkService {
	
	@Autowired
	/** The dao */
	private DrinkDAOArrayImpl dao;

	@Override
	/** {@inherit doc} */
	public Drink get(final String drinkId) throws DrinkNotFoundException {
		Long id = Long.valueOf(drinkId);
		final Drink drink = this.dao.get(id);
		if (drink == null){
			throw new DrinkNotFoundException();
		}
		return drink;
	}
}
