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

import com.payamd.entities.Admin;
import com.payamd.repository.AdminDao;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// creating a object of AdminDao to perform crud Operation
	private AdminDao adminDao;

	public AdminServlet() {
		super();
	}
	
	public void init() {
		adminDao = new AdminDao();
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
			case "Adminnew":
				showNewForm(request, response); // calling method showNewForm()
				break;
			case "Admininsert":
				insertAdmin(request, response); // calling method insertAdmin()
				break;
			case "Admindelete":
				deleteAdmin(request, response); // calling method deleteAdmin()
				break;
			case "Adminedit": 
				showEditForm(request, response); // calling method showEditForm()
				break;
			case "Adminupdate":
				updateAdmin(request, response); // calling method updateAdmin()
				break;
			case "AdminAuthenticate":
				try {
					authenticate(request, response); // calling method authenticate()
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case "Adminlist":
				listAdmin(request, response); // calling method listAdmin()
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Get all Admin details from database and store it as a list
		List<Admin> listAdmin = adminDao.getAllAdmin();

		// setting the attribute so that it can be displayed on View
		request.setAttribute("listAdmin", listAdmin);

		// Giving the path to the page to take to next page
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Giving the path to the page to take to next page
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		// getting id from form and converting it to type integer
		int id = Integer.parseInt(request.getParameter("id"));

		// getting All details of Admin corresponding to id field
		Admin existingAdmin = adminDao.getAdmin(id);

		// Giving the path to the page to take to next page
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminIndex.jsp");

		// setting the attribute so that it can be displayed on View
		request.setAttribute("admin", existingAdmin);

		dispatcher.forward(request, response);

	}

	private void insertAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// getting details from the view to the controller
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// initializing the values using constructor
		Admin newAdmin = new Admin(name, password);

		// saving the admin details using repository
		adminDao.saveAdmin(newAdmin);

		// calling admin list method
		response.sendRedirect("Admin?action=Adminlist");
	}

	private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		// getting details from the view to the controller
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// initializing the values using constructor
		Admin admin = new Admin(id, name, password);

		// updating the admin details using repository
		adminDao.updateAdmin(admin);

		// calling admin list method
		response.sendRedirect("Admin?action=Adminlist");
	}

	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		// deleting the admin details using id field in Database using Admin Repository
		adminDao.deleteAdmin(id);

		// calling admin list method
		response.sendRedirect("Admin?action=Adminlist");
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Getting name and password attribute from view
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// verifying the details and taking it to next page or showing an error message in console 
		if (adminDao.validate(name, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.html");
			dispatcher.forward(request, response);
		} else {
			System.out.println("Login not successful..");
		}
	}
}
