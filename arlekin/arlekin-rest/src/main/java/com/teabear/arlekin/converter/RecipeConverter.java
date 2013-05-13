/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.teabear.arlekin.Recipe;
import com.teabear.arlekin.RecipeImpl;
import com.teabear.arlekin.representation.RecipeRepresentation;

/**
 * This class converts (bidirectional) the {@link Recipe} 
 * domain object to {@link RecipeRepresentation}  
 * representations.
 * 
 * @author Maximiliano Britez
 */
@Component
public class RecipeConverter {

        /** List of properties to be ignored when converting. */
        private static final String[] IGNORED_PROPERTIES = new String[] {};
        
        /**
         * Converts an {@link Recipe} to an {@link RecipeRepresentation}.
         * 
         * @param recipe - {@link Recipe} to convert
         * @return {@link RecipeRepresentation}
         */
        public RecipeRepresentation toRepresentation(final Recipe recipe) {
        	RecipeRepresentation representation = new RecipeRepresentation();
            BeanUtils.copyProperties(recipe, representation, IGNORED_PROPERTIES);
            //set other properties
            return representation;
        }
        
        /**
         * Converts an {@link RecipeRepresentation} to an {@link Recipe}.
         * 
         * @param recipe - {@link RecipeRepresentation} to convert
         * @return {@link Recipe}
         */
        public Recipe toDomain(final RecipeRepresentation recipe) {
        	Recipe domain = new RecipeImpl();
            BeanUtils.copyProperties(recipe, domain, IGNORED_PROPERTIES);
            //set other properties
            return domain;
        }        
}