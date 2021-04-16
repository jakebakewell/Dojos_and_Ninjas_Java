<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center pt-5 mb-5">Dojos</h1>
	<table class="table table-bordered table-hover text-center">
		<thead class="thead-dark">
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojos}" var="dojo">
			<tr class="table-info">
			    <td><a href="/dojo/${dojo.id}">${dojo.name}</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="d-flex justify-space-around">
		<a href="/dojo/new">New Dojo</a>
		<a href="/ninja/new">New Ninja</a>
	</div>
</body>
</html>