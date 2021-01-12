<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleados</title>
</head>
<body>
	<h1>Manejo de empleados</h1>
	<s:form action="insertEmployee">
		<s:textfield label="Id:" name="employeeId"></s:textfield>
		<s:textfield label="Nombre:" name="firstName"></s:textfield>
		<s:textfield label="Apellido:" name="lastName"></s:textfield>
		<s:textfield label="Sueldo:" name="salary"></s:textfield>
		<s:textfield label="Id departamento" name="departmentId"></s:textfield>
		<s:textfield label="Id manager" name="managerId"></s:textfield>
		<s:submit value="Añadir"></s:submit>
	</s:form>
	
	<a href="listEmployees.action">Listar empleados</a>
</body>
</html>