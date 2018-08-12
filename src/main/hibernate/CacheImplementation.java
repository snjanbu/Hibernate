package main.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.dto.StudentDto;

public class CacheImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Second-Level Cache
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		session.get(StudentDto.class, 1);
		session.close();
		
		Session session2 =sessionFactory.openSession();
		session2.beginTransaction();
		session2.get(StudentDto.class, 1);
		session2.close();
	
		//Second-Level Cache
		Session session3 =sessionFactory.openSession();
		session3.beginTransaction();
		Query query1=session3.createQuery("from StudentDto where studentId=1");
		query1.setCacheable(true);
		query1.list();
		session3.close();
		
		Session session4 =sessionFactory.openSession();
		session4.beginTransaction();
		Query query2=session4.createQuery("from StudentDto where studentId=1");
		query2.setCacheable(true);
		query2.list();
		session4.close();
	
		System.exit(1);
	}

}
