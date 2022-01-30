<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><%@include file="css/style.jsp"%>

	<title>Flight Management Application</title>
</head>
<body>
	<center>
		<h1>Flight Management</h1>
		
	</center><a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
    <div align="center" class="table">
        <table border="1" cellpadding="5" class="table-bodered">
        <h2>List of Flights</h2>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Departure Airport</th>
                <th scope="col">Arrival Airport</th>
                <th scope="col">Departure Time</th>
                <th scope="col">Arrival Time</th>
                <th scope="col">Available Seats</th>
                <th scope="col">Price</th>
                <th scope="col">Operations</th>
                
            </tr>
            <c:forEach var="flight" items="${listFlight}">
                <tr>
                    <td><c:out value="${flight.id}" /></td>
                    <td><c:out value="${flight.dep_airport}" /></td>
                    <td><c:out value="${flight.arr_airport}" /></td>
                    <td><c:out value="${flight.dep_time}" /></td>
                    <td><c:out value="${flight.arr_time}" /></td>
                    <td><c:out value="${flight.available_seats}" /></td>
                    <td><c:out value="${flight.price}" /></td>
                    <td>
                    	<a href="flight?action=flightedit&id=<c:out value='${flight.id}' />"><button type="button"
			class="btn btn-warning">Edit</button></a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="flight?action=flightdelete&id=<c:out value='${flight.id}' />"><button type="button"
			class="btn btn-danger">Delete</button></a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    <br>
        <h2 align="center">
        	<a href="flight?action=flightnew"><button type="button"
			class="btn btn-info">Add New Flight</button></a>
        	
        	
        </h2>
</body>
</html>
