package main.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class EmployeeDto {
	
	@Id
	private int employeeId;
	
	private String employeeName;
	
	@OneToMany
	@NotFound(action=NotFoundAction.IGNORE)
	@Cascade(value=CascadeType.PERSIST)
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
