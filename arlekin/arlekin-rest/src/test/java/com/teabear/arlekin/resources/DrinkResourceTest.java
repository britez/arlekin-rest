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

import com.teabear.arlekin.Drink;
import com.teabear.arlekin.DrinkService;
import com.teabear.arlekin.converter.DrinkConverter;
import com.teabear.arlekin.exception.DrinkNotFoundException;
import com.teabear.arlekin.exception.ProductNotFoundException;
import com.teabear.arlekin.representation.DrinkRepresentation;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link DrinkResource}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class DrinkResourceTest {
	
	/** The resource to test */
	private DrinkResource resource;
	
	/** The mocked Service */
	private DrinkService mockedService;
	
	/** The mocked converter */
	private DrinkConverter mockedConverter;
	
	/** Initialize the tests */
	@Before
	public void setUp(){
		this.resource = new DrinkResource();
		this.mockedService = Mockito.mock(DrinkService.class);
		this.mockedConverter = Mockito.mock(DrinkConverter.class);
		ReflectionUtils.setField(resource, "service", mockedService);
		ReflectionUtils.setField(resource, "converter", mockedConverter);
	}
	
	/**
	 * Test getting the {@link Drink}
	 */
	@Test
	public void testGetDrink(){
		Response result = this.resource.get("drinkId");
		Assert.assertNotNull(result);
		Assert.assertEquals(Status.OK.getStatusCode(), result.getStatus());
	}
	
	/**
	 * Test getting and NOT FOUND status
	 */
	@Test
	public void testDrinkNotFound() throws DrinkNotFoundException{
		Mockito.when(this.mockedService.get("drinkId")).thenThrow(new DrinkNotFoundException());
		Response result = this.resource.get("drinkId");
		Assert.assertNotNull(result);
		Assert.assertEquals(Status.NOT_FOUND.getStatusCode(), result.getStatus());
	}
	
	/**
	 * Test getting a List of {@link Drink}
	 */
	@Test
	public void testGetAll(){
		Response result = this.resource.list();
		Assert.assertNotNull(result);
		Assert.assertEquals(Status.OK.getStatusCode(), result.getStatus());
	}
	
	/**
	 * Ensures that a {@link Drink} is created
	 * @throws ProductNotFoundException if the test fails
	 */
	@Test
	public void testCreateDrink() throws ProductNotFoundException{
		final DrinkRepresentation drink = Mockito.mock(DrinkRepresentation.class);
		final Drink mockedDrink = Mockito.mock(Drink.class);
		
		Mockito.when(this.mockedConverter.toDomain(drink)).thenReturn(mockedDrink);
		Mockito.when(this.mockedService.create(mockedDrink)).thenReturn(mockedDrink);
		
		Response result = this.resource.create(drink);
		Assert.assertNotNull(result);
		Assert.assertEquals(Status.CREATED.getStatusCode(), result.getStatus());
	}
	
	
	/**
	 * Ensures that a {@link Drink} is not created
	 * @throws ProductNotFoundException 
	 */
	@Test
	public void testCreateDrinkFail() throws ProductNotFoundException {
		final DrinkRepresentation drink = Mockito.mock(DrinkRepresentation.class);
		final Drink mockedDrink = Mockito.mock(Drink.class);
		
		Mockito.when(this.mockedConverter.toDomain(drink)).thenReturn(mockedDrink);
		Mockito.when(this.mockedService.create(mockedDrink)).thenThrow(new ProductNotFoundException());
		
		Response result = this.resource.create(drink);
		Assert.assertNotNull(result);
		Assert.assertEquals(Status.BAD_REQUEST.getStatusCode(), result.getStatus());
	}
}