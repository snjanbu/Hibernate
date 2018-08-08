package main.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ProjectDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int projectId;
	
	private String projectName;

	@ManyToMany(mappedBy="projectDtoList")
	private List<EmployeeDto> employeeDtoList;
	
	public List<EmployeeDto> getEmployeeDtoList() {
		return employeeDtoList;
	}

	public void setEmployeeDtoList(List<EmployeeDto> employeeDtoList) {
		this.employeeDtoList = employeeDtoList;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
