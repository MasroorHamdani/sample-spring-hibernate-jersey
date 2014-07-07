package com.hashedin.service;

import java.util.List;

import com.hashedin.model.Project;
import com.hashedin.model.Task;

public interface ProjectService {

	Project findParticularProject(Long projectId);

	List<Project> findAllProject();

	Project saveParticularProject(Project project);

	Project updateParticularProject(Project project, Long projectId);

	Project deleteParticularProject(Long projectId);

	List<Task> findParticularProjectTasks(Long projectId);

	List<Task> findParticularProjectTasksOnStatus(Long projectId, String status);
}
