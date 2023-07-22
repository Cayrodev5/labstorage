<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="project_laboratory.models.entities.Material" %>
<%@ page import="java.util.ArrayList"%>

<% ArrayList<Material> list = (ArrayList<Material>) request.getAttribute("listofmaterials"); %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css" />
    <title>Lab Storage - Materials</title>
</head>

	<h1>List of Materials</h1>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Manufacturer</th>
				<th>Units</th>
				<th>Manufacturing Date</th>
				<th>Expiration Date</th>
				<th>Options</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i < list.size(); i ++) { %>
			<tr>
				<td><%= list.get(i).getId()%></td>
				<td><%= list.get(i).getName()%></td>
				<td><%= list.get(i).getManufacturer()%></td>
				<td><%= list.get(i).getUnits()%></td>
				<td><%= list.get(i).getManufacturingDate()%></td>
				<td><%= list.get(i).getExpirationDate()%></td>
				<td><a href="select?id=<%=list.get(i).getId() %>">Edit</a>
				<a href="javascript: confirmation(<%= list.get(i).getId()%>)">Delete</a></td>
			
			</tr>	
			
			<% } %>
		</tbody>
	</table>
	<script type="text/javascript" src="scripts/confirm.js"></script>
</body>
</html>