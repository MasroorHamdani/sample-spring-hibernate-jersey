package com.hashedin.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tasks")
@NamedQueries({
		@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
	//	@NamedQuery(name = "Task.findByCollList", query = "SELECT t FROM Task t WHERE t.assignedTo.collaboratorId = :colId")
		@NamedQuery(name = "Task.findAllByStatus", query = "select t from Task t where t.assignedProject.projectId=:projId  and "
				+ "t.status = :status")		
})
public class Task {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;
	private Date createdOn;
	private Date dueDate;
	private String priority;
	private String status;

	@ManyToOne
	@JoinColumn(name = "collaboratorId", referencedColumnName = "collaboratorId")
	private Collaborator assignedTo;

	@ManyToOne
	@JoinColumn(name = "projectId", referencedColumnName = "projectId")
	private Project assignedProject;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Collaborator getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Collaborator assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Project getAssignedProject() {
		return assignedProject;
	}

	public void setAssignedProject(Project assignedProject) {
		this.assignedProject = assignedProject;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
