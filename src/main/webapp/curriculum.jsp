<%@ page import="com.codecool.web.model.LoggedInUser" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="curriculum.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <meta charset="UTF-8">
      <title>Curriculum</title>

</head>
<body>
  <%! LoggedInUser usr = new LoggedInUser();  %>
  <header>
    <h1>Curriculum</h1>
  <h2>Welcome <% out.print(usr.getLoggedInUserName()); %>!</h2>
  <br>
  <div class="wrapper animated bounce">
      <div class="options">

      <a href="curriculum-mentor-modify-assignment.html">Mentor Modify</a><br>
      <a href="curriculum-myprofile.jsp" methods="get" action="showname" >My Profile</a><br>
      <a href="userlist">User List</a><br>
      <a href="curriculum-view-assignment.html">View Assignment</a>
      <a href="curriculum-user-list.jsp">User List</a><br>
      <a href="add_assignment.html">View Assignment</a>

    </div>
  </div>
  </header>


</body>
</html>
