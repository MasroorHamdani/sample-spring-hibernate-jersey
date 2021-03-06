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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.model.Project;
import com.hashedin.model.Task;
import com.hashedin.service.ProjectService;

@Component
@Path("/projects")
public class ProjectResource {
	@Autowired
	private ProjectService projectService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Project> listAllProjects() {
		// Handles GET on /projects. Lists all the projects we have in our
		// system.
		return projectService.findAllProject();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{projectId}/tasks")
	public List<Task> getParticularProjectTasks(@PathParam("projectId") Long projectId, 
			@QueryParam("status") String status) 
			{
		// Handles GET on /projects/{projectId}/task. Returns a list of tasks
		// for the given projectId.
		if(status.isEmpty()){
			return projectService.findParticularProjectTasks(projectId);
		}
		else{
			return projectService.findParticularProjectTasksOnStatus(projectId,
					status);
		}
	}
/*	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{projectId}/task?status={status}")
	public List<Task> getParticularProjectTasksOnStatus(
			@PathParam("projectId") Long projectId,
			@PathParam("status") String status) {
		// Handles GET on /projects/{projectId}/task?status={status}.
		// Returns a list of tasks for the given projectId.
		return projectService.findParticularProjectTasksOnStatus(projectId,
				status);
	}*/

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{projectId}")
	public Project getParticularProject(@PathParam("projectId") Long projectId) {
		// Handles GET on /projects/{projectId}. Returns a single project for
		// the given projectId.
		return projectService.findParticularProject(projectId);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createParticularProject(Project project,
			@Context final HttpServletResponse response)
			throws URISyntaxException {
		// Handles POST on /projects. Creates a new project and adds it into an
		// repository.
		projectService.saveParticularProject(project);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/projects/" + project.getProjectId()))
				.build();
	}

	@PUT
	@Path("/{projectId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Project updateParticularProject(Project project,
			@PathParam("projectId") Long projectId) {
		// Handles PUT on /projects/projectId. Updates the existing project with
		// the new values.
		return projectService.updateParticularProject(project, projectId);
	}

	@DELETE
	@Path("/{projectId}")
	public Project deleteParticularProject(
			@PathParam("projectId") Long projectId) {
		// Handles DELETE on /projects/projectId. Deletes the existing project
		// and returns the same.
		return projectService.deleteParticularProject(projectId);
	}
}
