/*
 * Arlekin - Barras moviles
 */
package com.teabear.arlekin;


/**
 * This Class represents the types that
 * a {@link DrinkImpl} can be.
 * 
 * @author Maximiliano Britez
 */
public enum Type {
	
	DIRECT("Directo"),
	FROZEN("Frozen"),
	SHAKED("Batidos"),
	ICE_CREAM("Helados"),
	SHOTS("Shoters");
	
	/** The display name*/
	private String displayName;
	
	/** Constructor */
	Type(final String displayName){
		this.displayName = displayName;
	}
	
	@Override
	public String toString(){
		return this.displayName;
	}

}
