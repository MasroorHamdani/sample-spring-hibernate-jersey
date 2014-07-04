package com.hashedin.service;

import java.util.List;

import com.hashedin.model.Collaborator;

public interface CollaboratorService {

	Collaborator find(Long collaboratorId);
    List<Collaborator> findAll();
    Collaborator save(Collaborator collaborator);
    Collaborator update(Collaborator collaborator, Long collaboratorId);
    Collaborator delete(Long collaboratorId);
}
