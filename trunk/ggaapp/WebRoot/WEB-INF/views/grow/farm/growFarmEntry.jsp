<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/common.jsp"%>
    <script type="text/javascript">
  		function formCheck(){
	        return true;
		}
    </script>
</head>
<body>
	<form id="form1" name="form1" method="post" action="<c:url value='/grow/farm/save.html'/>" onsubmit="return formCheck();">
		<input type="hidden" name="data['farm_id']" value="${data.farm_id}"/>
		<input type="hidden" name="data['farm_registerid']" value="${register_id}"/>
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
								   	 	<td class=forumrow style="70%"><div align="right">时间:</div></td>
										<td class=forumrow>
											<input type="text" name="data['farm_date']" value="${data.farm_date }" class="Wdate" onClick="WdatePicker()"/>
										</td>
								    </tr>
								    <tr>
										<td class=forumrow><div align="right">农事活动内容:</div></td>
										<td class=forumrow>
											<textarea name="data['farm_content']" cols="50" rows="4">${data.farm_content}</textarea>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">农事活动规模(亩）:</div></td>
										<td class=forumrow>
											<input type="text" name="data['farm_scope']" value="${data.farm_scope }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">参与人员数量:</div></td>
										<td class=forumrow>
											<input type="text" name="data['farm_people']" value="${data.farm_people }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">负责人:</div></td>
										<td class=forumrow>
											<input type="text" name="data['farm_manager']" value="${data.farm_manager }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">备注:</div></td>
										<td class=forumrow>
											<textarea name="data['farm_comment']" cols="50" rows="4">${data.farm_comment}</textarea>
										</td>
									</tr>
								    <tr> 
								      	<td>&nbsp;</td>
										<td>
											<c:if test="${_action == 'add'}">
										      	<input type="submit" class="btnStyle" value="添&nbsp;加" />
										        <input type="reset" class="btnStyle" value="清&nbsp;空" />
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="submit" class="btnStyle" value="保&nbsp;存" /> 
								      		</c:if>
								      		<c:if test="${_action == 'edit' || _action == 'disp'}">
								      			<input type="button" class="btnStyle" value="返&nbsp;回" onclick="window.location.href='<c:url value="/grow/farm/list.html?register_id=${register_id}"/>'"/>
								      		</c:if>
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