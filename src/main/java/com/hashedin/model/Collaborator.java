package com.hashedin.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@XmlRootElement
@Entity
@Table(name = "collaborator")
@NamedQueries({ @NamedQuery(name = "Collaborator.findAll", query = "select c from Collaborator c")

})
public class Collaborator {

	@Id
	@GeneratedValue
	private Long collaboratorId;

	private String collaboratorName;
	private String collaboratorRole;
	private String emailID;

	@XmlInverseReference(mappedBy = "assignedTo")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "assignedTo", targetEntity = Task.class)
	private List<Task> task;

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public Long getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(Long collaboratorID) {
		this.collaboratorId = collaboratorID;
	}

	public String getCollaboratorName() {
		return collaboratorName;
	}

	public void setCollaboratorName(String collaboratorName) {
		this.collaboratorName = collaboratorName;
	}

	public String getCollaboratorRole() {
		return collaboratorRole;
	}

	public void setCollaboratorRole(String collaboratorRole) {
		this.collaboratorRole = collaboratorRole;
	}

}
