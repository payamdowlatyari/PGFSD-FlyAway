package com.payamd.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.payamd.entities.Ticket;
import com.payamd.hibernatecfg.HibernateUtil;


public class TicketDao {
	
	//Save Ticket
	public void saveTicket(Ticket ticket) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the ticket object
			session.save(ticket);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}

	//Display Ticket Details
	public Ticket getTicket(int id) {

		Transaction transaction = null;
		Ticket ticket = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			ticket = session.get(Ticket.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return ticket;
	}
	
	public void updateTicket(Ticket ticket) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.update(ticket);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	
	//Display ALL Tickets
	@SuppressWarnings("unchecked")
	public List<Ticket> getAllTickets() {

		Transaction transaction = null;
		List<Ticket> listOfTicket = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start a transaction
			transaction = session.beginTransaction();
			
			listOfTicket = session.createQuery("from Ticket").getResultList();
			
			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				
			}
			e.printStackTrace();
			
		}
		
		return listOfTicket;
	}
}

