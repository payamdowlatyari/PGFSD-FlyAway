<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><%@include file="css/style.jsp"%>

<title>Ticket Confirmation</title>
</head>
<body>
	<center>
		<h1>Ticket Confirmation</h1>
		
	</center>
	<a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
	<div align="center"  class="table">
		<table border="0" cellpadding="5" class="table-bodered">
	
				<h2>Thank you for your purchase!</h2>
		
			<tr>
			<th scope="col">Ticket No</th>
				<th  scope="col">First Name</th>
				<th  scope="col">Last Name</th>
				<th  scope="col">Flight ID</th>
				<th  scope="col">Quantity</th>
			 	<th  scope="col">Price</th>
			 	<th  scope="col">Status</th>
			
			
			
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
			
				</tr>
			</c:forEach>
		</table>
	</div><br>
	
</body>
</html>
