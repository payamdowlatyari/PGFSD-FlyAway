<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><%@include file="css/style.jsp"%>

<title>Customer Management Application</title>
</head>
<body>
	<center>
		<h1>Customer Management</h1>
	</center>
	<a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
	<div align="center" class="table">
		<table border="1" cellpadding="5" class="table-bodered">
			<h2>List of Customers</h2>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				
				<th scope="col">Operations</th>
			</tr>
			<c:forEach var="customer" items="${listCustomer}">
				<tr>
					<td><c:out value="${customer.id}" /></td>
					<td><c:out value="${customer.first_name}" /></td>
					<td><c:out value="${customer.last_name}" /></td>
					
					<td><a href="customer?action=customeredit&id=<c:out value='${customer.id}' />"><button type="button" class="btn btn-warning">Edit</button></a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="customer?action=customerdelete&id=<c:out value='${customer.id}' />"><button type="button" class="btn btn-danger">Delete</button></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<h2 align="center">
		<a href="customer?action=customernew"><button type="button"
				class="btn btn-info">Add New Customer</button></a>


	</h2>
</body>
</html>
