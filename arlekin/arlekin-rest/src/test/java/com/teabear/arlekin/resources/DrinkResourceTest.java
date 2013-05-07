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

}
