<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><%@include file="css/style.jsp"%>

<title>Ticket Management Application</title>
</head>
<body>
	<center>
		<h1>Ticket Management</h1>
		
	</center>
	<a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
	<div align="center"  class="table">
		<table border="1" cellpadding="5" class="table-bodered">
	
				<h2>List of Tickets</h2>
		
			<tr>
			<th scope="col">Ticket No</th>
				<th  scope="col">First Name</th>
				<th  scope="col">Last Name</th>
				<th  scope="col">Flight ID</th>
				<th  scope="col">Quantity</th>
			 	<th  scope="col">Price</th>
			 	<th  scope="col">Status</th>
				<th  scope="col">Operation</th>
			
			
			</tr>
			
			 <c:forEach var="ticket" items="${listTicket}">
				<tr>
				<td><c:out value="${ticket.id}" /></td>
					<td><c:out value="${ticket.first_name}" /></td>
					<td><c:out value="${ticket.last_name}" /></td>
					<td><c:out value="${ticket.flight_id}" /></td>
					<td><c:out value="${ticket.quantity}" /></td>
					
					 <td><c:out value="${ticket.price}" /></td> 
					 <td><c:out value="${ticket.status}" /></td>
				<td><a href="ticket?action=buyticket&id=<c:out value='${ticket.id}' />"><button type="button"
			class="btn btn-warning">Buy</button></a></td>
				</tr>
			</c:forEach> 
		</table>
	</div><br>
	<h2 align="center">
			<a href="ticket?action=ticketenew"><button type="button"
					class="btn btn-info">Add New Ticket</button></a>

		</h2>
</body>
</html>
