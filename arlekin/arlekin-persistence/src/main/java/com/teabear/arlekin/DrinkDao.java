/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.List;

/**
 * This class describes how to manipulate a drink
 * 
 * @author Maximiliano Britez
 */
interface DrinkDao{

	/**
	 * Store a Drink
	 * @param drink - {@link Drink} to store
	 */
	public Drink save(final Drink drink);
	
	/**
	 * Retrieves a Drink
	 * @param id - {@link Long} of the Drink 
	 * to retrieve
	 */
	public Drink get(final Long id);
	
	/**
	 * @return a list of {@link Drink}
	 */
	public List<Drink> list();
	
	
}