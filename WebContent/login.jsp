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
		
	<div class="container">
		<h1 class="display-3 my-4 text-center">Ingresa tus credenciales</h1>
	</div>
	
	
	
	<div class="container col-md-4">
				
		<s:form action="checkUser" theme="simple" cssClass="">
		  <div class="form-group">
		    <label for="username">ID</label>
		    <s:textfield id="username" name="username" label="Id" cssClass="form-control"></s:textfield>
		  </div>
		  <div class="form-group">
		    <label for="password">Nombre</label>
		    <s:textfield id="password" name="password" label="Nombre" cssClass="form-control"></s:textfield>
		  </div>
	
		  <div class="form-group">
		    <s:submit value="Ingresar" cssClass="btn btn-primary my-3"></s:submit>
		  </div>
		</s:form>
		

	</div>
</body>
</html>