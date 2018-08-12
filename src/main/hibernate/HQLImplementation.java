package main.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import main.dto.StudentDto;

public class HQLImplementation {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int minUser=4;
		int maxUser=11;
		
		//Query Execution
		Query query=session.createQuery("select studentName from StudentDto where studentId > :minUser and studentId < :maxUser ");
		query.setInteger("minUser", minUser);
		query.setInteger("maxUser", maxUser);
		List<String> resultList=(List<String>)query.list();
		
		//NamedQuery
		Query namedQuery=session.getNamedQuery("StudentDto.ById");
		namedQuery.setInteger("studentId", 3);
		List <StudentDto>studentDtoList=(List<StudentDto>)namedQuery.list();
		
		//Named NativeQuery
		Query namedNativeQuery=session.getNamedQuery("StudentDto.SelectAll");
		List <StudentDto>studentDtoList1=(List<StudentDto>)namedNativeQuery.list();
		
		//Criteria
		Criteria criteria=session.createCriteria(StudentDto.class);
		criteria.add(Restrictions.or(Restrictions.lt("studentId", 5), Restrictions.eq("studentName", "Student 6")));
		List <StudentDto>criteriaList=(List<StudentDto>)criteria.list();
		
		//Projection
		Criteria projection=session.createCriteria(StudentDto.class).setProjection(Projections.property("studentName"));
		List<String> projectionList=(List<String>)projection.list();
		
		//ExampleUser
		StudentDto studentDto=new StudentDto();
		studentDto.setStudentName("Student %1%");
	    Example example=Example.create(studentDto).enableLike();
	    Criteria exampleCriteria=session.createCriteria(StudentDto.class).add(example);
	    List <StudentDto>exampleList=(List<StudentDto>)exampleCriteria.list();
		session.close();
		
		for(StudentDto s:exampleList) {
			System.out.println(s);
		}
	    
		for(String s:projectionList) {
			System.out.println(s);
		}

		for(StudentDto s:criteriaList) {
			System.out.println(s);
		}
		
		for(String s:resultList) {
			System.out.println(s);
		}
		
		for(StudentDto s:studentDtoList) {
			System.out.println(s);
		}
		
		for(StudentDto s:studentDtoList1) {
			System.out.println(s);
		}
		System.exit(1);
		

	}

}
