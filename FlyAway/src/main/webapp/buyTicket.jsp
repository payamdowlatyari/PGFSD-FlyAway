<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><%@include file="css/style.jsp"%>

<title>Purchase Ticket</title>
</head>
<body>
	<center>
		<h1>Purchase Ticket</h1>
		<h2>
			 <a href="ticket?action=ticketlist"><button type="button"
			class="btn btn-primary">Display
				All Tickets</button></a>


		</h2>
	</center>
	<a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
	<div align="center">
		
		<c:if test="${ticket == null}">
			<form action="ticket?action=insertticket" method="post">
		</c:if>
	<table border="1" cellpadding="5" class="table-bodered">
	
				<h2>Ticket Information</h2>
		
			<tr>
			<th  scope="col">Ticket ID</th>
				<th  scope="col">First Name</th>
				<th  scope="col">Last Name</th>
				<th  scope="col">Flight ID</th>
				<th  scope="col">Quantity</th>
			 	<th  scope="col">Price</th>
				<th  scope="col">Operation</th>
			
			
			</tr>
		

				<tr>
				<td><c:out value="${ticket.ticket_id}" /></td>
					<td><c:out value="${ticket.first_name}" /></td>
					<td><c:out value="${ticket.last_name}" /></td>
					<td><c:out value="${ticket.flight_id}" /></td>
					<td><c:out value="${ticket.quantity}" /></td>
					 <td><c:out value="${ticket.price}" /></td> 
				<td><a href="ticket?action=confirmticket&id=<c:out value='${ticket.ticket_id}' />"><button type="button"
			class="btn btn-warning">Place Order</button></a></td>
				</tr>
	
		</table>
		</form>
	</div>
</body>
</html>
