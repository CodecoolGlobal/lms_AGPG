<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="login.css">
  </head>
  <body>
    <h1>My First Heading ${email} </h1>
    <div align="center">

    <form class="userprof" action="profile" method="post">
        <div class="userprof"><a href="userprofile.jsp">List users
        <input type="submit" value="Sign In">
        </a>
        </div>
    </form>
  </div>

  </body>
</html>
