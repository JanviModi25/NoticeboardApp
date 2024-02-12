<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css" >
<style type="text/css">
 /* Add your registration form styling here */
      .registration-form {
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
      
		

		<li><a href="login.jsp">Login</a></li>
	</ul>

	<!-- Add your registration form below -->
    <div class="registration-form">
      <h2>Registration Form</h2>
      <form action="Registration" method="post">
        <label for="username">First Name</label>
        <input type="text" id="username" name="username" class="form-control" required>
        
         <label for="lastname">Last Name</label>
        <input type="text" id="lastname" name="lastname" class="form-control" required>
        
         <label for="role">Role</label>
         <select id="role" name="role" class="form-control" required >
         
         <option value="student">student</option>
  <option value="professor">professor</option>

         </select>
        <!-- <input type="text" id="role" name="role" class="form-control" required> -->

        <label for="email">Email</label>
        <input type="email" id="email" name="email" class="form-control" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" required>

        <input type="submit" value="Submit">
      </form>
    </div>

</body>
</html>
