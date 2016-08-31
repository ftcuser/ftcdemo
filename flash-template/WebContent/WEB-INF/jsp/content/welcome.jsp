<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="com.citizant.kudos.common.AppConstants"%>
<%@page import="com.citizant.kudos.bean.UserBean"%>
<%
	UserBean userBean = (UserBean)session.getAttribute(AppConstants.LOGIN_USER);
%>

<h1>FLASH HOME</h1>

<div id="divPanelId" class="panel panel-default">
	<div id="divPanelHeadingId" class="panel-heading">
		<h3 class="panel-title"> </h3>
	</div>
	<div id="divPanelBodyId" class="panel-body">
		
			Welcome
		
	</div>
</div>