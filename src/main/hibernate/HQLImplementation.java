package main.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		
		session.close();

		
		for(String s:resultList) {
			System.out.println(s);
		}
		
		for(StudentDto studentDto:studentDtoList) {
			System.out.println(studentDto);
		}
		
		for(StudentDto studentDto:studentDtoList1) {
			System.out.println(studentDto);
		}
		System.exit(1);
		

	}

}
