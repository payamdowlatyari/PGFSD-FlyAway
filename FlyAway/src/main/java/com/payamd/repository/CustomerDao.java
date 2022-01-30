package com.payamd.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.payamd.entities.Customer;
import com.payamd.hibernatecfg.HibernateUtil;


public class CustomerDao {
	
	//Save Customer Details
	public void saveCustomer(Customer customer) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			session.save(customer);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Update Customer Details
	 
	public void updateCustomer(Customer customer) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the customer object
			session.update(customer);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Delete Student Details
	public void deleteCustomer(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			
			Customer customer = session.get(Customer.class, id);
			if (customer != null) {
				session.delete(customer);
				System.out.println("customer is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Display Customer Details
	public Customer getCustomer(int id) {

		Transaction transaction = null;
		Customer customer = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			customer = session.get(Customer.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customer;
	}
	
	//Display ALL Customer Details
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {

		Transaction transaction = null;
		List<Customer> listOfCustomer = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			listOfCustomer = session.createQuery("from Customer").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfCustomer;
	}
}

