package com.hashedin.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hashedin.model.Project;
import com.hashedin.model.Task;

@Repository("projectRepository")
public class ProjectRepositoryImpl implements ProjectRepository{
	
	@PersistenceContext
	private EntityManager em;

	public Project findParticularProject(Long projectId) {
        // Returns the Project for given projectId.
        return em.find(Project.class, projectId);
    }

    public Project saveParticularProject(Project project) {
        // Saves the given project object and returns the same.
        em.persist(project);
        em.flush();
        return project;
    }

    public List<Project> findAllProject() {
        // Returns all the projects in our system.
        TypedQuery<Project> query = em.createNamedQuery("Project.findAll", Project.class);
        List<Project> results = query.getResultList();
        return results;
    }

    public Project updateParticularProject(Project project, Long projectId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Project deleteParticularProject(Long projectId)
    {
    Project projectToBeDeleted = em.find(Project.class, projectId); 
        em.remove(projectToBeDeleted);
        return projectToBeDeleted;
    }

	public List<Task> findParticularProjectTasks(Long projectId) {
		return em.find(Project.class, projectId).getTask();
	}

	@Override
	public List<Task> findParticularProjectTasksOnStatus(Long projectId,
			String status) {
		List<Task> listTask= em.find(Project.class, projectId).getTask();
		List<Task> filtered=new ArrayList<Task>();
		for(Task task : listTask){
			if(task.getStatus()==status){
				filtered.add(task);
			}
		}
		return filtered;
	}
}
