<%@page import="java.util.List"%>
<%@page import="com.capgemini.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <%List<EmployeeBean> employeeList = (List<EmployeeBean>) request.getAttribute("employeeList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center"><u> All Employees Details -</u></h2>
	<br><br>
	<table border="solid" align="center">
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Salary</th>
				<th>Designation</th>
			</tr>
		</thead>
		<tbody>
			<%for (EmployeeBean employeeBean : employeeList) { %>
				<tr>
					<td><%=employeeBean.getEmpId()%></td>
					<td><%=employeeBean.getEmpName()%></td>
					<td><%=employeeBean.getAge()%></td>
					<td><%=employeeBean.getSalary()%></td>
					<td><%=employeeBean.getPosition()%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>