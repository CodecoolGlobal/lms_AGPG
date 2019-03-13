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
<table width="59%" border="1">
    <tbody>
    <%! Users usr = new Users();  %>
    <% for (User u : usr.getUsers()) { %>
    <tr>
        <th><% out.print(u.getfName()); %> </th>
        <th><% out.print(u.getEmail()); %> </th>
        <th><% out.print(String.valueOf(u.isMentor())); }%> </th>
    </tr>
    </tbody>
</table>
      <a href="curriculum.jsp">Back to menu</a>
</body>
