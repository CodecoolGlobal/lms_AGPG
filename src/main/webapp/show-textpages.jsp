<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.TextPage" %>
<%@ page import="java.util.Arrays" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="css-style.css">
        <meta charset="UTF-8">
        <title>View Assignment</title>
    </head>
    <body>
        <div class="navbar">
            <jsp:include page='header-mentor.jsp'>
                <jsp:param name="" value=""/>
            </jsp:include>
        </div>
        <br>
        <h1>Logged in with: ${email} </h1>
        <h1>Text Pages</h1>
        <div class="textpage">

            <table class="list" border="1" border-color="white">
                <tr>
                    <th>Text Title</th>
                    <th>Text Content</th>
                    <th>Date Created</th>
                    <th>Published?</th>

                </tr>
                    <c:forEach var="t" items="${textpages}">
                        <tr>
                        <td>${t.getTitle()}</td>
                        <td>${t.getTextContent()}</td>
                        <td>${t.getDateCreated()}</td>
                        <td>${t.isPublished()}</td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
    </body>
  </html>
