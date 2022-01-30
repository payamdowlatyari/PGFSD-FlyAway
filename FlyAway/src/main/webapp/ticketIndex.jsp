<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><%@include file="css/style.jsp"%>

<title>Ticket Management Application</title>
</head>
<body>
	<center>
		<h1>Ticket Management</h1>
		<h2>
			 <a href="ticket?action=ticketlist"><button type="button"
			class="btn btn-primary">Display
				All Tickets</button></a>


		</h2>
	</center>
	<a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
	<div align="center">
		<c:if test="${ticket != null}">
			<form action="ticket?action=buyticket" method="post">
		</c:if>
		<c:if test="${ticket == null}">
			<form action="ticket?action=ticketinsert" method="post">
		</c:if>
		<table border="1" cellpadding="5">

			<h2>
			<c:if test="${ticket != null}">
            			Edit Ticket
            		</c:if>
				
				<c:if test="${ticket == null}">
            			Add New Ticket
            		</c:if>
			</h2>

			<c:if test="${ticket != null}">
				<input type="hidden" name="id"
					value="<c:out value='${ticket.id}' />" />
			</c:if>
		
			<tr>
				<th>Flight ID:</th>
				<td><input type="text" class="form-control" required name="flight_id" size="45"
					value="<c:out value='${ticket.flight_id}' />" /></td>
			</tr>
			<tr>
				<th>First Name:</th>
				<td><input type="text" class="form-control" required name="first_name" size="45"
					value="<c:out value='${ticket.first_name}' />" /></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><input type="text" class="form-control" required name="last_name" size="45"
					value="<c:out value='${ticket.last_name}' />" /></td>
			</tr>
			<tr>
				<th> Quantity:</th>
				<td><input type="text" class="form-control" required name="quantity" size="45"
					value="<c:out value='${ticket.quantity}' />" /></td>
			</tr>
			<tr>
				<th> Price:</th>
				<td><input type="text" class="form-control" required name="price" size="45"
					value="<c:out value='${ticket.price}' />" /></td>
			</tr>
		

			<tr>
				<td colspan="2" align="center"><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
