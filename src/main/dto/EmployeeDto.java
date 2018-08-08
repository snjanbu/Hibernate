package main.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EmployeeDto {
	
	@Id
	private int employeeId;
	
	private String employeeName;
	
	@ManyToMany
	private List<ProjectDto> projectDtoList;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public List<ProjectDto> getProjectDtoList() {
		return projectDtoList;
	}

	public void setProjectDtoList(List<ProjectDto> projectDtoList) {
		this.projectDtoList = projectDtoList;
	}

}
