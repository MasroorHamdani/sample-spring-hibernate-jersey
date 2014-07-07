package com.hashedin.service;

import java.util.List;

import com.hashedin.model.Collaborator;
import com.hashedin.model.Task;

public interface CollaboratorService {

	Collaborator findParticlarCollaborator(Long collaboratorId);
    List<Collaborator> findAllCollaborators();
    Collaborator saveParticlarCollaborator(Collaborator collaborator);
    Collaborator updateParticlarCollaborator(Collaborator collaborator, Long collaboratorId);
    Collaborator deleteParticlarCollaborator(Long collaboratorId);
    List<Task> findParticlarCollaboratorTasks(Long collaboratorId);
}
