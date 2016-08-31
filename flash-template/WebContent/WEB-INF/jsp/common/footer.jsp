<%@page import="com.citizant.kudos.common.SystemConfig"%>
<div style="width:100%;display:inline-block;float:right;position:absolute;bottom:5px;font-size:10px;color:#000055;">
	AWS Region : <%=SystemConfig.getInstance().getAWSRegion().getName() %> 
	<span style="width:100px;">&nbsp;&nbsp;&nbsp;</span>
	Environment : <%=SystemConfig.getInstance().getEnv() %>
</div>