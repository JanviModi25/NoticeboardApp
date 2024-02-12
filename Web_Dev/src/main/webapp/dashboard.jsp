<%@page import="neu.edu.data.UserSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="neu.edu.Models.NotesEntity" %> 
<%@ page import="neu.edu.Models.ReplyNotesEntity" %> 


<%@ page import="java.util.Date" %>
<%
  Date date = new Date();
%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="css/styles.css" > 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
   <style>
         .bold-box {
        padding: 20px;
        border: 10px #00BFFF;
        background-color: #FFFFFF;
        text-align: left;
        box-shadow: 0 0 15px #00BFFF;
        border-radius: 20px;
        margin-bottom: 40px;
      }
      
      /* Define styles for the sentences inside the box */
      .bold-box p {
        font-size: 20px;
        margin: 10px ;
      }
      .bold-box h1 {
        font-size: 26px;
        margin-top: 0;
        margin-bottom: 10px;
      
      }
      
   .submit-button {
        padding: 10px 10px;
        background-color: #0077b6;
        color: #fff;
        font-size: 12px;
        font-weight: bold;
        border: none;
        border-radius: 10px;
        cursor: pointer;
      }
         .reply-button {
        padding: 10px 10px;
        background-color: 	#008000;
        color: #fff;
        font-size: 12px;
        font-weight: bold;
        border: none;
        border-radius: 10px;
        cursor: pointer;
      }
      .delete-button {
        padding: 10px 10px;
        background-color: #ff0000;
        color: #fff;
        font-size: 12px;
        font-weight: bold;
        border: none;
        border-radius: 10px;
        cursor: pointer;
      }
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }
      .bd-mode-toggle {
        z-index: 1500;
      }
      
      .form-control-dark {
  border-color: var(--bs-gray);
}
.form-control-dark:focus {
  border-color: #fff;
  box-shadow: 0 0 0 .25rem rgba(255, 255, 255, .25);
}

.text-small {
  font-size: 85%;
}

.dropdown-toggle:not(:focus) {
  outline: 0;
}
      
    </style>
</head>
<body style="background: #577a74;">
<ul>
		<li class="logo" style="
    color: white;
">N o t i c e B o a r d</li>
     
		

		<li><a href="controller?action=profile">Update Profile</a></li>
		<li><a href="login.jsp">Logout</a></li>
	</ul>
	
 
<div class="row">
  <div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark col-3" style="width:280px;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
      <svg class="bi pe-none me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
      <span class="fs-4"><%
		UserSession userSession = (UserSession)session.getAttribute("userSession");	
	%><% out.append(userSession.getUsername()); %></span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="controller?action=profile" class="nav-link active" aria-current="page">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#home"/></svg>
          Profile
        </a>
      </li>
      <li>
        <a href="addnotes" class="nav-link text-white">
          <svg class="bi pe-none me-2" width="16" height="16" href="addnotes1"><use xlink:href="addnotes"/></svg>
         Add Notes
        </a>
      </li>
      <li>
        <a href="logout" class="nav-link text-white">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="logout"/></svg>
          Logout
        </a>
      </li>
   
    </ul>
    <hr>
    <div class="dropdown">
      <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      NOTICE BOARD
      </a>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
        <li><a class="dropdown-item" href="#">New project...</a></li>
        <li><a class="dropdown-item" href="#">Settings</a></li>
        <li><a class="dropdown-item" href="#">Profile</a></li>
        <li><hr class="dropdown-divider"></li>
        <li><a class="dropdown-item" href="#">Sign out</a></li>
      </ul>
    </div>
  </div>
<div class="col-9">



	<!-- <ul>
		<li class="logo"><img src="logo.png" alt="Logo"></li>
      <li class="center">E-Notice Board</li>
		
		<li><a href="controller?action=profile">Profile</a></li>
		<li><a href="logout">Logout</a></li>
	</ul> -->


            
     
      
      <div class="b-example-divider"></div>

<div class="container">
  <footer class="py-3 my-4">
   
    <h3 class="text-center text-body-secondary">Welcome User..... <% out.append(userSession.getUsername()); %> </h3>
        <h4 class="text-center text-body-secondary">NOTICE BOARD</h4>
    
  </footer>
<%
String Random =(String)request.getAttribute("Random");
List<NotesEntity> listOfNotes = (List<NotesEntity>) request.getAttribute(Random);
if(listOfNotes!=null){
	
    for(NotesEntity notice: listOfNotes){ %> 
   
      <%String x =notice.NoteTitle; %>
            <form action="dashboard" method="post">
       <div class="bold-box">
       <input type="hidden" id="noticetitle" name="noticetitle" value="<%= notice.NoteTitle %>"></input>
      <h1 id = "noticetitle1" name="noticetitle1" style="text-align:center;"><%= notice.NoteTitle %> </h1> 
      <h4><%= notice.NoticeBody %></h4>
      <p>Due Date:<%= date %></p>
      <p>Note Posted by: <%= notice.CreatedBy %>  </p>
      <p style="font-weignt: 900;">List of replies:</p>
      <%for(ReplyNotesEntity replies :notice.listOfReply){ %>
   
      
      <p><small>reply :<%=replies.reply %> --- postedby:<%=replies.CreatedBy %></small></p>
     

      
      <%} %>
      <label for="sentence">If you have any questions,please reply on the note:</label>
        <br>
        <input type="text" id="sentence" name="sentence" size="100">
      <button type="submit" class="submit-button" name="update" id="update">Update note </button>
      <button type="submit" class="delete-button" name ="delete" id ="delete">Delete note </button>
                    <button type="submit" class="reply-button" name="reply" id="reply">Reply note </button>
            
      
      
           </div>
        </form>
        
       <%  }  
    } 
%>
 
     <!--<div class="bold-box">
      <h1>INFO6250 - Web Development </h1> 
      <p>Assignment: POST - REDIRECT - GET , using HTML and Servlets.</p>
      <p>Due Date: 1st May  </p>
      <label for="sentence">If you have any questions, start an email conversation  with your professor from here:</label>
        <br>
        <input type="text" id="sentence" name="sentence" size="100">
      <button type="submit" class="submit-button">Submit</button>
   
    </div>-->
    
   
</div>


    </div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</div>
</body>
</html>