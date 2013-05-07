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

import com.teabear.arlekin.Product;
import com.teabear.arlekin.representation.ProductRepresentation;

/**
 * Tests for {@link ProductConverter}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductConverterTest {
	
	/** Converter to test */
	private ProductConverter converter;
	
	/**
	 * Initializes the test */
	@Before
	public void setUp(){
		this.converter = new ProductConverter();
	}
	
	/**
	 * Ensures that a {@link ProductRepresentation} 
	 * is converted
	 */
	@Test
	public void testConvertToRepresentation(){
		final Product product = Mockito.mock(Product.class);
		ProductRepresentation representation = this.converter.toRepresentation(product);
		this.assertFields(product, representation);
	}
	
	/**
	 * Ensures that a List of {@link ProductRepresentation} 
	 * is converted
	 */
	@Test
	public void testConvertToListRepresentation(){
		final Product product = Mockito.mock(Product.class);
		
		List<Product> list = new ArrayList<Product>();
		list.add(product);
		
		List<ProductRepresentation> representationList = this.converter.toRepresentationList(list);
		
		Assert.assertNotNull(representationList);
		Assert.assertEquals(list.size(), representationList.size());
		
		for (ProductRepresentation productRepresentation : representationList) {
			this.assertFields(product,productRepresentation);
		}
	}
	
	/**
	 * Ensures that a {@link ProductRepresentation} is 
	 * converted to a {@link Product}
	 */
	@Test
	public void testConvertToDomain(){
		final ProductRepresentation product = Mockito.mock(ProductRepresentation.class);
		Product domainProduct = this.converter.toDomain(product);
		this.assertFields(product, domainProduct);
	}

	/**
	 * Asserts each field of the domain and representation objects
	 * 
	 * @param expected - {@link Product}
	 * @param current - {@link ProductRepresentation}
	 */
	private void assertFields(final Product expected, final ProductRepresentation current){
		Assert.assertNotNull(current);
		Assert.assertEquals(expected.getName(), current.getName());
		Assert.assertEquals(expected.getId(), current.getId());
	}
	
	/**
	 * Asserts each field of the domain and representation objects
	 * 
	 * @param expected - {@link Product}
	 * @param current - {@link ProductRepresentation}
	 */
	private void assertFields(final ProductRepresentation expected, final Product current){
		Assert.assertNotNull(current);
		Assert.assertEquals(expected.getName(), current.getName());
		Assert.assertEquals(expected.getId(), current.getId());
	}
}