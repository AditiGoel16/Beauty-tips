    <%-- 
    Document   : Beautyapproval
    Created on : May 1, 2017, 2:47:34 AM
    Author     : Aditi
--%>
<%@ include file="header.jsp" %>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to display studies details --%> 
<%-- Clicking on Start, Stop to Participate in that Beauty and  Edit button to display edit page and edit Beauty details in it--%>

<div class="container">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Beauty Title</th>
                <th>Beauty Code</th>
                <th>Approve/Reject</th>
                <th>View Beauty</th>
            </tr>
        </thead>
        <tbody>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="Beauty" items="${BeautyList}">
            <tr>
                <td>${Beauty.title}</td>
                <td>${Beauty.tipsCode}</td>
                <td><form class="inline" action="BeautyController?action=approve&tipsCode=${Beauty.tipsCode}" method="post">
                        <button type="submit">Approve</button></form>
                <form class="inline" action="BeautyController?action=disapprove&tipsCode=${Beauty.tipsCode}" method="post">
                    <button  type="submit">Reject</button></form></td>
                <td><a href="BeautyController?action=viewBeauty&tipsCode=${Beauty.tipsCode}" >View</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
        <%@ include file="footer.jsp" %>