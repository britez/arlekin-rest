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

import com.teabear.arlekin.Element;
import com.teabear.arlekin.Recipe;
import com.teabear.arlekin.representation.ElementRepresentation;
import com.teabear.arlekin.representation.RecipeRepresentation;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link ElementConverter}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class ElementConverterTest {
	
	/** Converter to test */
	private ElementConverter converter;
	
	/** The mocked product converter */
	private ProductConverter mockedProductConverter;
	
	/**
	 * Initializes the test */
	@Before
	public void setUp(){
		this.converter = new ElementConverter();
		this.mockedProductConverter = Mockito.mock(ProductConverter.class);
		ReflectionUtils.setField(this.converter, "productConverter", this.mockedProductConverter);
	}
	
	/**
	 * Ensures that a {@link RecipeRepresentation} 
	 * is converted
	 */
	@Test
	public void testConvertToRepresentation(){
		final Element element = Mockito.mock(Element.class);
		ElementRepresentation representation = this.converter.toRepresentation(element);
		this.assertFields(element, representation);
	}
	
	/**
	 * Ensures that a representation is converted
	 * to domain.
	 */
	@Test
	public void testConvertToDomain(){
		final ElementRepresentation rep = Mockito.mock(ElementRepresentation.class);
		this.converter.toDomain(rep);
	}

	/**
	 * Asserts each field of the domain and representation objects
	 * 
	 * @param expected - {@link Recipe}
	 * @param current - {@link RecipeRepresentation}
	 */
	private void assertFields(final Element expected, final ElementRepresentation current){
		Assert.assertNotNull(current);
		Assert.assertEquals(expected.getQuantity(), current.getQuantity());
	}
}