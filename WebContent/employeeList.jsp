<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<div>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.servletContext.contextPath}/employeeForm.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="listEmployees.action">Ver empleados</a></li>

				</ul>

			</div>
		</div>
	</nav>

	<div class="container">
		<h1>Lista de empleados</h1>
	</div>

	<div class="container">
		<table
			class="table table-responsive table-bordered table-striped table-hover">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Salario</th>
					<th>Id Jefe</th>
					<th>Id departamento</th>
					<th class="col-2 center-block">Acciones</th>
				</tr>
			</thead>

			<%
				List<Employee> emps = (List<Employee>) request.getAttribute("employees");
			Iterator<Employee> itr = emps.iterator();

			while (itr.hasNext()) {
				Employee emp = itr.next();
			%>
			<tbody>
				<tr>
					<td><%=emp.getId()%></td>
					<td><%=emp.getFirstName()%></td>
					<td><%=emp.getLastName()%></td>
					<td><%=emp.getSalary()%></td>
					<%if (emp.getManager() == null) {%>
						<td>Null</td>
					<%} else { %>
						<td><%= emp.getManager().getId() %></td>
					<%} %>
					<%if (emp.getDept() == null) {%>
						<td>Null</td>
					<%} else { %>
						<td><%= emp.getDept().getId() %></td>
					<%} %>
					
					<td><a class="btn btn-primary btn-sm"
						href="${pageContext.request.contextPath}/getDataForEdit?id=<%= emp.getId() %>">Editar</a>
						<a class="btn btn-danger btn-sm"
						href="${pageContext.servletContext.contextPath}/deleteEmployee?employeeId=<%= emp.getId() %>">Eliminar</a>
					</td>
				</tr>
			</tbody>

			<%
				}
			%>

		</table>

	</div>

</body>
</html>