package com.project2.FlyAway;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class App 
{
	
	  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
	            .createEntityManagerFactory("FlyAway");
	    
    public static void main( String[] args )
    {
    	Scanner inputReader = new Scanner(System.in);
    	
    	getFlights();
    	
    	System.out.println("Select a flight number");
    	int flight = inputReader.nextInt();
    	
    	System.out.println("Please enter you first name");
    	String firstname = inputReader.next();
    	 
    	System.out.println("Please enter you last name");
    	String lastname = inputReader.next(); 
    	
    	addCustomer(firstname, lastname);
    	getCustomers();

        	ENTITY_MANAGER_FACTORY.close();
    }
    
    public static void addCustomer(String fname, String lname) {
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Create and set values for new customer
            Customer cust = new Customer();
            // cust.setId(id);
            cust.setfName(fname);
            cust.setlName(lname);
 
            // Save the customer object
            em.persist(cust);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }
    
    
    public static void getCustomer(int id) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :custID is a parameterized query thats value is set below
    	String query = "SELECT c FROM Customer c WHERE c.id = :customer_id";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
    	tq.setParameter("custID", id);
    	
    	Customer cust = null;
    	try {
    		// Get matching customer object and output
    		cust = tq.getSingleResult();
    		System.out.println(cust.getfName() + " " + cust.getlName());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void getCustomers() {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	// the lowercase c refers to the object
    	String strQuery = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Customer> tq = em.createQuery(strQuery, Customer.class);
    	List<Customer> custs;
    	try {
    		// Get matching customer object and output
    		custs = tq.getResultList();
    		
    		
    		for (int i = 0; i < custs.size(); i++) {
    			System.out.println(custs.get(i).getId()
    					+ " | " + custs.get(i).getfName()
    		+ " | " + custs.get(i).getlName());
    		}
    		
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void deleteCustomer(int id) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Customer cust = null;
 
        try {
            et = em.getTransaction();
            et.begin();
            cust = em.find(Customer.class, id);
            em.remove(cust);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }
    
    
    public static void getFlights() {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	// Issue the query and get a matching objects from Flight table
    	String strQuery = "SELECT f FROM Flight f WHERE f.id IS NOT NULL";
    	
    	TypedQuery<Flight> tq = em.createQuery(strQuery, Flight.class);
    	List<Flight> flights;
    	try {
    		
    		flights = tq.getResultList();
    		
    		for (int i = 0; i < flights.size(); i++) {
    			System.out.println(flights.get(i).getId() 
    					+ " | " + flights.get(i).getDep_airport()
    					+ " | " + flights.get(i).getArr_airport()
    					+ " | " + flights.get(i).getDep_time()
    					+ " | " + flights.get(i).getArr_time()
    					+ " | " + flights.get(i).getAvailable_seats()
    					+ " | " + flights.get(i).getPrice());	
    		}
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void createTicket(int cid, int fid, int quantity) {
    	
    }
}
