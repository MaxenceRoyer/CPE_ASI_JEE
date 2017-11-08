package fr.cpe.rest.impl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/WatcherAuth")
public interface IWatcherAuthRestService {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/")
	void doPost(String login, String password);
	
}
