<%@ page language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.citizant.kudos.common.SystemConfig"%>
<%@page import="com.citizant.kudos.common.AppConstants"%>
<%@page import="com.citizant.kudos.bean.UserBean"%>
<%
  UserBean userBean = (UserBean)session.getAttribute(AppConstants.LOGIN_USER);
%>

<div class="page-header">
  <div class="container-fluid">
    <div id="user-first-region">
      <div>
        <div>
          <div class="block boxes-dhs_header_tagline" data-bid="boxes-dhs_header_tagline">
            <div id="boxes-box-dhs_header_tagline" class="boxes-box">
              <div class="boxes-box-content">
                <p>
                  <img alt="US flag signifying that this is a United States Federal Government website"
                       src="${pageContext.request.contextPath}/images/icn-us-flag-21px.png"
                       width="21px" height="13px">
                   Department of Homeland Security</p>
            </div>
          </div>
        </div> <!-- /block -->
          <div class="block menu-menu-utility" data-bid="menu-menu-utility">
            <ul class="menu clearfix">
              <li class="first leaf contact-us mid-623"><a href="https://www.dhs.gov/contact-us" title="Contact Us">Contact Us</a></li>
              <li class="leaf quick-links mid-11505"><a href="https://www.dhs.gov/frequently-requested-pages" title="Quick Links">Quick Links</a></li>
              <li class="leaf site-map mid-11111"><a href="https://www.dhs.gov/sitemap" title="Site Map">Site Map</a></li>
              <li class="last leaf a-z-index mid-2272"><a href="https://www.dhs.gov/dhsgov-z-index" title="A-Z Index">A-Z Index</a></li>
            </ul>
          </div> <!-- /block -->
        </div>
      </div>
    </div>

    <div id="branding" class="clearfix">
      <ul id="systemInfo" class="list-inline small">
        <li>AWS Region : <%=SystemConfig.getInstance().getAWSRegion().getName() %></li>
        <li>Environment : <%=SystemConfig.getInstance().getEnv() %></li>
      </ul>

      <div id="logo" class="pull-left"><img alt="DHS logo" src="${pageContext.request.contextPath}/images/dhs.png" width="100px" height="100px"></div>
      <h1 class="pull-left">FLASH</h1>
    </div>
  </div>
</div>

<%if(userBean != null) { %>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="#">Give Kudos <span class="sr-only">(current)</span></a></li>
      <li><a href="${pageContext.request.contextPath}/servlet/user/startCreate">Add a User</a></li>
    </ul>

    <p class="navbar-text navbar-right">Signed in as <%=userBean.getEmail() %> <a class="navbar-link" href="javascript:confirmLogout();">(Logout)</a></p>
  </div>
</nav>
<%} %>

<script>

function confirmLogout() {
  if (confirm('Are you sure you want to logout?')) {
    document.location = "${pageContext.request.contextPath}/servlet/home/logout";
  }
}

</script>
