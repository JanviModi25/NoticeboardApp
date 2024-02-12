<!DOCTYPE html>
<%@ page import="neu.edu.Models.NotesEntity" %> 
<html>
<head>
<link rel="stylesheet" href="css/styles.css" >
<style type="text/css">
 /* Add your registration form styling here */
    .login-form {
        background-color: #f2f2f2;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px 0px #ccc;
        margin: 50px auto;
        width: 500px;
      }

      .form-control {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        margin-top: 6px;
        margin-bottom: 16px;
        resize: vertical;
      }
      
      .error {
        color: red;
        font-weight: bold;
        text-align: center;
        padding: 10px;
      }

      input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }

      input[type=submit]:hover {
        background-color: #45a049;
      }
</style>
</head>
<body style="background: #577a74;">

	<ul>
		<li class="logo" style="
    color: white;
">N o t i c e B o a r d</li>
   
		

		<!--<li><a href="dashboard">Home</a></li>-->
		<!-- <li><a href="registration">Register</a></li>-->
	</ul>

	<!-- Add your registration form below -->
   <div class="login-form">
      <h2>Add Notice</h2>
      <%
      
      	if(request.getAttribute("errorMsg")!= null){
      		%>
      		
      <p class="error"><%=request.getAttribute("errorMsg")%></p>
      		
      		<% 
      	}
      %>
      <% NotesEntity note = (NotesEntity)request.getAttribute("Notes"); 
      
      %>
     
      
      <form action="addnotes1" method="post">
      <%if(note != null){%>
        <label for="Title">Title</label>
        <input type="text" id="Title" name="Title" class="form-control" required><%=note.NoteTitle %> </input>

        <label for="NoticeBody">Notice Body</label>
        <input type="text" id="NoticeBody" name="NoticeBody" class="form-control" required><%=note.NoticeBody %></input>

        <input type="submit" value="Submit">
        <%}
      else{%>
    	  <label for="Title">Title</label>
        <input type="text" id="Title" name="Title" class="form-control" required> </input>

        <label for="NoticeBody">Notice Body</label>
        <input type="text" id="NoticeBody" name="NoticeBody" class="form-control" required></input>

        <input type="submit" value="Submit">
    	  
      <%}%>
      </form>
    </div>

</body>
</html>
