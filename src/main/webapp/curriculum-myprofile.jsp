<%@ page import="com.codecool.web.model.LoggedInUser" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta charset="UTF-8">
        <title>My Profile</title>
    </head>
    <body>
      <form class="modify" method="post" action="showname">
        <input type="text" placeholder="Full name" id="username" name="fullname" pattern="[A-Za-z ]{0,32}">
        <input type="password" placeholder="Password" id="password" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
        <input type="radio" name="position" value="mentor" id="radio2">
        <label for="mentor" name=rbutton>Mentor</label>
        <input type="radio" name="position" value="student" id="radio1">
        <label for="student" name=rbutton>Student</label>
        <a href="login.html"><input type="submit" value="Submit"></a>
      </form>

      <form class="" action="index.html" method="post">

      </form>


       <%! LoggedInUser usr = new LoggedInUser();  %>

       <h2><% out.print(usr.getLoggedInUserName()); %></h2>


      <a href="curriculum.jsp" >Back to menu</a>
    </body>
</html>
