<%@page import="com.capgemini.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
    <% HttpSession session = request.getSession(false); 
    EmployeeBean employeeBean = (EmployeeBean) session.getAttribute("employeeBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC</title>
</head>
<body>
	<%if(employeeBean != null) { %>
		<h1>Hello <%=employeeBean.getEmpName()%></h1>
	<%} %>
	<h1>Welcome to Employee Home</h1><br/>
	<a href= "./addEmployee">Add Employee</a><br><br>
	<a href= "./updateEmployee">Update Employee</a><br><br>
	<a href= "./searchEmployee">Search Employee</a><br><br>
	<a href= "./deleteEmployee">Delete Employee</a><br><br>
	<a href= "./getAllEmployees">All Employee</a><br><br>
	<br>
	<a href= "./logout">Logout</a><br><br>
</body>
</html>