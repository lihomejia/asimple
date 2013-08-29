<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
    	var errormsg = '<%=request.getAttribute("errormsg")%>';
    	if (errormsg != 'null') {
    		alert(errormsg);
    	}
    
	    JGAP.on(window, 'load', function() {
	    	validator.regist({id : "name", name : "${dictType.name}"}, "notnull");
	    	validator.bindForm("form1");
	   	});
    </script>
</head>
<body>
	<form id="form1" method="post">
		<input type="hidden" name="id" value="${data.id}"/>
		<input type="hidden" name="type" value="${type}"/>
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">${dictType.title}</span></td>
						</tr>
						<tr>
							<td>
								<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
										<td class=forumrow style="30%"><div align="right">${dictType.name}:</div></td>
										<td class=forumrow>
											<input id="name" type="text" name="name" value="${data.name }"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="30%"><div align="right">备注:</div></td>
										<td class=forumrow>
											<textarea name="comment" cols="73" rows="10">${data.comment}</textarea>
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
								      		<input type="button" class="btnStyle" value="返&nbsp;回" onclick="window.location.href='<%=basePath%>admin/resource/dict/list.html?type=${type}';"/>
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