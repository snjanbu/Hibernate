package main.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("select studentName from StudentDto where studentId > 5 ");
		query.setFirstResult(2);
		query.setMaxResults(4);
		List<String> resultList=(List<String>)query.list();
		session.close();
		for(String name:resultList) {
			System.out.println(name);
		}
		System.exit(1);
		

	}

}
