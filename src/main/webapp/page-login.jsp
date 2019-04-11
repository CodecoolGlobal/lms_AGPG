<%@ page import="java.util.*" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <title>Log-In</title>
</head>
<body>
  <div class="wrapper animated bounce">
    <h1>Codecool LMS Login Form</h1>
    <hr>
    <form class="login" method="post" action="login">
      <label id="icon" for="username"><i class="fa fa-user"></i></label>
      <input type="text" placeholder="Email address" id="username" name="email" required>
      <label id="icon" for="password"><i class="fa fa-key"></i></label>
      <input type="password" placeholder="Password" id="password" name="psw" required>
      <input class="login "type="submit" value="Sign In">
    </form>
    <hr>
    <form class="createacc" action="page-registration.html" method="get">
        <div class="crtacc"><a href="page-registration.html">Create Account</a></div>
    </form>

  </div>
</body>
</html>
