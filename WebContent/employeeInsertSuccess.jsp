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

	<div class="container my-4">
		<h1>Se ha ingresado el empleado</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<td><s:property value="employee.id"/> </td>
				<td><s:property value="employee.firstName"/></td>
				<td><s:property value="employee.lastName"/></td>
			</tr>
			</tbody>
			
		</table>
	</div>

</body>
</html>