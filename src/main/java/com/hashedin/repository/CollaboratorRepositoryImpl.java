package com.hashedin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hashedin.model.Collaborator;
import com.hashedin.model.Project;
import com.hashedin.model.Task;

@Repository("collaboratorRepository")
public class CollaboratorRepositoryImpl implements CollaboratorRepository {

	@PersistenceContext
    private EntityManager em;
	
	public Collaborator findParticularCollaborators(Long collaboratorId) {
        // Returns the Collaborator for given collaboratorId.
        return em.find(Collaborator.class, collaboratorId);
    }

    public Collaborator saveParticularCollaborators(Collaborator collaborator) {
        // Saves the given collaborator object and returns the same.
        em.persist(collaborator);
        em.flush();
        return collaborator;
    }

    public List<Collaborator> findAllCollaborators() {
        // Returns all the collaborator in our system.
    	//System.out.println("test Repository");
        TypedQuery<Collaborator> query = em.createNamedQuery("Collaborator.findAll", Collaborator.class);
        List<Collaborator> results = query.getResultList();
        return results;
    }

    public Collaborator updateParticularCollaborators(Collaborator collaborator, Long collaboratorId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Collaborator deleteParticularCollaborators(Long collaboratorId)
    {
    	Collaborator collaboratorToBeDeleted = em.find(Collaborator.class, collaboratorId); 
        em.remove(collaboratorToBeDeleted);
        return collaboratorToBeDeleted;
    }

	@Override
	public List<Task> findParticlarCollaboratorTasks(Long collaboratorId) {
		return em.find(Collaborator.class, collaboratorId).getTask();
	}
}
