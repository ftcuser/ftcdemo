<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="com.citizant.kudos.common.SystemConfig"%>

<div id="divContainerId" class="container" style="margin-top:10px;width:80%;">

	<div id="divPanelId" class="panel panel-default">
		<div id="divPanelHeadingId" class="panel-heading">
			<h3 class="panel-title">Database Admin </h3>		
		</div>
		<div id="divPanelBodyId" class="panel-body">
			<button id="btnSubmit" class="btn btn-large btn-primary" type="button"  id="submit_id" onclick="cleardb();" value="Clear DB">Clear DB</button>
			<button id="btnClose" class="btn btn-large btn-primary" type="button" id="cancel_id" onclick="populate();">Populate DB</button>	
		</div>
	</div>
	
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Kudos</h3>
		</div>
		<div class="panel-body">
			
			<table id="receivedTable">
				<thead>
					<tr>
						<th>From</th>
						<th>To</th>
						<th>Message</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="kudo" items="${kudos}">
					<tr>
						<td>${kudo.fromEMail}</td>
						<td>${kudo.toEmail}</td>
						<td>${kudo.message}</td>
						<td>${kudo.sentDate}</td>					
					</tr>
 					</c:forEach>
				
				</tbody>
			</table>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Users</h3>
		</div>
		<div class="panel-body">
			
			<table id="sentTable">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" items="${users}">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
						</tr>
 					</c:forEach>
				
				</tbody>
			</table>
		</div>
	</div>

</div>

<script>

function cleardb(){
	document.location = "${pageContext.request.contextPath}/servlet/admin/clear";
}

function populate(){
	document.location = "${pageContext.request.contextPath}/servlet/admin/populate";
}
$(document).ready(function() {
	if($("#receivedTable")!=null) {
		$("#receivedTable").dataTable( { 
			"bJQueryUI" : true,
			"bAutoWidth" : true,
			"aaSorting":[[0, "asc"]],
			"iDisplayLength" : 10,	
			"oLanguage": {"sSearch": "Filter: "} 
		});	
	}
	
	if($("#sentTable")!=null) {
		$("#sentTable").dataTable( { 
			"bJQueryUI" : true,
			"bAutoWidth" : true,
			"aaSorting":[[0, "asc"]],
			"iDisplayLength" : 10,	
			"oLanguage": {"sSearch": "Filter: "} 
		});	
	}
	
	
});
</script>
