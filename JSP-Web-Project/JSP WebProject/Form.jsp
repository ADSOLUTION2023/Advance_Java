<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data collection Form</title>
</head>
<body>
	<DIV ALIGN = "CENTER">
	<form action = "GetForm.jsp">
		<table> 
		  <tr> 
		   <th>First Name</th>
		   <td> <input type = "text" name = "firstName" value="" placeholder= "enter first name"> </td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td> <input type = "text" name = "lastName" value="" placeholder= "enter last name"> </td>
		</tr>
		<tr> 
		   <th>Login</th>
		   <td> <input type = "email" name = "login" value="" placeholder= "enter your email"> </td>
		</tr>
		<tr> 
		   <th>Password</th>
		   <td> <input type = "password" name = "password" value="" placeholder= "enter your password"> </td>
		</tr>
		<tr> 
		   <th>DOB</th>
		   <td> <input type = "date" name = "DOB" value=""> </td>
		</tr>
		<tr>
		<th></th>
		<td><input type = "Submit" value = "Save" name = "operation">
		</td>
		</tr>
		</table>
</form>


</DIV>
</body>
</html>