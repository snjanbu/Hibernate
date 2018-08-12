package main.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.dto.StudentDto;

public class CrudOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//Insert
		for(int i=1;i<=10;i++) {
			StudentDto studentDto=new StudentDto();
			studentDto.setStudentName("Student "+i);
			session.save(studentDto);
		}
		session.getTransaction().commit();
		session.close();
		
		//Retrieval
		session=sessionFactory.openSession();
		session.beginTransaction();
		StudentDto record=(StudentDto)session.get(StudentDto.class, 8);
		System.out.println(record.getStudentName());
		
		//Update
		record.setStudentName("Sanjayanbu");
		session.save(record);
		session.getTransaction().commit();
		session.close();
		
		//Delete
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(record);
		session.getTransaction().commit();
		session.close();
		System.exit(1);
	}

}
