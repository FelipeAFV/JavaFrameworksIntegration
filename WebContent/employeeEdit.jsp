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
	
	<div class="container text-center">
	
		<h1 class="display-4 my-4 text-center">Edición de empleado</h1>
	</div>
	
	<div class="container col-sm-4">
		
		<s:form action="editEmployee" theme="simple" cssClass="">
		  <div class="form-group">
		    <label for="id">ID</label>
		    <s:textfield id="id" label="Id" name="employeeId" cssClass="form-control" value="%{employee.id}"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="firstName">Nombre</label>
		    <s:textfield id="firstName" label="Nombre" name="firstName" cssClass="form-control" value="%{employee.firstName}"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="lastName">Apellido</label>
		    <s:textfield id="lastName" label="Apellido" name="lastName" cssClass="form-control" value="%{employee.lastName}"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="salary">Sueldo</label>
		    <s:textfield id="salary" label="Sueldo" name="salary" cssClass="form-control" value="%{employee.salary}"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="department">ID Departamento</label>
		    <s:textfield id="department" label="Id departamento" name="departmentId" cssClass="form-control" value="%{employee.dept.id}"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="manager">ID Manager</label>
		    <s:textfield id="manager" label="Id manager" name="managerId" cssClass="form-control" value="%{employee.manager.id}"></s:textfield>
		  </div>
		  <div class="form-group">
		    <s:submit value="Añadir" cssClass="btn btn-primary my-3"></s:submit>
		  </div>
		</s:form>
	</div>


</body>
</html>