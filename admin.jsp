<%-- 
    Document   : admin
    Author     : Aditi Goel
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<div class="page-container">
  
	<!-- top navbar -->
    
      
    <div class="container">
      <div class="row row-offcanvas row-offcanvas-left">
        
        <!-- sidebar -->
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
            <ul class="nav borderme">
              <li class="active"><a href="admin.jsp">Home</a></li>
              <li><a href="BeautyController?action=PostedBeauty">Posted Beauty tips</a></li>
              <c:if test="${sessionScope.theUser == null && sessionScope.theAdmin == null }">
                        <li><a href="UserController?action=about">About Beauty Creator</a></li>
                        <li><a href="UserController?action=how">User Guide</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theAdmin.type == 'Admin'}">
                        <li><a href="UserController?action=about">About Beauty Creator</a></li>
                        <li><a href="UserController?action=how">User Guide</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theUser.name != null}">
                        <li><a href="aboutl.jsp?user=${sessionScope.theUser.name}">About Beauty Creator</a></li>
                        <li><a href="main.jsp?user=${sessionScope.theUser.name}">User Guide</a></li>
                        </c:if>
            </ul>
        </div>
  	
        <!-- main area -->
        <div class="col-xs-12 col-sm-9">
          <h1>We've some exciting tips from registered Beauticians</h1>
           <%-- Img tag is used to import image --%>
            <img src="images/SkinnHair.jpg" alt="admin"/>
          
        </div><!-- /.col-xs-12 main -->
    </div><!--/.row-->
  </div><!--/.container-->
</div>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>