<%@page import="java.util.ArrayList"%>
<%@page import="neu.edu.data.UserRegistration"%>
<%@page import="neu.edu.data.UserSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<style type="text/css">

/* Add your table styling below */
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="logo.png" alt="Logo"></li>
		<li class="center">E-Notice Board</li>

		<li><a href="adminDashboard">Admin Dashboard</a></li>

		<li><a href="logout">Logout</a></li>
	</ul>



	<!-- Add your table of data below -->
	<div style="padding: 50px">
		<h1>Data Table</h1>
		<table>
			<tr>
				<th>Username</th>
				<th>Email</th>
				<th>Role</th>
				<th>Action</th>

			</tr>
			<%
			ArrayList<UserRegistration> userRegistrations = (ArrayList<UserRegistration>) request.getAttribute("userRegistrations");
			for (UserRegistration userRegistration : userRegistrations) {
			%>
			<!-- Add more rows of data as needed -->
			<tr>
				<td><%=userRegistration.getUsername()%></td>
				<td><%=userRegistration.getEmail()%></td>
				<td><%--userRegistration.getRole()--%></td>
				<td><button onclick="viewRow(this)">View</button></td>


			</tr>

			<%
			}
			%>
		</table>
	</div>
	
	<script type="text/javascript">
	 function viewRow(button) {
	        var row = button.parentNode.parentNode;
	        var cells = row.getElementsByTagName("td");
	       	console.log(cells[0].innerHTML,cells[1].innerHTML,cells[2].innerHTML);
	 }
	
	</script>

</body>
</html>