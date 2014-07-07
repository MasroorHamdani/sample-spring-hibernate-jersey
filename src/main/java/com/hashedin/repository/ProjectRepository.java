package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Project;
import com.hashedin.model.Task;

public interface ProjectRepository {

	Project findParticularProject(Long projectID);

	List<Project> findAllProject();

	Project saveParticularProject(Project project);

	Project updateParticularProject(Project project, Long projectId);

	Project deleteParticularProject(Long projectId);

	List<Task> findParticularProjectTasks(Long projectId);

	List<Task> findParticularProjectTasksOnStatus(Long projectId, String status);
}
