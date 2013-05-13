/*
 * Arlekin - Barras moviles 
 */
package com.teabear.arlekin.resources;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import com.teabear.arlekin.Drink;
import com.teabear.arlekin.DrinkImpl;
import com.teabear.arlekin.DrinkService;
import com.teabear.arlekin.converter.DrinkConverter;
import com.teabear.arlekin.exception.DrinkNotFoundException;
import com.teabear.arlekin.representation.DrinkRepresentation;

/**
 * This class allows API to handle a {@link DrinkImpl},
 * methods allowed are GET, PUT, POST, DELETE.
 * 
 * @author Maximiliano Britez
 */
@Path(DrinkResource.PATH)
public class DrinkResource {

	/** The PATH to resource */
	static final String PATH = "api/drinks";
	
	/** The service */
	@Autowired
	private DrinkService service;
	
	/** The converter */
	@Autowired
	private DrinkConverter converter;
	
	/** @return a list of available drinks */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){
		return Response.ok(this.converter.toRepresentationList(this.service.list())).build();
	}
	
	/**
	 * @param id - {@link String} the id of the drink to retrieve
	 * @return a {@link DrinkRepresentation}
	 */
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response get(@PathParam("id") final String id){
		final Drink drink;
		try{
			drink = this.service.get(id);
		}catch(final DrinkNotFoundException e){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(this.converter.toRepresentation(drink)).build();
	}
	
	/**
	 * @param drink - {@link DrinkRepresentation} to be created
	 * @return {@link Response} with the created
	 * {@link DrinkRepresentation} location
	 */
	@POST
	public Response create(final DrinkRepresentation drink){
		Drink result = this.service.create(this.converter.toDomain(drink));
		URI location = UriBuilder.fromPath(DrinkRepresentation.PATH + "/" + result.getId()).build();
		return Response.created(location).build();
	}
	
}