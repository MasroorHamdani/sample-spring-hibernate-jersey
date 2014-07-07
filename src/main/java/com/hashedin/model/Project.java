package com.hashedin.model;

import java.util.List;
import java.util.Set;

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
@Table(name = "project")
@NamedQueries({
	@NamedQuery (name= "Project.findAll", query="select p from Project p")
	
})
public class Project {
	
	@Id
    @GeneratedValue
    private Long projectId;
	
	private String projectName;
	private String projectDesc;
	
	
	@XmlInverseReference (mappedBy="assignedProject")
	@OneToMany(fetch=FetchType.EAGER, mappedBy ="assignedProject", targetEntity=Task.class)
	private List<Task> task;
	
	
	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectID) {
		this.projectId = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + ", projectDesc=" + projectDesc + ", task="
				+ task + "]";
	}
	
}
