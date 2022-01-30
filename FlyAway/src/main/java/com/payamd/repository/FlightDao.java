package com.payamd.repository;
	import java.util.List;

	import org.hibernate.Session;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

	import com.payamd.entities.Flight;
	import com.payamd.hibernatecfg.HibernateUtil;

	public class FlightDao {
			
			//Save Flight Details
			public void saveFlight(Flight flight) {
				Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					
					transaction = session.beginTransaction();
					
					session.save(flight);
					
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
			}

			//Update Flight Details
			 
			public void updateFlight(Flight flight) {
				Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					
					transaction = session.beginTransaction();
					
					session.update(flight);
					
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
			}

			//Delete Flight Details
			public void deleteFlight(int id) {

				Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					
					transaction = session.beginTransaction();

					
					Flight flight = session.get(Flight.class, id);
					if (flight != null) {
						session.delete(flight);
						System.out.println("flight is deleted");
					}

					transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
			}

			//Display  Specific Flight Details
			public Flight getFlight(int id) {

				Transaction transaction = null;
				Flight flight = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					
					transaction = session.beginTransaction();
					
					flight = session.get(Flight.class, id);
					
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
			
				return flight;
			}
			
			//Display  ALL Flight Details
			@SuppressWarnings("unchecked")
			public List<Flight> getAllFlights() {

				Transaction transaction = null;
				List<Flight> listOfFlight = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					
					transaction = session.beginTransaction();					
					
					listOfFlight = session.createQuery("from Flight").getResultList();
					
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
				return listOfFlight;
			}
		}
