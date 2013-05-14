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
import com.teabear.arlekin.Recipe;
import com.teabear.arlekin.Type;
import com.teabear.arlekin.representation.DrinkRepresentation;
import com.teabear.arlekin.representation.RecipeRepresentation;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link DrinkConverter}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class DrinkConverterTest {
	
	/** Converter to test */
	private DrinkConverter converter;
	
	/** mocked converter */
	private RecipeConverter mockedRecipeConverter;
	
	/**
	 * Initializes the test */
	@Before
	public void setUp(){
		this.converter = new DrinkConverter();
		this.mockedRecipeConverter = Mockito.mock(RecipeConverter.class);
		ReflectionUtils.setField(this.converter, "recipeConverter", mockedRecipeConverter);
	}
	
	/**
	 * Ensures that a {@link DrinkRepresentation} 
	 * is converted
	 */
	@Test
	public void testConvertToRepresentation(){
		final Drink drink = Mockito.mock(Drink.class);
		final Recipe mockedRecipe = Mockito.mock(Recipe.class);
		final RecipeRepresentation mockedRecipeRepresentation = Mockito.mock(RecipeRepresentation.class);
		
		Mockito.when(drink.getType()).thenReturn(Type.DIRECT);
		Mockito.when(drink.getRecipe()).thenReturn(mockedRecipe);
		Mockito.when(this.mockedRecipeConverter.toRepresentation(mockedRecipe)).thenReturn(mockedRecipeRepresentation);
		
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
		final Recipe mockedRecipe = Mockito.mock(Recipe.class);
		final RecipeRepresentation mockedRecipeRepresentation = Mockito.mock(RecipeRepresentation.class);
		
		Mockito.when(drink.getType()).thenReturn(Type.DIRECT);
		Mockito.when(drink.getRecipe()).thenReturn(mockedRecipe);
		Mockito.when(this.mockedRecipeConverter.toRepresentation(mockedRecipe)).thenReturn(mockedRecipeRepresentation);
		
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
	 * Ensures that a representation is converted
	 * to domain.
	 */
	@Test
	public void testConvertToDomain(){
		final DrinkRepresentation rep = Mockito.mock(DrinkRepresentation.class);
		this.converter.toDomain(rep);
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
		Assert.assertNotNull(current.getRecipe());
	}
}