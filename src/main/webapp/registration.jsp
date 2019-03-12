<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.Greeting" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
    <h1>Registration</h1>
        <form action="reg" method = "post">
        Fullname:<br>
        <input type="text" name="fullname" pattern="[A-Za-z ]{1,32}" required>
        <br>
        E-mail adress:<br>
        <input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="simple@example.com" required>
        <br>
        Password:<br>
        <input type="password" id="psw" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
        <br>
        <br><br>
        <input type="radio" name="position" value="student" required>Student<br>
        <input type="radio" name="position" value="mentor" required>Mentor<br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>