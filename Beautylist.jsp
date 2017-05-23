<%-- 
    Document   : main
    Created on : Sep 19, 2015, 9:17:56 PM
    Author     : Suman
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<br>
<%-- Code to go Back to the Main Page  --%>
<a href="UserController?action=main">&laquo;Back to the Main Page</a>
<%-- Section to display studies details --%> 
<%-- Clicking on Start, Stop to Participate in that Beauty and  Edit button to display edit page and edit Beauty details in it--%>
<br>
<br>
<br>
<div class="container">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Beauty Tips Title</th>
                <th>Beauty Tips Code</th>
                <th>Beauty Tips Status</th>
                <th>View Beauty Tips</th>
            </tr>
        </thead>
        <tbody>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="Beauty" items="${BeautyList}">
            <tr>
                <td>${Beauty.title}</td>
                <td>${Beauty.tipsCode}</td>
                <td>${Beauty.tipstatus}</td>
                <td><a href="BeautyController?action=viewBeauty&tipsCode=${Beauty.tipsCode}" >View</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>