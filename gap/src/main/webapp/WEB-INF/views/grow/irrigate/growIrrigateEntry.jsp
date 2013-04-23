<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
  		JGAP.on(window, 'load', function() {
	    	validator.regist({id : "date", name : "灌溉时间"}, "date");
	    	validator.regist({id : "area", name : "灌溉面积"}, "notnull", "number");
	    	validator.regist({id : "quantum", name : "灌溉量"}, "notnull", "number");
	    	validator.bindForm("form1");
	    });
    </script>
</head>
<body>
	<form id="form1" name="form1" method="post" action="<c:url value='/grow/irrigate/save.html'/>" onsubmit="return formCheck();">
		<input type="hidden" name="id" value="${data.id}"/>
		<input type="hidden" name="registerId" value="${registerId}"/>
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：灌溉记录</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">灌溉记录</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
								    <tr> 
								   	 	<td class=forumrow style="70%"><div align="right">时间:</div></td>
										<td class=forumrow>
											<input type="text" id="date" name="date" value="${data.__disp.date }" class="Wdate" onClick="WdatePicker()"/>
										</td>
								    </tr>
								    <tr>
										<td class=forumrow><div align="right">灌溉方式:</div></td>
										<td class=forumrow>
											<input type="text" name="way" value="${data.way }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">灌溉面积:</div></td>
										<td class=forumrow>
											<input type="text" id="area" name="area" value="${data.area }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">灌溉量:</div></td>
										<td class=forumrow>
											<input type="text" id="quantum" name="quantum" value="${data.quantum}"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">负责人:</div></td>
										<td class=forumrow>
											<input type="text" name="manager" value="${data.manager }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">备注:</div></td>
										<td class=forumrow>
											<textarea name="comment" cols="50" rows="4">${data.comment}</textarea>
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
								      		<input type="button" class="btnStyle" value="返&nbsp;回" onclick="goBack();"/>
										</td>
								    </tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>