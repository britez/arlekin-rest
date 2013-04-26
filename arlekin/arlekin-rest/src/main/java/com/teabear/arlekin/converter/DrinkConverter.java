/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.teabear.arlekin.Drink;
import com.teabear.arlekin.representation.DrinkRepresentation;

/**
 * This class converts (bidirectional) the {@link Drink} 
 * domain object to {@link DrinkRepresentation}  
 * representations.
 * 
 * @author Maximiliano Britez
 */
@Component
public class DrinkConverter {

        /** List of properties to be ignored when converting. */
        private static final String[] IGNORED_PROPERTIES = new String[] {};
        
        /**
         * Converts an {@link Drink} to an {@link DrinkRepresentation}.
         * 
         * @param drink - {@link Drink} to convert
         * @return {@link DrinkRepresentation}
         */
        public DrinkRepresentation toRepresentation(final Drink drink) {
        	DrinkRepresentation representation = new DrinkRepresentation();
            BeanUtils.copyProperties(drink, representation, IGNORED_PROPERTIES);
            //set other properties
            representation.setType(drink.getType());
            return representation;
        }        
        
        /**
         * Converts an {@link List} of {@link Drink} to a 
         * {@link List} of {@link DrinkRepresentation}.
         * 
         * @param drink - {@link Drink} to convert
         * @return {@link DrinkRepresentation}
         */
        public List<DrinkRepresentation> toRepresentationList(final List<Drink> drinks){
        	List<DrinkRepresentation> result = new ArrayList<DrinkRepresentation>();
        	for (Drink drink : drinks) {
				result.add(this.toRepresentation(drink));
			}
        	return result;
        }
}