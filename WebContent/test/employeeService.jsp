<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test de servicio</title>
  <script type='text/javascript' src='/DemoFrameworksProject/dwr/engine.js'></script>
  <script type='text/javascript' src='/DemoFrameworksProject/dwr/interface/EmpService.js'></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<input type="text" id="idEmp" placeholder="Ingresa un id de empleado">
	<button onclick="infoEmpleado()">Obtener Info</button>
	<p id="result">Aquí se verá tu resultado...</p>
	
	
	<script type="text/javascript">
		function infoEmpleado() {
			alert($("#idEmp").val());
			EmpService.getJobInfo($("#idEmp").val() ,{
					callback: function (result) {$("#result").text(result)}

				});

		}

	</script>

</body>
</html>