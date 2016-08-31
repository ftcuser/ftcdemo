<%@ page language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="com.citizant.kudos.util.StringUtil"%>
<%@page import="com.citizant.kudos.common.AppConstants"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Flash</title>
	<!-- Bootstrap core CSS -->

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dataTables.bootstrap.min.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.bootstrap.min.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dhs01.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/flash.css"/>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/responsive.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/moment.min.js"></script>


    <script>
    	$.ajaxSetup({
    		cache: false
    	});

    	function appConfirmDialog(message, title, focusElmtIdOnClose, onConfirmFunction, onCancelFunction) {
    		if (title == null) {
    			title = 'Message';
    		}
    		$("<div></div>").appendTo('body').html(
    				'<div tabindex="0" style="text-decoration:none">' + message + '</div>').dialog({
    			draggable : true,
    			show : "blind",
    			modal : true,
    			title : title,
    			zIndex : 10005,
    			resizable : false,
    			buttons : {
    				Ok : function() {
    					$(this).dialog("close");
    					if (onConfirmFunction) {
    						onConfirmFunction();
    					}
    				},
    				Cancel : function() {
    					$(this).dialog("close");
    					if (onCancelFunction) {
    						onCancelFunction();
    					}
    				}
    			},
    			open : function() {

    			},
    			close : function(event, ui) {
    				$(this).remove();
    				if (focusElmtIdOnClose) {
    					var element = $('#' + focusElmtIdOnClose);
    					if (element)
    						element.focus();
    				}
    			}
    		});
    		return;
    	};

    	function validateEmail(email) {
    	    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    	    return re.test(email);
    	}

    </script>
</head>
<body >
	<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}"/>

  <tiles:insertAttribute name="header" />

	<div class="container-fluid">
 		<div id="loadingPopupId" class="loadingPopup" style="display:none">
      <img src="${pageContext.request.contextPath}/images/loading.gif" id="loadingGifId" alt="Loading..." />
    </div>

		<tiles:insertAttribute name="body-content"/>

		<div style="display:none">
  		<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>
