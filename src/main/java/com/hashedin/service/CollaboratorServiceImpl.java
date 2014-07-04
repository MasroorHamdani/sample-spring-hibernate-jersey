package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hashedin.model.Collaborator;
import com.hashedin.repository.CollaboratorRepository;

@Service("collaboratorService")
public class CollaboratorServiceImpl implements CollaboratorService {
	
	@Autowired
    private CollaboratorRepository collaboratorRepository;
	

	public Collaborator find(Long collaboratorId)
    {
        // Returns the Collaborator for given collaboratorId.
        return collaboratorRepository.find(collaboratorId);
    }


    @Transactional
    public Collaborator save(Collaborator collaborator)
    {
        // Saves the given Collaborator object and returns the same.
    	collaboratorRepository.save(collaborator);
        return collaborator;
    }


    public List<Collaborator> findAll()
    {
        // Returns all the Collaborator in our system.
        return collaboratorRepository.findAll();
    }


   @Override
    public Collaborator update(Collaborator collaborator, Long collaboratorId)
    {
        // Updates the Collaborator with the given collaboratorId;
        return null;
    }


    @Transactional
    public Collaborator delete(Long collaboratorId)
    {
        // Deletes the collaborator with the give collaboratorId and returns the same.
        return collaboratorRepository.delete(collaboratorId);
    }
}
