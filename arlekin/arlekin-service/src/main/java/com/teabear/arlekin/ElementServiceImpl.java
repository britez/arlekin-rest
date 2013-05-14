/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.teabear.arlekin.exception.ProductNotFoundException;

/**
 * Implementation of {@link ElementService}
 * 
 * @author Maximiliano Britez
 */
public class ElementServiceImpl implements ElementService {
	
	/** The dao */
	@Autowired
	private ElementDao dao;
	
	/** The product Service*/
	@Autowired
	private ProductService productService; 

	/** {@inheritDoc} */
	@Override
	public List<Element> create(final List<Element> elements) throws ProductNotFoundException {
		List<Element> result = new ArrayList<Element>();
		for (Element element : elements) {
			result.add(this.create(element));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Element create(final Element element) throws ProductNotFoundException {
		element.setProduct(this.productService.get(element.getProduct().getId().toString()));
		return this.dao.save(element);
	}
	
}
