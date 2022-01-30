<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><%@include file="css/style.jsp"%>

<title>Flight Management Application</title>
</head>
<body>
	<center>
		<h1>Flight Management</h1>
		<h2>
			 <a href="flight?action=flightlist"><button type="button"
			class="btn btn-primary">Display
				All Flights</button></a>

		</h2>
	</center><a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
	<div align="center">
		<c:if test="${flight != null}">
			<form action="flight?action=flightupdate" method="post">
		</c:if>
		<c:if test="${flight == null}">
			<form action="flight?action=flightinsert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			
				<h2>
					<c:if test="${flight != null}">
            			Edit Flight
            		</c:if>
					<c:if test="${flight == null}">
            			Add New Flight
            		</c:if>
				</h2>
			
			<c:if test="${flight != null}">
				<input type="hidden" name="id" value="<c:out value='${flight.id}' />" />
			</c:if>
			<tr>
				<th>Departure Airport:</th>
				<td><input type="text"  class="form-control" required name="dep_airport" size="45"
					value="<c:out value='${flight.dep_airport}' />" /></td>
			</tr>
			<tr>
				<th>Arrival Airport:</th>
				<td><input type="text" class="form-control" required name="arr_airport" size="45"
					value="<c:out value='${flight.arr_airport}' />" /></td>
			</tr>
			<tr>
				<th>Departure Time:</th>
				<td><input type="text" class="form-control" required name="dep_time" size="45"
					value="<c:out value='${flight.dep_time}' />" /></td>
			</tr>
			<tr>
				<th>Arrival Time:</th>
				<td><input type="text" class="form-control" required name="arr_time" size="45"
					value="<c:out value='${flight.arr_time}' />" /></td>
			</tr>
			<tr>
				<th>Available Seats:</th>
				<td><input type="text" class="form-control" required name="available_seats" size="45"
					value="<c:out value='${flight.available_seats}' />" /></td>
			</tr>
			<tr>
				<th>Price:</th>
				<td><input type="text" class="form-control" required name="price" size="45"
					value="<c:out value='${flight.price}' />" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
