<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>
	<h1>Lista de empleados</h1>
	<div class="container">
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellido</th>
			</tr>
			<%  List<Employee> emps = (List<Employee>) request.getAttribute("employees");
				Iterator<Employee> itr = 	emps.iterator();
				
				while (itr.hasNext()) {
					Employee emp = itr.next();
				
			%>
				<tr>
					<td><%= emp.getId() %></td>
					<td><%= emp.getFirstName()%></td>
					<td><%= emp.getLastName() %></td>
					<td>
						<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/getDataForEdit?id=<%= emp.getId() %>">Editar</a>
						<a class="btn btn-danger btn-sm" href="${pageContext.servletContext.contextPath}/employeeForm.jsp">Eliminar</a>
					</td>
				</tr>
			
			
			<%} %>
		
		</table>
	
	</div>
	
</body>
</html>