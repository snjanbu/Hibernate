/**
 * 
 */
package main.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.dto.UserDto;

public class HibernateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDto userDto=new UserDto();
		userDto.setUserId(6101);
		userDto.setUserName("Santhosh");
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDto);
		session.getTransaction().commit();
		session.close();

	}

}
