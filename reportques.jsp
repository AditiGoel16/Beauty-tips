<%-- 
    Document   : main
    Author     : Aditi Goel
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<h3><span id="studies">Reported Questions</span></h3>
<%-- Code to go back to Main page  --%>
<br>
<%-- Code to Display Reported Questions--%>
<section class="participate">
    <a href="admin.jsp?user=Admin" id="back_to_page">&laquo;Back to the Main Page</a>
    <table>
        <%--Column Names --%>
        <tr>
            <th>Question</th>
            <th>Action</th>		
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="study" items="${study}">
            <tr>
                <td>${study.question}</td>
                <td><form action="StudyController?action=approve&AMP;StudyCode=${study.studyCode}" method="post" class="loginAdmin_form">
                        <input type="submit" class="participate_button" value="Approve" /></form>
                    <form action="StudyController?action=disapprove&AMP;StudyCode=${study.studyCode}" method="post" class="loginAdmin_form">
                        <input type="submit" class="participate_button" value="Disapprove" /></form></td>                                                
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
        </tr>
    </table>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>