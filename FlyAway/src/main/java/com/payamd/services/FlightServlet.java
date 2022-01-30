package com.payamd.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payamd.entities.Flight;
import com.payamd.repository.FlightDao;


@WebServlet("/flight")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightDao flightDao;
	
	public FlightServlet() {
		super();
	}
	
	public void init() {
		flightDao = new FlightDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "flightnew":
				showNewForm(request, response);
				break;
			case "flightinsert":
				insertFlight(request, response);
				break;
			case "flightdelete":
				deleteFlight(request, response);
				break;
			case "flightedit":
				showEditForm(request, response);
				break;
			case "flightupdate":
				updateFlight(request, response);
				break;
			default:
				listFlight(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listFlight(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Flight> listFlight = flightDao.getAllFlights();
		request.setAttribute("listFlight", listFlight);
		RequestDispatcher dispatcher = request.getRequestDispatcher("flightDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("flightIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Flight existingFlight = flightDao.getFlight(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("flightIndex.jsp");
		request.setAttribute("flight", existingFlight);
		dispatcher.forward(request, response);

	}

	private void insertFlight(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String dep_airport = request.getParameter("dep_airport");
		String arr_airport = request.getParameter("arr_airport");
		String dep_time = request.getParameter("dep_time");
		String arr_time = request.getParameter("arr_time");
		
		int available_seats =  Integer.parseInt(request.getParameter("available_seats"));
		int price =  Integer.parseInt(request.getParameter("price"));
		
		Flight newFlight = new Flight(id, dep_airport, arr_airport, dep_time, arr_time, available_seats, price);
		flightDao.saveFlight(newFlight); 
		response.sendRedirect("flight?action=flightlist");
	}

	private void updateFlight(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String dep_airport = request.getParameter("dep_airport");
		String arr_airport = request.getParameter("arr_airport");
		String dep_time = request.getParameter("dep_time");
		String arr_time = request.getParameter("arr_time");
		
		int available_seats =  Integer.parseInt(request.getParameter("available_seats"));
		int price =  Integer.parseInt(request.getParameter("price"));
		

		Flight flight = new Flight(id, dep_airport, arr_airport, dep_time, arr_time, available_seats, price);
		flightDao.updateFlight(flight);
		response.sendRedirect("flight?action=flightlist");
	}

	private void deleteFlight(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		flightDao.deleteFlight(id);
		response.sendRedirect("flight?action=flightlist");
	}
}

