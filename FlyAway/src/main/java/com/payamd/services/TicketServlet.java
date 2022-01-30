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

import com.payamd.entities.Ticket;
import com.payamd.repository.TicketDao;



@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TicketDao ticketDao;
	
	public TicketServlet() {
		super();
	}
	
	public void init() {
		ticketDao = new TicketDao();
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
			case "ticketnew":
				showNewForm(request, response);
				break;
			case "ticketinsert":
				insertTicket(request, response);
				break;
			case "buyticket":
				buyTicket(request, response);
				break;
			case "confirmticket":
				showConfirmation(request, response);
				break;
			case "updateticket":
				updateTicket(request, response);
				break;
			case "ticketlist":
				listTicket(request, response);
				break;
			default:
				listTicket(request, response);
				break;
			}
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listTicket(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Ticket> listTicket = ticketDao.getAllTickets();
		request.setAttribute("listTicket", listTicket);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ticketDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ticketIndex.jsp");
		dispatcher.forward(request, response);
	}
	
	private void buyTicket(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));		
		Ticket existingTicket = ticketDao.getTicket(id);
		existingTicket.setStatus("paid");
		request.setAttribute("ticket", existingTicket);
		response.sendRedirect("ticket?action=confirmticket");
	}

	private void showConfirmation(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Ticket existingTicket = ticketDao.getTicket(id);
		request.setAttribute("ticket", existingTicket);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ticketConfirm.jsp");
		dispatcher.forward(request, response);

	}

	private void updateTicket(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		int flight_id = Integer.parseInt(request.getParameter("flight_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		String status = request.getParameter("status");
		Ticket newTicket = new Ticket(id, first_name,last_name, flight_id, quantity, price, status);

		ticketDao.updateTicket(newTicket);
		response.sendRedirect("ticket?action=ticketlist");

	}
	private void insertTicket(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		int flight_id = Integer.parseInt(request.getParameter("flight_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		String status = request.getParameter("status");
		
		
		Ticket newTicket = new Ticket(id, first_name,last_name, flight_id, quantity, price, status);

		ticketDao.saveTicket(newTicket);
		response.sendRedirect("ticket?action=ticketlist");
	}


}


