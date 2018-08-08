package main.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.dto.EmployeeDto;
import main.dto.ProjectDto;

public class MappingImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeDto employeeDto1=new EmployeeDto();
		employeeDto1.setEmployeeName("Sanjayanbu");
		
		EmployeeDto employeeDto2=new EmployeeDto();
		employeeDto2.setEmployeeName("Santhosh");

		ProjectDto projectDto1=new ProjectDto();
		projectDto1.setProjectName("HUE");
		
		ProjectDto projectDto2=new ProjectDto();
		projectDto2.setProjectName("Company");

		List <ProjectDto>projectDtoList=new ArrayList<>();
		projectDtoList.add(projectDto1);
		projectDtoList.add(projectDto2);
		
		employeeDto1.setProjectDtoList(projectDtoList);
		employeeDto1.setEmployeeId(6100);
		
		employeeDto2.setProjectDtoList(projectDtoList);
		employeeDto2.setEmployeeId(6101);
		
		List <EmployeeDto>employeeList=new ArrayList<>();
		employeeList.add(employeeDto1);
		employeeList.add(employeeDto2);
		
		projectDto1.setEmployeeDtoList(employeeList);
		projectDto2.setEmployeeDtoList(employeeList);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(employeeDto1);
		session.save(employeeDto2);
		session.save(projectDto1);
		session.save(projectDto2);
		session.getTransaction().commit();
		session.close();
		System.exit(1);

	}

}
