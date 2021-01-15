<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<!-- <html xmlns="http://www.w3.org/1999/xhtml"> -->
<!DOCTYPE html>
<html>
<head>
	 <title><decorator:title default="Sistema Empleados" /></title>
	 <decorator:head />
	 
	 <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
 </head>
 <body >
 
	 <nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<div >
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Inicio</a></li>
						<li class="nav-item"><a class="nav-link" href="listEmployees.action">Ver empleados</a></li>
						<li class="nav-item"><a class="nav-link" href="employeeForm.jsp">Agregar empleado</a></li>

					</ul>
	
				</div>
				
				<div >
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="logout">Cerrar sesión</a></li>	
					</ul>
				</div>
			</div>
		
		</nav>
		
 
	 	<decorator:body/>
	 	
	 	
<!-- 	 	<footer class="pt-4 my-md-5 pt-md-5 border-top bg-light"> -->
<!-- 		  <div class="container text-center"> -->
<!-- 		    <span class="text-muted">©2021 Felipe Figueroa.</span> -->
<!-- 		  </div> -->
<!-- 		</footer> -->
		<!-- Modal -->

 </body>
 </html>