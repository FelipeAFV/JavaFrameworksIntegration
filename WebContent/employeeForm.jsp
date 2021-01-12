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
		<h1 class="display-3 my-4">Agregar empleados</h1>
	</div>
	
	
	
	<div class="container col-md-4">
<%-- 		<s:form action="insertEmployee" theme="simple" cssClass=""> --%>
<%-- 			<s:textfield label="Id" name="employeeId"></s:textfield> --%>
<%-- 			<s:textfield label="Nombre" name="firstName"></s:textfield> --%>
<%-- 			<s:textfield label="Apellido" name="lastName"></s:textfield> --%>
<%-- 			<s:textfield label="Sueldo" name="salary"></s:textfield> --%>
<%-- 			<s:textfield label="Id departamento" name="departmentId"></s:textfield> --%>
<%-- 			<s:textfield label="Id manager" name="managerId"></s:textfield> --%>
<%-- 			<s:submit value="Añadir"></s:submit> --%>
<%-- 		</s:form> --%>
		
		
		<s:form action="insertEmployee" theme="simple" cssClass="">
		  <div class="form-group">
		    <label for="id">ID</label>
		    <s:textfield id="id" label="Id" name="employeeId" cssClass="form-control"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="firstName">Nombre</label>
		    <s:textfield id="firstName" label="Nombre" name="firstName" cssClass="form-control"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="lastName">Apellido</label>
		    <s:textfield id="lastName" label="Apellido" name="lastName" cssClass="form-control"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="salary">Sueldo</label>
		    <s:textfield id="salary" label="Sueldo" name="salary" cssClass="form-control"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="department">ID Departamento</label>
		    <s:textfield id="department" label="Id departamento" name="departmentId" cssClass="form-control"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="manager">ID Manager</label>
		    <s:textfield id="manager" label="Id manager" name="managerId" cssClass="form-control"></s:textfield>
		  </div>
		  <div class="form-group">
		    <s:submit value="Añadir" cssClass="btn btn-primary my-3"></s:submit>
		  </div>
		</s:form>

	</div>
</body>
</html>