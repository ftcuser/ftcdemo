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

<h2>Give Kudo to: <strong>${user.firstName} ${user.lastName}</strong></h2>
<span class="text-danger">${msg}</span>

<hr/>

<div class="row">
  <div class="col-md-6 col-md-offset-3">
    <div id="divPanelId" class="panel panel-default">
    	<div id="divPanelHeadingId" class="panel-heading">
    		<h3 class="panel-title">
    		  Select/Enter Kudo Details
    		</h3>
    	</div>
    	<div id="divPanelBodyId" class="panel-body">
    		<form id="userform" class="form-horizontal" action="${pageContext.request.contextPath}/servlet/kudo/create" method="post">
      		<input type="hidden" name="kudoto" id="kudoto" value="${user.email}"/>
      		<div class="form-group">
    		    <label for="category" class="col-sm-3 control-label">Category</label>
    		    <div class="col-sm-9">
    		      <select name="category" id="category" class="form-control">
    		      	<option value="Teamwork">Teamwork</option>
    		      	<option value="Improvement">Improvement</option>
    		      	<option value="Delivery">Delivery</option>
    		      	<option value="Experiment">Experiment</option>
    		      </select>
    		    </div>
    		  </div>
      		<div class="form-group">
    		    <label for="comment" class="col-sm-3 control-label">Comments</label>
    		    <div class="col-sm-9">
    		      <textarea class="form-control" type="text" id="comment" name="comment"></textarea>
    		    </div>
    		  </div>

          <hr/>

    			<div id="divButtonPanelId" class="text-right">
    				<button id="btnSubmit" class="btn btn-primary" type="submit" value="Give Kudo">Give Kudo</button>
    				<button id="btnClose" class="btn btn-default" type="button"  onclick="closePage();">Cancel</button>
    			</div>
    		</form>
    	</div>
    </div>
  </div>
</div>

<script>
	function closePage(){
		document.location = "${pageContext.request.contextPath}/servlet/home/start";
	}
</script>
