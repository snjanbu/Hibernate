package main.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.dto.Address;
import main.dto.UserDetailsDto;

public class CollectionImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetailsDto userDetails=new UserDetailsDto();
		userDetails.setUserId(6100);
		userDetails.setUserName("Sanjay");
		List <Address>addressList=new ArrayList<>();
		Address address1=new Address();
		address1.setCity("Madurai");
		address1.setStreet("Bhagath Singh Street");
		address1.setState("TamilNadu");
		addressList.add(address1);
		
		Address address2=new Address();
		address2.setCity("Chennai");
		address2.setStreet("Second Street");
		address2.setState("TamilNadu");
		addressList.add(address2);
		
		userDetails.setAddressList(addressList);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
	}
}
