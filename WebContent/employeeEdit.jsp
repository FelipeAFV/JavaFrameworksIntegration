<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edicion de empleados</title>
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
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="listEmployees.action">Ver empleados</a></li>

				</ul>

			</div>
		</div>
	</nav>
	<div class="container">
		<h1>Edicion de empleado</h1>
		<s:form action="editEmployee">
			<s:textfield label="Id" name="employeeId" value="%{employee.id}"></s:textfield>
			<s:textfield label="Nombre" name="firstName"
				value="%{employee.firstName}"></s:textfield>
			<s:textfield label="Apellido" name="lastName"
				value="%{employee.lastName}"></s:textfield>
			<s:textfield label="Sueldo" name="salary" value="%{employee.salary}"></s:textfield>
			<s:textfield label="Id departamento" name="departmentId"
				value="%{employee.dept.id}"></s:textfield>
			<s:textfield label="Id manager" name="managerId"
				value="%{employee.manager.id}"></s:textfield>
			<s:submit value="Editar"></s:submit>
		</s:form>
	</div>


</body>
</html>