package com.thiennam23.RESTdemo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	private AlienRepository arepo = new AlienRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Alien> getAliens() {
		
		return arepo.getAliens();
	}
	
	@GET
	@Path("getAlien/{points}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("points") int points) {
		return arepo.getAlien(points);
	}
	
	@POST
	@Path("createAlien")
	public Alien createAlien(Alien a1) {
		System.out.println(a1);
		
		arepo.create(a1);
		
		return a1;
	}
}
