/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teabear.arlekin.Drink;
import com.teabear.arlekin.DrinkImpl;
import com.teabear.arlekin.Type;
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

	/** The recipe converter dependency */
	@Autowired
	private RecipeConverter recipeConverter;

    /** List of properties to be ignored when converting. */
    private static final String[] IGNORED_PROPERTIES = new String[] {"recipe", "type"};
    
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
        representation.setType(drink.getType().toString());
        representation.setRecipe(this.recipeConverter.toRepresentation(drink.getRecipe()));
        return representation;
    }
    
    /**
     * Converts an {@link DrinkRepresentation} to an {@link Drink}.
     * 
     * @param drink - {@link DrinkRepresentation} to convert
     * @return {@link Drink}
     */
    public Drink toDomain(final DrinkRepresentation drink) {
    	Drink domain = new DrinkImpl();
        BeanUtils.copyProperties(drink, domain, IGNORED_PROPERTIES);
        //set other properties
        domain.setType(Type.create(drink.getType()));
        domain.setRecipe(this.recipeConverter.toDomain(drink.getRecipe()));
        return domain;
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