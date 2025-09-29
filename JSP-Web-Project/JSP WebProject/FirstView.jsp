<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>First View</h1>
		<form action="FirstServlet" method="post">
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="Enter First Name"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName" value=""
						placeholder="Enter last Name"></td>
				</tr>
				<tr>
					<th>Login</th>
					<td><input type="text" name="login" value=""
						placeholder="Login Id"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="text" name="password" value=""
						placeholder="Enter First Name"></td>
				</tr>
				<tr>
					<th>DOB</th>
					<td><input type="date" name="dob" value="" place holder="DOB"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="Save"></td>
				</tr>
				<h1><%=firstName%></h1>
				<h1><%=lastName%></h1>
				<h1><%=login%></h1>
				<h1><%=password%></h1>
				<h1><%=dob%></h1>
				
			</table>
	</div>
</body>
</html>