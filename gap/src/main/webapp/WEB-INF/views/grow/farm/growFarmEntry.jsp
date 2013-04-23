<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
  		JGAP.on(window, 'load', function() {
	    	validator.regist({id : "scale", name : "农事活动规模(亩)"}, "notnull", "number");
	    	validator.regist({id : "persons", name : "参与人员数量"}, "notnull", "number");
	    	validator.regist({id : "activitydate", name : "活动时间"}, "date");
	    	validator.bindForm("form1");
	   	});
    </script>
</head>
<body>
	<form id="form1" name="form1" method="post">
		<input type="hidden" name="id" value="${data.id}"/>
		<input type="hidden" name="registerId" value="${registerId}"/>
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：农事活动</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">农事活动</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
								    <tr> 
								   	 	<td class=forumrow style="70%"><div align="right">活动时间:</div></td>
										<td class=forumrow>
											<input type="text" id="activitydate" name="activitydate" value="${data.__disp.activitydate }" class="Wdate" onClick="WdatePicker()"/>
										</td>
								    </tr>
								    <tr>
										<td class=forumrow><div align="right">农事活动内容:</div></td>
										<td class=forumrow>
											<textarea name="content" cols="50" rows="4">${data.content}</textarea>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">农事活动规模(亩):</div></td>
										<td class=forumrow>
											<input type="text" id="scale" name="scale" value="${data.scale }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">参与人员数量:</div></td>
										<td class=forumrow>
											<input type="text" id="persons" name="persons" value="${data.persons }"/>
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
										      	<input type="button" class="btnStyle" value="确&nbsp;认" onclick="subform('save');"/>
										        <input type="reset" class="btnStyle" value="清&nbsp;空" />
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