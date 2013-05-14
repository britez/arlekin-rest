/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.teabear.arlekin.exception.ProductNotFoundException;
import com.teabear.arlekin.utils.ReflectionUtils;

/**
 * Tests for {@link ElementServiceImpl}
 *  
 * @author Maximiliano Britez
 */
@RunWith(MockitoJUnitRunner.class)
public class ElementServiceImplTest {
	
	/** The service to test */
	private ElementServiceImpl service;
	
	/** The mocked product service */
	private ProductService mockedProductService;
	
	/** The mocked dao */
	private ElementDao mockedDao;
	
	/**
	 * Initializes the test
	 */
	@Before
	public void setUp(){
		this.service = new ElementServiceImpl();
		this.mockedDao = Mockito.mock(ElementDao.class);
		this.mockedProductService = Mockito.mock(ProductService.class);
		ReflectionUtils.setField(this.service, "dao", this.mockedDao);
		ReflectionUtils.setField(this.service, "productService", this.mockedProductService);
	}
	
	/**
	 * Ensures that a {@link Element} is created
	 * @throws ProductNotFoundException if the product not exists
	 */
	@Test
	public void testCreateElement() throws ProductNotFoundException{
		final Element element = Mockito.mock(Element.class);
		final Product mockedProduct = Mockito.mock(Product.class);
		
		Mockito.when(element.getProduct()).thenReturn(mockedProduct);
		Mockito.when(mockedProduct.getId()).thenReturn(1L);
		Mockito.when(this.mockedProductService.create(mockedProduct)).thenReturn(mockedProduct);
		this.service.create(element);
	}

	/**
	 * Ensures that a List of {@link Element} is created
	 * @throws ProductNotFoundException if the product not exists
	 */
	@Test
	public void testCreateElementList() throws ProductNotFoundException{
		List<Element> list = new ArrayList<Element>();
		final Element element = Mockito.mock(Element.class);
		final Product mockedProduct = Mockito.mock(Product.class);
		list.add(element);
		
		Mockito.when(element.getProduct()).thenReturn(mockedProduct);
		Mockito.when(mockedProduct.getId()).thenReturn(1L);
		Mockito.when(this.mockedProductService.create(mockedProduct)).thenReturn(mockedProduct);
		this.service.create(list);
	}
}
