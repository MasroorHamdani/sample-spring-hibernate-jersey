package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Collaborator;


public interface CollaboratorRepository {
	Collaborator find(Long collaboratorID);
    List<Collaborator> findAll();
    Collaborator save(Collaborator collaborator);
    Collaborator update(Collaborator collaborator, Long collaboratorId);
    Collaborator delete(Long collaboratorId);
}
