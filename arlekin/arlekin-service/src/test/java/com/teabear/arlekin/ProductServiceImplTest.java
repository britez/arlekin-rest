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

import com.teabear.arlekin.exception.ProductNotFoundException;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link ProductServiceImpl}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	/** The service to test */
	private ProductServiceImpl service;
	
	/** The mocked dao */
	private ProductDao mockedDao;
	
	/**
	 * Initializes the test
	 */
	@Before
	public void setUp(){
		this.service = new ProductServiceImpl();
		this.mockedDao = Mockito.mock(ProductDao.class);
		ReflectionUtils.setField(this.service, "dao", this.mockedDao);
	}
	
	/**
	 * Ensures that a {@link Product} is retrieved
	 * @throws ProductNotFoundException if {@link Product} not exists
	 */
	@Test
	public void testProductDrink() throws ProductNotFoundException{
		final Product product = Mockito.mock(Product.class);
		Mockito.when(this.mockedDao.get(1L)).thenReturn(product);
		Product result = this.service.get("1");
		Assert.assertNotNull(result);
	}
	
	/**
	 * Ensures that a null {@link Product} is retrieved
	 * @throws ProductNotFoundException if {@link Product} not exists
	 */
	@Test(expected = ProductNotFoundException.class)
	public void testProductNullDrink() throws ProductNotFoundException{
		Mockito.when(this.mockedDao.get(1L)).thenReturn(null);
		Product result = this.service.get("1");
		Assert.assertNotNull(result);
	}
	
	/**
	 * Ensures that a List of {@link Product} is retrieved
	 */
	@Test
	public void testListProduct(){
		List<Product> result = this.service.list();
		Assert.assertNotNull(result);
	}
	
	
	/**
	 * Ensures that a List of {@link Product} is created
	 */
	@Test
	public void testCreateProduct(){
		final Product product = Mockito.mock(Product.class);
		Mockito.when(this.mockedDao.save(product)).thenReturn(product);
		Product result = this.service.create(product);
		Assert.assertNotNull(result);
	}
	
}
