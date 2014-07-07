package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Collaborator;
import com.hashedin.model.Task;

public interface CollaboratorRepository {
	Collaborator findParticularCollaborators(Long collaboratorID);

	List<Collaborator> findAllCollaborators();

	Collaborator saveParticularCollaborators(Collaborator collaborator);

	Collaborator updateParticularCollaborators(Collaborator collaborator,
			Long collaboratorId);

	Collaborator deleteParticularCollaborators(Long collaboratorId);

	List<Task> findParticlarCollaboratorTasks(Long collaboratorId);
}
