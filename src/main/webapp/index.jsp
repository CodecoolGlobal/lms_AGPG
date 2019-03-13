<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="login.css">
  </head>
  <body>
    <h1>My First Heading</h1>
    <div align="center">
    <%! LoggedInUser usr = new LoggedInUser();  %>
    <% out.print( usr.getEmailAddress());  %>
  </div>

  </body>
</html>
