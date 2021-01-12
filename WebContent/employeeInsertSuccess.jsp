<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Se ha ingresado el empleado</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellido</th>
		</tr>
		<tr>
			<td><s:property value="employee.id"/> </td>
			<td><s:property value="employee.firstName"/></td>
			<td><s:property value="employee.lastName"/></td>
		</tr>
	</table>

</body>
</html>