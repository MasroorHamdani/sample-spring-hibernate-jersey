package com.hashedin.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.model.Collaborator;
import com.hashedin.service.CollaboratorService;


@Component
@Path("/collaborators")
public class CollaboratorResource {
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Collaborator> list()
    {
        // Handles GET on /collaborators. Lists all the Collaborators we have in our system.
        return collaboratorService.findAll();
    }

   @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{collaboratorId}")
    public Collaborator get(@PathParam("collaboratorId") Long collaboratorId)
    {
        // Handles GET on /collaborators/{collaboratorId}. Returns a single Collaborator for the given collaboratorId.
        return collaboratorService.find(collaboratorId);
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Collaborator collaborator, @Context final HttpServletResponse response) throws URISyntaxException
    {
        // Handles POST on /collaborators. Creates a new Collaborator and adds it into an repository.
    	collaboratorService.save(collaborator);
        response.setStatus(Response.Status.CREATED.getStatusCode());
        return Response.created(new URI("/collaborators/" + collaborator.getCollaboratorId())).build();
    }
    
    @PUT
    @Path("/{collaboratorId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collaborator update(Collaborator collaborator, @PathParam("collaboratorId") Long collaboratorId)
    {
        // Handles PUT on /collaborators/collaboratorId. Updates the existing collaborator with the new values.
        return collaboratorService.update(collaborator, collaboratorId);
    }
    
    @DELETE
    @Path("/{collaboratorId}")
    public Collaborator delete(@PathParam ("collaboratorId") Long collaboratorId)
    {
        // Handles DELETE on /collaborators/collaboratorId. Deletes the existing collaborator and returns the same.
        return collaboratorService.delete(collaboratorId);
    }

}
