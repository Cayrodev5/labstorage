<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css" />
    <title>Lab Storage - Edit</title>
</head>
<body>
 	<h1>
        Lab <br>
        Storage
    </h1>
    
    <img src="img/icon1.png" alt="icon"></img>  


	<form action="update" method="get">
		<h3 class="formtext">ID:</h3><br>
		<input class="textfield" type="text" name="id" readonly value="<%= request.getAttribute("id")%>">
		<h3 class="formtext">Name:</h3><br>
		<input class="textfield" type="text" name="materialname" value="<%= request.getAttribute("materialname")%>"><br>
		<h3 class="formtext">Manufacturer:</h3><br>
		<input class="textfield" type="text" name="manufacturer" value="<%= request.getAttribute("manufacturer")%>"><br>
		<h3 class="formtext">Units:</h3><br>
		<input class="textfield" type="text" name="units" value="<%= request.getAttribute("units")%>"><br>
		<h3 class="formtext">Manufacturing Date:</h3><br>
		<input class="textfield" type="text" name="manufacturingdate" value="<%= request.getAttribute("manufacturingdate")%>"><br>
		<h3 class="formtext">Expiration Date:</h3><br>
		<input class="textfield" type="text" name="expirationdate" value="<%= request.getAttribute("expirationdate")%>"><br>
		<input class="buttons" type="submit" value="Salvar">
	</form>

</body>
</html>