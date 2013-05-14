/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.teabear.arlekin.exception.ProductNotFoundException;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link RecipeServiceImpl}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplTest {
	
	/** The service to test */
	private RecipeServiceImpl service;
	
	/** The mocked recipe service */
	private ElementService mockedElementService;
	
	/** The mocked dao */
	private RecipeDao mockedDao;
	
	/**
	 * Initializes the test
	 */
	@Before
	public void setUp(){
		this.service = new RecipeServiceImpl();
		this.mockedDao = Mockito.mock(RecipeDao.class);
		this.mockedElementService = Mockito.mock(ElementService.class);
		ReflectionUtils.setField(this.service, "dao", this.mockedDao);
		ReflectionUtils.setField(this.service, "elementService", this.mockedElementService);
	}
	
	/**
	 * Ensures that a {@link Recipe} is created
	 * @throws ProductNotFoundException if the product not exists
	 */
	@Test
	public void testCreateRecipe() throws ProductNotFoundException{
		final Recipe recipe = Mockito.mock(Recipe.class);
		final Element mockedElement = Mockito.mock(Element.class);
		Mockito.when(this.mockedElementService.create(mockedElement)).thenReturn(mockedElement);
		this.service.create(recipe);
	}
	
}
