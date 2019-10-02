<%@page import="com.capgemini.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
<%EmployeeBean employeeBean = (EmployeeBean) request.getAttribute("employeeBean"); %>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./searchEmployee" method="post">
		<table>
			<tr>
				<td>Emp ID</td>
				<td> : </td>
				<td><input type="number" name="empId" required></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Search Employee">
				</td>
			</tr>
		</table>
	</form>
	<br><br> 
	
	<%if(employeeBean != null) { %>
		Employee Name : <%=employeeBean.getEmpName()%><br><br>
		Position : <%=employeeBean.getPosition() %><br><br>
		Age  : <%=employeeBean.getAge() %><br><br>
		Salary : <%=employeeBean.getSalary() %>
		<br>
	<%} %>	
	<%if(msg != null && !msg.isEmpty()) {%>
	<%=msg %>
	<%} %>
</body>
</html>
