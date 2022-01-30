<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><%@include file="css/style.jsp"%>

	<title>Customer Management Application</title>
</head>
<body>
	<center>
		<h1>Customer Management</h1>
        <h2>
        	
        	<a href="customer?action=customerlist"><button type="button"
			class="btn btn-primary">Display All Customers</button></a>
        	
        </h2>
	</center><a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
    <div align="center">
		<c:if test="${customer != null}">
			<form action="customer?action=customerupdate" method="post">
        </c:if>
        <c:if test="${customer == null}">
			<form action="customer?action=customerinsert" method="post">
        </c:if>
        <table border="1" cellpadding="5">

            	<h2>
            		<c:if test="${customer != null}">
            			Edit Customer
            		</c:if>
            		<c:if test="${customer == null}">
            			Add New Customer
            		</c:if>
            	</h2>
   
        		<c:if test="${customer != null}">
        			<input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
        		</c:if>            
            <tr>
                <th>First Name: </th>
                <td>
                	<input type="text" class="form-control" required name="first_name" size="45"
                			value="<c:out value='${customer.first_name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                	<input type="text" class="form-control" required name="last_name" size="45"
                			value="<c:out value='${customer.last_name}' />"
                	/>
                </td>
            </tr>
           
            <tr>
            	<td colspan="2" align="center">
            		<button type="submit" class="btn btn-success">Save</button>
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
