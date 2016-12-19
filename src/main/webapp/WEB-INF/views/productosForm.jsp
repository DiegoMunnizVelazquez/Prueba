<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nueva Asignatura- Actualizar</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<div align="center">
		<h1>Nuevo/Modificar Asignatura</h1>
		<table border="1" class="table table-striped">
			<form:form action="save" method="post" modelAttribute="producto">
			<form:hidden path="id"/>
			<tr>
				<td>Producto:</td>
				<td><form:input path="producto"/></td>
			</tr>
			<tr>
				<td>Unidades:</td>
				<td><form:input path="unidades"/></td>
			</tr>
			 
			<tr>
				<td>Fecha:</td>
				<td><form:input path="fecha"/></td>
			</tr>
			
			<tr>
				<td>Precio:</td>
				<td><form:input path="precio"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-primary" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	
</body>
</html>