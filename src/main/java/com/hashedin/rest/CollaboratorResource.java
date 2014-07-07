package com.hashedin.rest;

import org.apache.log4j.Logger;

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
import com.hashedin.model.Task;
import com.hashedin.service.CollaboratorService;


@Component
@Path("/collaborators")
public class CollaboratorResource {
	static Logger logger = Logger.getLogger(CollaboratorResource.class);

	@Autowired
	private CollaboratorService collaboratorService;
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Collaborator> listAllCollaborators()
    {
        // Handles GET on /collaborators. Lists all the Collaborators we have in our system.
	//	System.out.println("test Resource");
		return collaboratorService.findAllCollaborators();
    }

   @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{collaboratorId}")
    public Collaborator getParticlarCollaborator(@PathParam("collaboratorId") Long collaboratorId)
    {
	  // logger.info("Hello this is an info message");
	   // Handles GET on /collaborators/{collaboratorId}. Returns a single Collaborator for the given collaboratorId.
        return collaboratorService.findParticlarCollaborator(collaboratorId);
    }
   
   @GET
   @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
   @Path("/{collaboratorId}/tasks")
   public List<Task> getParticlarCollaboratorTasks(@PathParam("collaboratorId") Long collaboratorId)
   {
	//   logger.info("Hello this is an info message");
	   // Handles GET on /collaborators/{collaboratorId}. Returns a single Collaborator for the given collaboratorId.
       return collaboratorService.findParticlarCollaboratorTasks(collaboratorId);
   }

    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createParticlarCollaborator(Collaborator collaborator, @Context final HttpServletResponse response) throws URISyntaxException
    {
        // Handles POST on /collaborators. Creates a new Collaborator and adds it into an repository.
    	collaboratorService.saveParticlarCollaborator(collaborator);
        response.setStatus(Response.Status.CREATED.getStatusCode());
        return Response.created(new URI("/collaborators/" + collaborator.getCollaboratorId())).build();
    }
    
    @PUT
    @Path("/{collaboratorId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collaborator updateParticlarCollaborator(Collaborator collaborator, @PathParam("collaboratorId") Long collaboratorId)
    {
        // Handles PUT on /collaborators/collaboratorId. Updates the existing collaborator with the new values.
        return collaboratorService.updateParticlarCollaborator(collaborator, collaboratorId);
    }
    
    @DELETE
    @Path("/{collaboratorId}")
    public Collaborator deleteParticlarCollaborator(@PathParam ("collaboratorId") Long collaboratorId)
    {
        // Handles DELETE on /collaborators/collaboratorId. Deletes the existing collaborator and returns the same.
        return collaboratorService.deleteParticlarCollaborator(collaboratorId);
    }

}
