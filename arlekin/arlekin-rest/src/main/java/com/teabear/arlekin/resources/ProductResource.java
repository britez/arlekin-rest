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

import com.teabear.arlekin.Product;
import com.teabear.arlekin.ProductService;
import com.teabear.arlekin.converter.ProductConverter;
import com.teabear.arlekin.exception.ProductNotFoundException;
import com.teabear.arlekin.representation.ProductRepresentation;

/**
 * This class allows API to handle a {@link Product},
 * methods allowed are GET, PUT, POST, DELETE.
 * 
 * @author Maximiliano Britez
 */
@Path(ProductResource.PATH)
public class ProductResource {

	/** The PATH to resource */
	static final String PATH = "api/products";
	
	/** The service */
	@Autowired
	private ProductService service;
	
	/** The converter */
	@Autowired
	private ProductConverter converter;
	
	/** @return a list of available products */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){
		return Response.ok(this.converter.toRepresentationList(this.service.list())).build();
	}
	
	/**
	 * 
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(final ProductRepresentation product){
		final Product result;
		result = this.service.create(this.converter.toDomain(product));
		URI location = UriBuilder.fromPath(ProductRepresentation.PATH + "/" + result.getId()).build();
		return Response.created(location).build();
		
	}
	
	/**
	 * @param id - {@link String} the id of the product to retrieve
	 * @return a {@link ProductRepresentation}
	 */
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response get(@PathParam("id") final String id){
		final Product product;
		try{
			product = this.service.get(id);
		}catch(final ProductNotFoundException e){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(this.converter.toRepresentation(product)).build();
	}
	
}