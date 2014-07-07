package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.Project;
import com.hashedin.model.Task;
import com.hashedin.repository.ProjectRepository;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project findParticularProject(Long projectId) {
		// Returns the Project for given projectId.
		return projectRepository.findParticularProject(projectId);
	}

	@Transactional
	public Project saveParticularProject(Project project) {
		// Saves the given project object and returns the same.
		projectRepository.saveParticularProject(project);
		return project;
	}

	public List<Project> findAllProject() {
		// Returns all the projects in our system.
		return projectRepository.findAllProject();
	}

	public Project updateParticularProject(Project project, Long projectId) {
		// Updates the project with the given projectId;
		return null;
	}

	@Transactional
	public Project deleteParticularProject(Long projectId) {
		// Deletes the project with the give projectId and returns the same.
		return projectRepository.deleteParticularProject(projectId);
	}

	@Override
	public List<Task> findParticularProjectTasks(Long projectId) {
		//return a particular projects task
		return projectRepository.findParticularProjectTasks(projectId);
	}

	@Override
	public List<Task> findParticularProjectTasksOnStatus(Long projectId,
			String status) {
		// returns list of tasks on status on task
		return projectRepository.findParticularProjectTasksOnStatus(projectId,
				status);
	}
}
