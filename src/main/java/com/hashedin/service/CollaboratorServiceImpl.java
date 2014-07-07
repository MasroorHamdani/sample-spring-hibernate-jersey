package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.Collaborator;
import com.hashedin.model.Task;
import com.hashedin.repository.CollaboratorRepository;

@Service("collaboratorService")
public class CollaboratorServiceImpl implements CollaboratorService {
	
	@Autowired
    private CollaboratorRepository collaboratorRepository;
	

	public Collaborator findParticlarCollaborator(Long collaboratorId)
    {
        // Returns the Collaborator for given collaboratorId.
        return collaboratorRepository.findParticularCollaborators(collaboratorId);
    }


    @Transactional
    public Collaborator saveParticlarCollaborator(Collaborator collaborator)
    {
        // Saves the given Collaborator object and returns the same.
    	collaboratorRepository.saveParticularCollaborators(collaborator);
        return collaborator;
    }


    public List<Collaborator> findAllCollaborators()
    {
        // Returns all the Collaborator in our system.
    	//System.out.println("test service");
        return collaboratorRepository.findAllCollaborators();
    }


   @Override
    public Collaborator updateParticlarCollaborator(Collaborator collaborator, Long collaboratorId)
    {
        // Updates the Collaborator with the given collaboratorId;
        return null;
    }


    @Transactional
    public Collaborator deleteParticlarCollaborator(Long collaboratorId)
    {
        // Deletes the collaborator with the give collaboratorId and returns the same.
        return collaboratorRepository.deleteParticularCollaborators(collaboratorId);
    }


	@Override
	public List<Task> findParticlarCollaboratorTasks(Long collaboratorId) {
		return collaboratorRepository.findParticlarCollaboratorTasks(collaboratorId);
	}
}
