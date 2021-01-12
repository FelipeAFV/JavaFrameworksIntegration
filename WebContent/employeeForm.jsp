<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleados</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<div >
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="listEmployees.action">Ver empleados</a></li>

				</ul>

			</div>
		</div>
	</nav>
	
	<div class="container">
		<h1>Agregar empleados</h1>
	</div>
	
	
	
	<div class="container">
		<s:form action="insertEmployee">
			<s:textfield label="Id" name="employeeId"></s:textfield>
			<s:textfield label="Nombre" name="firstName"></s:textfield>
			<s:textfield label="Apellido" name="lastName"></s:textfield>
			<s:textfield label="Sueldo" name="salary"></s:textfield>
			<s:textfield label="Id departamento" name="departmentId"></s:textfield>
			<s:textfield label="Id manager" name="managerId"></s:textfield>
			<s:submit value="Añadir"></s:submit>
		</s:form>
	

	</div>
</body>
</html>