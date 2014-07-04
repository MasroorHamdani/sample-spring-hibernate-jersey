package com.hashedin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.hashedin.model.Collaborator;

@Repository("collaboratorRepository")
public class CollaboratorRepositoryImpl implements CollaboratorRepository {

	@PersistenceContext
    private EntityManager em;
	
	public Collaborator find(Long collaboratorId) {
        // Returns the Collaborator for given collaboratorId.
        return em.find(Collaborator.class, collaboratorId);
    }

    public Collaborator save(Collaborator collaborator) {
        // Saves the given collaborator object and returns the same.
        em.persist(collaborator);
        em.flush();
        return collaborator;
    }

    public List<Collaborator> findAll() {
        // Returns all the collaborator in our system.
        TypedQuery<Collaborator> query = em.createNamedQuery("Collaborator.findAll", Collaborator.class);
        List<Collaborator> results = query.getResultList();
        return results;
    }

    public Collaborator update(Collaborator collaborator, Long collaboratorId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Collaborator delete(Long collaboratorId)
    {
    	Collaborator collaboratorToBeDeleted = em.find(Collaborator.class, collaboratorId); 
        em.remove(collaboratorToBeDeleted);
        return collaboratorToBeDeleted;
    }
}
