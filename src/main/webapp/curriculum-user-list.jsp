<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.User" %>
<%@ page import="com.codecool.web.model.Users" %>
<%@ page import="java.util.Arrays" %>

<!DOCTYPE html>
 <head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>My Profile</title>
</head>
<body>
<html lang="en">
  <table class="users-list">
      <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Is Mentor</th>
      </tr>
      <%! Users usr = new Users();  %>
      <% for (User u : usr.getUsers()) { %>

      <tr>
          <td><% out.print(u.getfName()); %> </strong></td>
          <td><% out.print(u.getEmail()); %> </td>
          <td><% out.print(String.valueOf(u.isMentor())); }%> </td>
      </tr>
  </table>

      <a href="curriculum.jsp">Back to menu</a>
</body>
