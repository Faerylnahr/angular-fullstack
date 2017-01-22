package de.faerylnahr.test.ngfullstackbackend.rest;

import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@Path("/properties")
public class PropertiesRestService {
	private CacheControl cc = CacheControl.valueOf("no-cache");
	
	@Resource
	private Map<String,String> projectPropertiesMap;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProperties() {
		try {
			log.error("Returning project properties: " + projectPropertiesMap.toString());
			return Response.ok(projectPropertiesMap).cacheControl(cc).build();
		} catch ( Exception ex ) {
			log.error("Error in PropertiesRestService::getProperties(), message: ", ex);
			return Response.serverError().cacheControl(cc).entity(ex.getMessage()).build();
		}
	}
}