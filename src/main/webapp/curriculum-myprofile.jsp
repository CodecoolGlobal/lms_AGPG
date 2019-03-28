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
          <a href="showname">My profile</a>
          <a href="index.jsp">Mentor</a>
          <a href="#">Modify assignments</a>
          <a href="view">Mentor View Asgn.</a>
          <a href="#">Student View Asgn.</a>
          <a href="#">View page</a>
          <a href="userlist">List users</a>
        </div>
        <br>
        <h1>My Profile</h1>
      <form class="modify" method="post" action="showname">
        <input type="text" placeholder="Full name" id="username" name="fullname" pattern="[A-Za-z ]{0,32}">
        <input type="password" placeholder="Password" id="password" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
        <input type="radio" name="position" value="mentor" id="radio2">
        <label for="mentor" name=rbutton>Mentor</label>
        <input type="radio" name="position" value="student" id="radio1">
        <label for="student" name=rbutton>Student</label>
        <a href="login.html"><input type="submit" value="Submit"></a>
        <h3>Logged user name:</h3>
      </form>

       <%! LoggedInUser usr = new LoggedInUser();  %>

       <h2><% out.print(usr.getLoggedInUserName()); %></h2>

    </body>
</html>
<style media="screen">

.navbar {
  width: 100%;
  overflow: auto;
}

.navbar a {
  float: left;
  padding: 12px;
  color: white;
  text-decoration: none;
  width: auto;
  font-size: 17px;
}

.navbar a:hover {
  background-color: #1a8cff;
}

@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
  }
}
</style>
