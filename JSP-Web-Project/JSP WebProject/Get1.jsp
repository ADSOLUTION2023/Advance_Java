<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String firstName = request.getParameter("firstName");
String lastName = request.getParameter("lastName");
String age = request.getParameter("age");
String email = request.getParameter("email");
String address = request.getParameter("address");
String city = request.getParameter("city");
String state = request.getParameter("state");
String pincode = request.getParameter("pincode");

%>
<h1><%=firstName %></h1>
<h1><%=lastName %></h1>
<h1><%=age %></h1>
<h1><%=email %></h1>
<h1><%=address %></h1>
<h1><%=city %></h1>
<h1><%=state %></h1>
<h1><%=pincode %></h1>
</body>
</html>