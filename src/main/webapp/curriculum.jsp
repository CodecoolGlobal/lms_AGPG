<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">

</head>
<body>

      <br>
      <title>Curriculum</title>
      <h1 class="header">Curriculum</h1>
      <h2>Welcome ${name}</h2>

      <div id="mySidepanel" class="sidepanel">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="curriculum-mentor-modify-assignment.html">Mentor Modify</a>
        <a href="curriculum-myprofile.jsp" methods="get" action="showname" >My Profile</a>
        <a href="curriculum-user-list.jsp">User List</a>
        <a href="curriculum-view-assignment.html">View Assignment</a>
      </div>

    <button class="openbtn" onclick="openNav()">&#9776; </button>

    <script>
        /* Set the width of the sidebar to 250px (show it) */
        function openNav() {
        document.getElementById("mySidepanel").style.width = "250px";
        }

        /* Set the width of the sidebar to 0 (hide it) */
        function closeNav() {
        document.getElementById("mySidepanel").style.width = "0";
        }
    </script>


</body>
</html>
