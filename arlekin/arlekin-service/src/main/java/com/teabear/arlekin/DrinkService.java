/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;

import java.util.List;

import com.teabear.arlekin.exception.DrinkNotFoundException;

/**
 * This class represents how a {@link DrinkImpl}
 * can be handled
 * 
 * @author Maximiliano Britez
 */
public interface DrinkService {
	
	/**
	 * @param drinkId - {@link String}
	 * @return a {@link DrinkImpl} 
	 * @throws DrinkNotFoundException - if drink not found
	 */
	public Drink get(final String drinkId) throws DrinkNotFoundException;
	
	/** @return a List of {@link DrinkImpl} */
	public List<Drink> list();
}
