<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="com.citizant.kudos.common.AppConstants"%>
<%@page import="com.citizant.kudos.bean.UserBean"%>
<%
	UserBean userBean = (UserBean)session.getAttribute(AppConstants.LOGIN_USER);
%>

<h2>Home</h2>

<hr/>

<div class="row">
  <div class="col-sm-6">
    <div id="tasksPanel" class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">Tasks Panel</h3>
      </div>
      <div class="panel-body">
        <div class="list-group">
<!--           <a href="#" class="list-group-item"></a> -->
        </div>
      </div>
    </div>
  </div>
</div>