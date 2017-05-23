<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- title of the Page--%>
        <title>Beauty Tips</title>
        <%-- importing CSS stylesheet --%>
        <link rel="stylesheet" href="styles/main.css">
        <script src="scripts/script.js" type="text/javascript"></script>
    </head>
    <body>
        <%-- Code to specify Header section of the page--%>
        <div id="header" class="headerbg">
            <nav id="header_menu">
                <ul  class="left" >
                    <li><a href="UserController?action=home"><em>"The Girlz Korner-Enjoy the Journey"</em></a></li>
                </ul>
                <ul class="right">
                    <c:if test="${sessionScope.theUser == null && sessionScope.theAdmin == null }">
                        <li><a href="login.jsp">Login</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theAdmin.type == 'Admin'}">
                        <li>${sessionScope.theAdmin.name} </li>
                        <li><a href="UserController?action=logout">Logout</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theUser.name != null}">
                        <li>${sessionScope.theUser.name}</li>
                        <li><a href="UserController?action=logout">Logout</a></li>
                        </c:if>
                </ul>

            </nav>
        </div>

