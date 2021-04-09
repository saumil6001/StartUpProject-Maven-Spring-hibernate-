package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Customer;

public class HibernateDao {

	public static void main(String[] args) {
		
		
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		session.beginTransaction();
		
		session.save(addCustomer("Saumil","Patel",1,"Surveyor","Smoker"));
		
		session.getTransaction().commit();
		
	}

	

	public static Customer addCustomer(String firstName,String lastName,int addressId,String occupation,String smoker) {
		
		return new Customer(firstName,lastName,addressId,occupation,smoker);
		
	}
	
}
