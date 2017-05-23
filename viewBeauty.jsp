<%-- 
    Document   : viewBeauty
    Created on : May 2, 2017, 12:46:45 AM
    Author     : Aditi
--%>

<%@include file="header.jsp" %>

<a href="UserController?action=main">&laquo;Back to the Main Page</a>
<div class="container">
    <div class="row">
    <img src="${requestScope.Beauty.urlToImage}" style="max-width:300px;max-height:200px;"></div>
    <div class="row">
        <h1>${requestScope.Beauty.title}</h1></div>
    <div class="row">    
        <h4>${requestScope.Beauty.description}</h4></div>
    <div class="row">
        <a href="${requestScope.Beauty.url}">View Full Article</a></div>
    
</div>

<%@include file="footer.jsp" %>
