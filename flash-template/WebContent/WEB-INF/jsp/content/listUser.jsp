<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="com.citizant.kudos.common.SystemConfig"%>

<div id="divContainerId" class="container">

	<div class="clearfix">
  	<h2 class="pull-left">Manage Users</h2>
  	<button id="btnSubmit" class="btn btn-lb btn-primary pull-right" type="button"  onclick="javascript:addUser();" value="Add User"><i class="glyphicon glyphicon-plus"></i> Add User</button>
  </div>

  <hr/>

	<table id="receivedTable" class="table table-striped table-bordered" width="100%">
		<thead>
			<tr>
				<th>Email</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Role</th>
				<th>Active</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.email}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.role}</td>	
				<td>${user.active}</td>
				<td><a href="#" onclick="javascript:editUser('${user.email}');">Edit User</a>
				 &nbsp;&nbsp;
				<a href="javascript:deleteUser('${user.email}');">Delete User</a>
				
				</td>						
			</tr>
	      </c:forEach>
		
		</tbody>
	</table>



</div>

<script>

function addUser(){
	document.location = "${pageContext.request.contextPath}/servlet/user/startCreate";
}

function deleteUser(email){
	if(confirm('Do you want to delete this user?')) {
		document.location = "${pageContext.request.contextPath}/servlet/user/delete?email=" + email;
	}
}

function editUser(email){

	
		document.location = "${pageContext.request.contextPath}/servlet/user/edit?email=" + email;
	

}
$(document).ready(function() {
	if($("#receivedTable")!=null) {
		$("#receivedTable").dataTable( {
			"responsive" : true,
			"aaSorting":[[0, "asc"]],
			"iDisplayLength" : 10,
			"oLanguage": {"sSearch": "Filter: "}
		});
	}

});
</script>
