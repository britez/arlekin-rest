/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;

import java.util.List;

import com.teabear.arlekin.exception.DrinkNotFoundException;
import com.teabear.arlekin.exception.ProductNotFoundException;

/**
 * This class represents how a {@link DrinkImpl}
 * can be handled
 * 
 * @author Maximiliano Britez
 */
public interface DrinkService {
	
	/**
	 * Retrieves a {@link Drink} for the given
	 * drinkId
	 * 
	 * @param drinkId - {@link String}
	 * @return a {@link DrinkImpl} 
	 * @throws DrinkNotFoundException - if drink not found
	 */
	public Drink get(final String drinkId) throws DrinkNotFoundException;
	
	/**
	 * Retrieves a list of {@link Drink}.
	 * 
	 *  @return a List of {@link DrinkImpl} 
	 */
	public List<Drink> list();
	
	/**
	 * Creates a {@link Drink} with all of yours dependencies
	 * 
	 * @param drink - {@link String}
	 * @return a {@link DrinkImpl} 
	 * @throws ProductNotFoundException if the product non exists
	 */
	public Drink create(final Drink drink) throws ProductNotFoundException;
}
