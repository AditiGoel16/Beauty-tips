<%-- 
    Document   : main
    Created on : may 19, 2017, 9:17:56 PM
    Author     : Aditi
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<div class="container">
      <div class="row row-offcanvas row-offcanvas-left">
        
        <!-- sidebar -->
        <div class="col-xs-8 col-sm-4 sidebar-offcanvas" id="sidebar" role="navigation">
            <ul class="nav borderme">
          
              <li><a href="UserController?action=main">Home</a></li>
               <li><a href="CreateBeauty.jsp">Post Beauty Tips</a></li>
              <li><a href="BeautyController?action=myBeauty">My Beauty Tips posted</a></li>
              <c:if test="${sessionScope.theUser == null && sessionScope.theAdmin == null }">
                        <li><a href="about.jsp">About Beauty Tips</a></li>
                        <li><a href="how.jsp">User Guide</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theAdmin.type == 'Admin'}">
                        <li><a href="UserController?action=about">About Beauty Creator</a></li>
                        <li><a href="how.jsp">User Guide</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theUser.name != null}">
                        <li><a href="about.jsp">About Beauty Tips Website</a></li>
                        <li><a href="how.jsp">User Guide</a></li>
                        </c:if>
            </ul>
        </div>
  	
        <!-- main area -->
        <div class="col-xs-12 col-sm-6  ">
          <h1>We are awaiting your useful tips</h1>
          <%-- Img tag is used to import image --%>
            <img src="images/userpage.jpg" alt="main"/>
          
        </div><!-- /.col-xs-12 main -->
    </div><!--/.row-->
  </div>
<%-- Section tag is used to write description  --%>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>