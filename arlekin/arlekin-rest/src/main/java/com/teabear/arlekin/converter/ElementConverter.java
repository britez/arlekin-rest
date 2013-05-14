/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teabear.arlekin.Element;
import com.teabear.arlekin.ElementImpl;
import com.teabear.arlekin.representation.ElementRepresentation;
import com.teabear.arlekin.representation.ElementsRepresentation;

/**
 * This class converts (bidirectional) the {@link Element} 
 * domain object to {@link ElementRepresentation}  
 * representations.
 * 
 * @author Maximiliano Britez
 */
@Component
public class ElementConverter {

    /** List of properties to be ignored when converting. */
    private static final String[] IGNORED_PROPERTIES = new String[] {"product"};
    
    /** The product Converter */
    @Autowired
    private ProductConverter productConverter;
    
    /**
     * Converts an {@link Element} to an {@link ElementRepresentation}.
     * 
     * @param element - {@link Element} to convert
     * @return {@link ElementRepresentation}
     */
    public ElementRepresentation toRepresentation(final Element element) {
    	ElementRepresentation representation = new ElementRepresentation();
        BeanUtils.copyProperties(element, representation, IGNORED_PROPERTIES);
        //set other properties
        representation.setProduct(this.productConverter.toRepresentation(element.getProduct()));
        return representation;
    }
    
    /**
     * Converts an {@link ElementRepresentation} to an {@link Element}.
     * 
     * @param element - {@link ElementRepresentation} to convert
     * @return {@link Element}
     */
    public Element toDomain(final ElementRepresentation element) {
    	Element domain = new ElementImpl();
        BeanUtils.copyProperties(element, domain, IGNORED_PROPERTIES);
        //set other properties
        domain.setProduct(this.productConverter.toDomain(element.getProduct()));
        return domain;
    }        
    
    /**
     * Converts an {@link List} of {@link Element} to a 
     * {@link ElementsRepresentation}.
     * 
     * @param elements - {@link Element} to convert
     * @return {@link ElementsRepresentation}
     */
    public ElementsRepresentation toRepresentationList(final List<Element> elements){
    	ElementsRepresentation result = new ElementsRepresentation();
    	List<ElementRepresentation> list = new ArrayList<ElementRepresentation>();
    	for (Element element : elements) {
			list.add(this.toRepresentation(element));
		}
    	result.setElement(list);
    	return result;
    }
    
    /**
     * Converts an {@link List} of {@link ElementRepresentation} to a 
     * {@link List} of {@link ElementRepresentation}.
     * 
     * @param drink - {@link ElementRepresentation} to convert
     * @return {@link Element}
     */
    public List<Element> toDomainList(final ElementsRepresentation elements){
    	List<Element> result = new ArrayList<Element>();
    	for (ElementRepresentation element : elements.getElement()) {
			result.add(this.toDomain(element));
		}
    	return result;
    }
}