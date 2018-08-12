package main.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.dto.FourWheelerDto;
import main.dto.TwoWheelerDto;
import main.dto.VehicleDto;

public class InheritanceImplementation {
	
	public static void main(String[] args) {

		VehicleDto vehicleDto=new VehicleDto();
		vehicleDto.setVehicleName("Bicycle");
		
		TwoWheelerDto twoWheelerDto=new TwoWheelerDto();
		twoWheelerDto.setVehicleName("Bike");
		twoWheelerDto.setSteeringHandle("Riding It");
		
		FourWheelerDto fourWheelerDto=new FourWheelerDto();
		fourWheelerDto.setVehicleName("Car");
		fourWheelerDto.setSteeringWheel("Steering It");
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicleDto);
		session.save(twoWheelerDto);
		session.save(fourWheelerDto);
		session.getTransaction().commit();
		session.close();
		System.exit(1);
	}
}
