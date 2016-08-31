<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="com.citizant.kudos.common.AppConstants"%>
<%@page import="com.citizant.kudos.bean.UserBean"%>
<%
	UserBean userBean = (UserBean)session.getAttribute(AppConstants.LOGIN_USER);
%>

<h2>Kudos</h2>

<hr/>

<table id="receivedTable" class="table table-striped table-bordered" width="100%">
	<thead>
		<tr>
			<th>Email</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.email}</td>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>

			<td class="text-center">
  		  <a href="#" class="btn btn-sm btn-primary" onclick="javascript:giveKudo('${user.email}');"><i class="glyphicon glyphicon-star-empty"></i> Give Kudos</a>
		  </td>						
		</tr>
    </c:forEach>
	</tbody>
</table>

<script>

function giveKudo(email) {
	document.location = "${pageContext.request.contextPath}/servlet/kudo/start?email=" + email;
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