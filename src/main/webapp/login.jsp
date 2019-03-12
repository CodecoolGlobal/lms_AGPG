<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.Greeting" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Greeting</title>
</head>
<body>
<section class="container">
    <div class="login">
      <h1>Login to Web App</h1>
      <form method="post" action="login">
        <p><input type="email" name="email" value="" placeholder="Email" required></p>
        <p><input type="password" name="psw" value="" placeholder="Password" required></p>
        <a href="registration.jsp"><p class="submit"><input type="button" value="Register"></p></a>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
      </form>
    </div>

    <div class="login-help">
      <p>Forgot your password? <a href="forgotten-password.jsp">Click here to reset it</a>.</p>
    </div>
  </section>
</body>
</html>
