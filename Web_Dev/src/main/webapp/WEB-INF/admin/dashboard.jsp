<%@page import="neu.edu.data.UserSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css" >
</head>
<body>

	<ul>
		<li class="logo"><img src="logo.png" alt="Logo"></li>
     	 <li class="center">E-Notice Board</li>
		
		<li><a href="logout">Logout</a></li>
		<li><a href="controller?action=viewUsers">View Users</a></li>
		
	</ul>

	<!-- Add your content below -->
	<div style="padding:50px">
	<%
		UserSession userSession = (UserSession)session.getAttribute("userSession");	
	%>
      
      <h1>Welcome Admin..... <%=userSession.getUsername()%> </h1>
      
      
    </div>

</body>
</html>