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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	
  <script type='text/javascript' src='/DemoFrameworksProject/dwr/engine.js'></script>
  <script type='text/javascript' src='/DemoFrameworksProject/dwr/interface/EmpService.js'></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" 
  integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
   crossorigin="anonymous"></script>
  

</head>
<body>

<!-- 	<nav class="navbar navbar-expand-lg navbar-light bg-light"> -->
<!-- 		<div class="container-fluid"> -->
<!-- 			<div> -->
<!-- 				<ul class="navbar-nav me-auto mb-2 mb-lg-0"> -->
<!-- 					<li class="nav-item"><a class="nav-link active" -->
<!-- 						aria-current="page" -->
<%-- 						href="${pageContext.servletContext.contextPath}/employeeForm.jsp">Home</a></li> --%>
<!-- 					<li class="nav-item"><a class="nav-link" -->
<!-- 						href="listEmployees.action">Ver empleados</a></li> -->

<!-- 				</ul> -->

<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</nav> -->

	<div class="container my-3">
		<h1 class="display-4 my-4">Lista de empleados</h1>
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
					
					<td class="text-center"><a class="btn btn-primary btn-sm m-1"
						href="${pageContext.request.contextPath}/getDataForEdit?id=<%= emp.getId() %>"><i class="bi bi-pencil-square"></i></a>
						<a class="btn btn-danger btn-sm m-1"
						href="${pageContext.servletContext.contextPath}/deleteEmployee?employeeId=<%= emp.getId() %>"><i class="bi bi-trash"></i></a>
						<a onclick="infoJob(<%= emp.getId() %>)" class="btn btn-success btn-sm m-1"><i class="bi bi-plus-square"></i></a>
					</td>
				</tr>
			</tbody>

			<%
				}
			%>

		</table>

	</div>
	
	<div class="modal" id="empModal" tabindex="-1">
		
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					Información del empleado
				</div>
				
				<div class="modal-body">
					<p id="empInfo"></p>
				</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Cerrar</button>
				
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function infoJob(empId) {
		EmpService.getJobInfo(empId,{
			callback: function (jobTitle) {
				$("#empInfo").text("Cargo: " + jobTitle);
				$("#empModal").modal("show");
			}
			});

	}
		


	</script>

</body>
</html>