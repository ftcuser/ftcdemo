<%@ page language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div style="width:100%;background-color:#0000aa">
	<div  style="display: inline-block;">
 		<img src="${pageContext.request.contextPath}/images/dhs.png" width="100px" height="100px"> 
 	</div>
 	<div style="display: inline-block;bottom:0px;font-size:30px;color:#ffffff;font: italic bold Georgia, serif;">&nbsp;&nbsp;FLASH</div>
	 <div style="display:inline-block;float:right;bottom:0px;font-size:16px;color:#ffffff;valign:bottom;">
		<ul class="nav nav-pills">
  			<li role="presentation"><a href="${pageContext.request.contextPath}/servlet/home/start">Home</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/servlet/kudosReport/display">Kudos Report</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/servlet/home/logout">Logout</a></li>
  		</ul>
	 </div>
</div>
