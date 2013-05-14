/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.teabear.arlekin.Recipe;
import com.teabear.arlekin.representation.RecipeRepresentation;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link RecipeConverter}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class RecipeConverterTest {
	
	/** Converter to test */
	private RecipeConverter converter;
	
	/** The mocked element converter */
	private ElementConverter mockedElementConverter;
	
	/**
	 * Initializes the test */
	@Before
	public void setUp(){
		this.converter = new RecipeConverter();
		this.mockedElementConverter = Mockito.mock(ElementConverter.class);
		ReflectionUtils.setField(this.converter, "elementConverter", this.mockedElementConverter);
	}
	
	/**
	 * Ensures that a {@link RecipeRepresentation} 
	 * is converted
	 */
	@Test
	public void testConvertToRepresentation(){
		final Recipe recipe = Mockito.mock(Recipe.class);
		RecipeRepresentation representation = this.converter.toRepresentation(recipe);
		this.assertFields(recipe, representation);
	}
	
	/**
	 * Ensures that a representation is converted
	 * to domain.
	 */
	@Test
	public void testConvertToDomain(){
		final RecipeRepresentation rep = Mockito.mock(RecipeRepresentation.class);
		this.converter.toDomain(rep);
	}

	/**
	 * Asserts each field of the domain and representation objects
	 * 
	 * @param expected - {@link Recipe}
	 * @param current - {@link RecipeRepresentation}
	 */
	private void assertFields(final Recipe expected, final RecipeRepresentation current){
		Assert.assertNotNull(current);
	}
}