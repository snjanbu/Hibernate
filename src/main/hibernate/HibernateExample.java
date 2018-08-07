/**
 * 
 */
package main.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.dto.UserDto;

public class HibernateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Setting the UserDto
		 */
		UserDto userDto=new UserDto();
		userDto.setUserId(6101);
		userDto.setUserName("Santhosh");
		userDto.setDescription("Sandy");
		userDto.setJoiningDate(new Date());
		userDto.setJoiningTime(new Date());
		
		/**
		 * Creating the Session Factory
		 */
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		/**
		 * Insertion
		 */
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDto);
		session.getTransaction().commit();
		session.close();

		/**
		 * Retrieval
		 */
		userDto=null;
		session =sessionFactory.openSession();
		userDto=(UserDto)session.get(UserDto.class, 6101);
		System.out.println(userDto.getDescription());
		session.close();
	}

}
