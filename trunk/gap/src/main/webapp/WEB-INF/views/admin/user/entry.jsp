<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
		JGAP.on(window, 'load', function() {
	    	validator.regist({id : "userId", name : "用户ID"}, "notnull");
	    	validator.regist({id : "userName", name : "用户名"}, "notnull");
	    	validator.regist({id : "passWord", name : "密码"}, "notnull");
	    	validator.bindForm("form1");
	   	});
    </script>
</head>
<body>
	<form id="form1" method="post">
		<input type="hidden" name="id" value="${data.id}"/>
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">用户维护</span></td>
						</tr>
						<tr>
							<td>
								<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
										<td class=forumrow style="30%"><div align="right">用户ID:</div></td>
										<td class=forumrow>
											<input type="text" id="userId" name="userId" value="${data.userId }"/><font class=required>*</font>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="70%"><div align="right">用户名:</div></td>
										<td class=forumrow>
											<input type="text" id="userName" name="userName" value="${data.userName }"/><font class=required>*</font>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="70%"><div align="right">密码:</div></td>
										<td class=forumrow>
											<input type="text" id="passWord" name="passWord" value="${data.passWord }"/><font class=required>*</font>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>
											<c:if test="${_action == 'add'}">
										      	<input type="button" class="btnStyle" value="确&nbsp;认" onclick="subform('save');"/>
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="button" class="btnStyle" value="保&nbsp;存" onclick="subform('update');"/> 
								      		</c:if>
								      		<input type="button" class="btnStyle" value="返&nbsp;回" onclick="JGAP.goBack();"/>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
		</table>
	</form>
</body>
</html>