<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="com.citizant.kudos.common.SystemConfig"%>


<div id="loginContainer">

  <div id="divPanelId" class="panel panel-default">
	<div id="divPanelHeadingId" class="panel-heading">
		<h3 class="panel-title">
		Login<br/>
		<font color="red">${msg}</font>
		</h3>
	</div>
	<div id="divPanelBodyId" class="panel-body">
	  <div id="divInputPanelId">

		<form id="frmKudosId" class="form-horizontal" action="${pageContext.request.contextPath}/servlet/home/doLogin" method="post">
		  <div class="form-group">
		    <label for="email_id" class="col-sm-4 control-label">Email</label>
		    <div class="col-sm-8">
		      <input class="form-control" type="text" id="email_id" name="email"  />
		    </div>
		  </div>
		  <div class="form-group">
		   	<label for="password_id" class="col-sm-4 control-label">Password</label>
		    <div class="col-sm-8">
		      <input class="form-control" type="password" id="password_id" name="password"  />
		    </div>
		  </div>
		  <div class="form-group">
	    	<div id="divButtonPanelId" class="text-center">
		      <button id="btnSubmit" class="btn btn-large btn-primary" type="submit" value="Login">Login</button>
		    </div>
		  </div>
		</form>

<!-- 		<p class="text-center">New User? Register <a href="${pageContext.request.contextPath}/servlet/home/startCreateUser">Here</a></p> -->
	</div>
    </div>
  </div>

</div>

<script>

function closePage(){
	document.location = "${pageContext.request.contextPath}/servlet/home/start";
}
</script>
