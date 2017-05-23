<%-- 
    Document   : main
    Author     : Aditi Goel
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Code to go back to Main page  --%>
<br>
<a href="admin.jsp?user=Admin" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section tag is used to display Question Removed or not removed messages --%>
<section id="confirmc">
    <c:if test="${param.question == null}">
        <h3>Question Removed. . .</h3>
    </c:if>
    <c:if test="${param.question != null}">
        <h3>Question Not Removed. . .</h3>
    </c:if>
</section>

<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>