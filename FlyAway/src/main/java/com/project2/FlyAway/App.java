package com.project2.FlyAway;

import java.util.List;

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
    	
    	addCustomer(2, "Mina", "Fanaian");
    	addCustomer(3, "Sina", "Simon");
    	
    	getCustomer(1);
    	getCustomers();
    	
    	deleteCustomer(3);    	
        	ENTITY_MANAGER_FACTORY.close();
    }
    
    public static void addCustomer(int id, String fname, String lname) {
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
            cust.setId(id);
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
    	String query = "SELECT c FROM Customer c WHERE c.id = :custID";
    	
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
    	// :custID is a parameterized query thats value is set below
    	String strQuery = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Customer> tq = em.createQuery(strQuery, Customer.class);
    	List<Customer> custs;
    	try {
    		// Get matching customer object and output
    		custs = tq.getResultList();
    		
    		
    		for (int i = 0; i < custs.size(); i++) {
    			System.out.println(custs.get(i).getfName());
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
}
