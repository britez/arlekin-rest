/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin.converter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.teabear.arlekin.Drink;
import com.teabear.arlekin.representation.DrinkRepresentation;

/**
 * Tests for {@link DrinkConverter}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class DrinkConverterTest {
	
	/** Converter to test */
	private DrinkConverter converter;
	
	/**
	 * Initializes the test */
	@Before
	public void setUp(){
		this.converter = new DrinkConverter();
	}
	
	/**
	 * Ensures that a {@link DrinkRepresentation} 
	 * is converted
	 */
	@Test
	public void testConvertToRepresentation(){
		final Drink drink = Mockito.mock(Drink.class);
		DrinkRepresentation representation = this.converter.toRepresentation(drink);
		this.assertFields(drink, representation);
	}
	
	/**
	 * Ensures that a List of {@link DrinkRepresentation} 
	 * is converted
	 */
	@Test
	public void testConvertToListRepresentation(){
		final Drink drink = Mockito.mock(Drink.class);
		
		List<Drink> list = new ArrayList<Drink>();
		list.add(drink);
		
		List<DrinkRepresentation> representationList = this.converter.toRepresentationList(list);
		
		Assert.assertNotNull(representationList);
		Assert.assertEquals(list.size(), representationList.size());
		
		for (DrinkRepresentation drinkRepresentation : representationList) {
			this.assertFields(drink,drinkRepresentation);
		}
	}

	/**
	 * Asserts each field of the domain and representation objects
	 * 
	 * @param expected - {@link Drink}
	 * @param current - {@link DrinkRepresentation}
	 */
	private void assertFields(final Drink expected, final DrinkRepresentation current){
		Assert.assertNotNull(current);
		Assert.assertEquals(expected.getName(), current.getName());
		Assert.assertEquals(expected.getId(), current.getId());
		Assert.assertEquals(expected.getRecipe(), current.getRecipe());
		Assert.assertEquals(expected.getType(), current.getType());
	}
}