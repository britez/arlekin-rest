/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.teabear.arlekin.exception.DrinkNotFoundException;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link DrinkServiceImpl}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class DrinkServiceImplTest {
	
	/** The service to test */
	private DrinkServiceImpl service;
	
	/** The mocked dao */
	private DrinkDao mockedDao;
	
	/**
	 * Initializes the test
	 */
	@Before
	public void setUp(){
		this.service = new DrinkServiceImpl();
		this.mockedDao = Mockito.mock(DrinkDao.class);
		ReflectionUtils.setField(this.service, "dao", this.mockedDao);
	}
	
	/**
	 * Ensures that a {@link Drink} is retrieved
	 * @throws DrinkNotFoundException if drink not exists
	 */
	@Test
	public void testGetDrink() throws DrinkNotFoundException{
		final Drink drink = Mockito.mock(Drink.class);
		Mockito.when(this.mockedDao.get(1L)).thenReturn(drink);
		Drink result = this.service.get("1");
		Assert.assertNotNull(result);
	}
	
	/**
	 * Ensures that a null {@link Drink} is retrieved
	 * @throws DrinkNotFoundException if drink not exists
	 */
	@Test(expected = DrinkNotFoundException.class)
	public void testGetNullDrink() throws DrinkNotFoundException{
		Mockito.when(this.mockedDao.get(1L)).thenReturn(null);
		Drink result = this.service.get("1");
		Assert.assertNotNull(result);
	}
	
	/**
	 * Ensures that a List of {@link Drink} is retrieved
	 */
	@Test
	public void testListDrink(){
		List<Drink> result = this.service.list();
		Assert.assertNotNull(result);
	}
	
}
