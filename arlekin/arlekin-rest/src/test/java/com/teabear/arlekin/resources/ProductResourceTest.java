/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin.resources;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.teabear.arlekin.Product;
import com.teabear.arlekin.ProductService;
import com.teabear.arlekin.converter.ProductConverter;
import com.teabear.arlekin.exception.ProductNotFoundException;
import com.teabear.arlekin.representation.ProductRepresentation;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link ProductResource}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductResourceTest {
	
	/** The resource to test */
	private ProductResource resource;
	
	/** The mocked Service */
	private ProductService mockedService;
	
	/** The mocked converter */
	private ProductConverter mockedConverter;
	
	/** Initialize the tests */
	@Before
	public void setUp(){
		this.resource = new ProductResource();
		this.mockedService = Mockito.mock(ProductService.class);
		this.mockedConverter = Mockito.mock(ProductConverter.class);
		ReflectionUtils.setField(resource, "service", mockedService);
		ReflectionUtils.setField(resource, "converter", mockedConverter);
	}
	
	/**
	 * Ensures getting the {@link Product}
	 */
	@Test
	public void testGetProduct(){
		Response result = this.resource.get("productId");
		Assert.assertNotNull(result);
		Assert.assertEquals(Status.OK.getStatusCode(), result.getStatus());
	}
	
	/**
	 * Ensures getting and NOT FOUND status
	 */
	@Test
	public void testProductNotFound() throws ProductNotFoundException{
		Mockito.when(this.mockedService.get("productId")).thenThrow(new ProductNotFoundException());
		Response result = this.resource.get("productId");
		Assert.assertNotNull(result);
		Assert.assertEquals(Status.NOT_FOUND.getStatusCode(), result.getStatus());
	}
	
	/**
	 * Ensures getting a List of {@link Product}
	 */
	@Test
	public void testGetAll(){
		Response result = this.resource.list();
		Assert.assertNotNull(result);
		Assert.assertEquals(Status.OK.getStatusCode(), result.getStatus());
	}
	
	/**
	 * Ensures that a {@link Product} is created
	 */
	@Test
	public void testCreateProduct(){
		Product result = Mockito.mock(Product.class);
		ProductRepresentation product = Mockito.mock(ProductRepresentation.class);
		Mockito.when(this.mockedConverter.toDomain(product)).thenReturn(result);
		Mockito.when(this.mockedService.create(result)).thenReturn(result);
		Response response = this.resource.create(product);
		Assert.assertNotNull(response);
		Assert.assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
	}

}
