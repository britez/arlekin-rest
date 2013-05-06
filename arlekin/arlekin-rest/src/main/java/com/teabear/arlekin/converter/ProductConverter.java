/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.teabear.arlekin.Product;
import com.teabear.arlekin.ProductImpl;
import com.teabear.arlekin.representation.ProductRepresentation;

/**
 * This class converts (bidirectional) the {@link Product} 
 * domain object to {@link ProductRepresentation}  
 * representations.
 * 
 * @author Maximiliano Britez
 */
@Component
public class ProductConverter {

        /** List of properties to be ignored when converting. */
        private static final String[] IGNORED_PROPERTIES = new String[] {};
        
        /**
         * Converts an {@link Product} to an {@link ProductRepresentation}.
         * 
         * @param product - {@link Product} to convert
         * @return {@link ProductRepresentation}
         */
        public ProductRepresentation toRepresentation(final Product product) {
        	ProductRepresentation representation = new ProductRepresentation();
            BeanUtils.copyProperties(product, representation, IGNORED_PROPERTIES);
            //set other properties
            return representation;
        }        
        
        /**
         * Converts an {@link ProductRepresentation} to an {@link Product}.
         * 
         * @param product - {@link ProductRepresentation} to convert
         * @return {@link Product}
         */
		public Product toDomain(final ProductRepresentation product) {
			Product domain = new ProductImpl();
			BeanUtils.copyProperties(product, domain);
			return domain;
		}
        
        /**
         * Converts an {@link List} of {@link Product} to a 
         * {@link List} of {@link ProductRepresentation}.
         * 
         * @param drink - {@link Product} to convert
         * @return {@link ProductRepresentation}
         */
        public List<ProductRepresentation> toRepresentationList(final List<Product> products){
        	List<ProductRepresentation> result = new ArrayList<ProductRepresentation>();
        	for (Product product : products) {
				result.add(this.toRepresentation(product));
			}
        	return result;
        }
}