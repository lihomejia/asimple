<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
	    JGAP.on(window, 'load', function() {
	    	validator.regist({id : "", name : ""}, "notnull");
	    	validator.bindForm("form1");
	    });
    </script>
</head>
<body>
	<form id="form1" method="post">
		<input type="hidden" name="id" value="${data.id }"/>
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">{TITLE}</span></td>
						</tr>
						<tr>
							<td>
								<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
										<td class=forumrow><div align="right">输入框:</div></td>
										<td class=forumrow>
											<input type="text" name="code" value="${data.code }"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow><div align="right">日期框:</div></td>
										<td class=forumrow>
											<input type="text" name="date" value="${data.__disp.date}" class="Wdate" onClick="WdatePicker()"/>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>
											<c:if test="${_action == 'add'}">
										      	<input type="button" value="确&nbsp;认" class="btnStyle" onclick="subform('save');"/>
												<input type="reset" class="btnStyle" value="清&nbsp;空"/>
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="button" class="btnStyle" value="保&nbsp;存" onclick="subform('update');"/>
								      		</c:if>
								      		<c:if test="${_action == 'edit' || _action == 'disp'}">
								      			<input type="button" class="btnStyle" value="返&nbsp;回" onclick="JGAP.goBack();"/>
								      		</c:if>
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