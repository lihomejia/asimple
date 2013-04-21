<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
   		window.savepath = "<c:url value='/cell/save.html'/>";
    	window.updatepath = "<c:url value='/cell/update.html'/>";
		JGAP.on(window, 'load', function() {
	    	validator.regist({id : "code", name : "单元代码"}, "notnull");
	    	validator.regist({id : "location", name : "单元位置"}, "notnull");
	    	validator.regist({id : "area", name : "单元面积"}, "notnull", "number");
	    	validator.regist({id : "builddate", name : "建档时间"}, "date");
	    	validator.bindForm("form1");
	   	});
    </script>
</head>
<body>
	<form id="form1" method="post" action="<c:url value='/cell/save.html'/>">
		<input type="hidden" name="id" value="${data.id }"/>
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">生产单元维护</span></td>
						</tr>
						<tr>
							<td>
								<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
										<td class=forumrow style="30%"><div align="right">单元代码:</div></td>
										<td class=forumrow>
											<input type="text" id="code" name="code" value="${data.code }"/><font class=required>*</font>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="70%"><div align="right">单元位置:</div></td>
										<td class=forumrow>
											<input type="text" id="location" name="location" value="${data.location }"/><font class=required>*</font>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="70%"><div align="right">单元面积:</div></td>
										<td class=forumrow>
											<input type="text" id="area" name="area" value="${data.area }"/><font class=required>*</font>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="70%"><div align="right">建档时间:</div></td>
										<td class=forumrow>
											<input type="text" id="builddate" name="builddate" value="${data.__disp.builddate}" class="Wdate" onClick="WdatePicker()"/><font class=required>*</font>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>
											<c:if test="${_action == 'add'}">
										      	<input type="button" value="确&nbsp;认" class="btnStyle" onclick="subform('save');"/>
												<input type="button" value="返&nbsp;回" class="btnStyle" onclick="window.location.href='<c:url value="/cell/list.html"/>'"/>
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="button" class="btnStyle" value="保&nbsp;存" onclick="subform('update');"/> 
								      		</c:if>
								      		<c:if test="${_action == 'edit' || _action == 'disp'}">
								      			<input type="button" class="btnStyle" value="返&nbsp;回" onclick="window.location.href='<c:url value="/cell/list.html"/>'"/>
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