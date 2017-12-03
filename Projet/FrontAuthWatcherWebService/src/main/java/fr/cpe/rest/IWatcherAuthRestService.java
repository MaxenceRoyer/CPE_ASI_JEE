package fr.cpe.rest;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.cpe.rest.dto.UserAuth;
import fr.cpe.rest.dto.UserAuthResult;

@Path("/WatcherAuth")
public interface IWatcherAuthRestService{
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	UserAuthResult doPost(UserAuth userAuth);
	
}

