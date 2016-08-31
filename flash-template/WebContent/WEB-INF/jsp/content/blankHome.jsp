<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="com.citizant.kudos.common.AppConstants"%>
<%@page import="com.citizant.kudos.bean.UserBean"%>
<%
	UserBean userBean = (UserBean)session.getAttribute(AppConstants.LOGIN_USER);
%>

<div class="alert alert-success" role="alert">${msg}</div>

<div class="clearfix">
  <h2 class="pull-left">Kudos</h2>
  <button type="button" class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target="#helpModal"><i class="glyphicon glyphicon-question-sign"></i> Help</button>
</div>

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
			<c:choose>
  			<c:when test="${user.kudoReceived}">
    		  <i class="glyphicon glyphicon-star"></i> Kudo Received!
    		</c:when>
  			<c:otherwise>
    			<a href="#" id="${user.email}" class="btn btn-sm btn-primary" onclick="javascript:giveKudo('${user.email}');"><i class="glyphicon glyphicon-star-empty"></i> Give Kudos</a>
  			</c:otherwise>
			</c:choose>
		  </td>						
		</tr>
    </c:forEach>
	</tbody>
</table>


<div id="helpModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">How to Give Kudos</h4>
      </div>
      <div class="modal-body">
        <ol>
          <li>On (this) Kudos page, find the person you would like to give kudos to.</li>
          <li>Use the <a class="btn btn-primary btn-sm" disabled><i class="glyphicon glyphicon-star-empty"></i> Give Kudos</a> button to initiate kudos.</li>
          <li>On the next page, fill in the category and optional comment and attachment fields.</li>
          <li>Send the kudos by clicking the <a class="btn btn-primary btn-sm" disabled>Give Kudo</a> button.</li>
        </ol> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



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