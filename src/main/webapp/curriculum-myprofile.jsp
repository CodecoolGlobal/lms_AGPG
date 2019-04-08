<%@ page import="com.codecool.web.model.LoggedInUser" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta charset="UTF-8">
        <title>My Profile</title>
    </head>
    <body>
        <div class="navbar">
            <a href="myprofile">My profile</a>
            <a href="index.jsp">Mentor</a>
            <a href="#">Modify assignments</a>
            <a href="view">View Asgn.</a>
            <a href="userlist">List users</a>
            <a href="login">Logout</a>
        </div>
        <br>
        <h1>Logged in with: ${email} </h1>
        <h1>My Profile</h1>
      <form class="modify" method="post" action="myprofile">
            <input type="text" name="email" placeholder="${email}" readonly>
            <input type="text" placeholder="Type new name here" id="username" name="fullname" pattern="[A-Za-z ]{0,32}">
            <input type="radio" name="position" value="mentor" id="radio2">
            <label for="mentor" name=rbutton>Mentor</label>
            <input type="radio" name="position" value="student" id="radio1">
            <label for="student" name=rbutton>Student</label>
            <input type="submit" value="Update"></a>
      </form>
    </body>
</html>
