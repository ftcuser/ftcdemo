<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="com.citizant.kudos.common.SystemConfig"%>
<%@page import="com.citizant.kudos.common.AppConstants"%>
<%@page import="com.citizant.kudos.bean.UserBean"%>
<%
	UserBean userBean = (UserBean)session.getAttribute(AppConstants.LOGIN_USER);
%>

<div id="divContainerId" class="container">

  <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div id="divPanelId" class="panel panel-default">
      	<div id="divPanelHeadingId" class="panel-heading">
      		<h3 class="panel-title"> User Registration
      		  <span class="text-danger">${msg}</span>
      		</h3>
      	</div>
      	<div id="divPanelBodyId" class="panel-body">
      		<form id="userform" class="form-horizontal" action="${pageContext.request.contextPath}/servlet/user/doCreate" method="post">
        		<div class="form-group">
      		    <label for="firstName" class="col-sm-5 control-label">First Name</label>
      		    <div class="col-sm-7">
      		      <input class="form-control" type="text" id="firstName" name="firstName" value="${user.firstName}" />
      		    </div>
      		  </div>
        		<div class="form-group">
      		    <label for="lastName" class="col-sm-5 control-label">Last Name</label>
      		    <div class="col-sm-7">
      		      <input class="form-control" type="text" id="lastName" name="lastName"   value="${user.lastName}"/>
      		    </div>
      		  </div>
        		<div class="form-group">
      		    <label for="email" class="col-sm-5 control-label">Email</label>
      		    <div class="col-sm-7">
      		      <input class="form-control" type="text" id="email" name="email"  value="${user.email}" />
      		    </div>
      		  </div>
            <hr/>
            
      			<div id="divButtonPanelId" class="text-center">
      				<button id="btnSubmit" class="btn btn-primary" type="button" value="Give a Point" onclick="createUser();">Add User</button>
      				<button id="btnClose" class="btn btn-default" type="button"  onclick="closePage();">Cancel</button>
      			</div>
      		</form>
      	</div>
      </div>
    </div>
  </div>
</div>

<script>
	function createUser(){
		var form = document.getElementById("userform");
		form.submit();
	}

	function closePage(){
		document.location = "${pageContext.request.contextPath}/servlet/home/start";
	}
</script>

<%
	UserBean editedUser = (UserBean)request.getAttribute("user");
	if (editedUser != null) {
		String userRole = editedUser.getRole();
%>
<script>
var userrole = '<%= userRole %>';
document.getElementById('role').value = userrole;
</script>
<% } %>