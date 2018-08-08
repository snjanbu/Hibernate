/**
 * 
 */
package main.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.dto.Address;
import main.dto.UserDto;

public class HibernateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Setting the UserDto
		 */
		UserDto userDto=new UserDto();
		userDto.setUserName("Santhosh");
		userDto.setDescription("Sandy");
		userDto.setJoiningDate(new Date());
		userDto.setJoiningTime(new Date());
	
		/**
		 * Setting the UserDto
		 */
		UserDto userDto1=new UserDto();
		userDto1.setUserName("Sanjay");
		userDto1.setDescription("Sanjayanbu");
		userDto1.setJoiningDate(new Date());
		userDto1.setJoiningTime(new Date());
		Address address=new Address();
		address.setStreet("Bhagath Singh Street");
		address.setCity("Madurai");
		address.setState("TamilNadu");
		userDto1.setCompanyAddress(address);
		
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
		session.save(userDto1);
		session.getTransaction().commit();
		session.close();

		/**
		 * Retrieval
		 */
		userDto=null;
		session =sessionFactory.openSession();
		userDto=(UserDto)session.get(UserDto.class, 2);
		System.out.println(userDto.getCompanyAddress().getCity());
		session.close();
	}

}
