<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
    	JGAP.on(window, 'load', function() {
	    	validator.regist({id : "cellId", name : "生产单元"}, "notnull");
	    	validator.regist({id : "description", name : "描述"}, "notnull");
	    	validator.regist({id : "person", name : "登记人"}, "notnull");
	    	validator.regist({id : "regdate", name : "登记时间"}, "date");
	    	validator.bindForm("form1");
	   	});
    </script>
</head>
<body>
	<form id="form1" name="form1" method="post">
		<input type="hidden" name="id" value="${data.id}">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：种植登记</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">种植登记</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr> 
								    	<td width="15%" class=forumrow><div align="right">生产单元：</div></td>
								      	<td width="35%" class=forumrow>
								      		<c:if test="${_action == 'add'}">
												<select id=cellId name="cellId">
													<option selected value="">请选择生产单元</option>
													<c:forEach items="${cellList}" var="cell">
														<option value="${cell.id }">${cell.code}</option>
													</c:forEach>
												</select>
												<font color=red>*</font>
											</c:if>
											<c:if test="${_action != 'add'}">
												<input type="hidden" id="cellId" name="cellId" value="${data.cellId}"/>
												<input type="text" value="${data.__disp.cellId}" disabled="disabled"/>
											</c:if>
									  	</td>
								      	<td width="15%" class=forumrow><div align="right">登记时间：</div></td>
								      	<td width="35%" class=forumrow><input id="regdate" name="regdate" size="25" value="${data.__disp.regdate}" class="Wdate" onClick="WdatePicker()"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">描述：</div></td>
								      	<td width="35%" class=forumrow><input id="description" name="description" size="25" value="${data.description}"/><font color=red>*</font></td>
								      	<td class=forumrow><div align="right">登记人：</div></td>
								      	<td width="35%" class=forumrow><input id="person" name="person" size="25" value="${data.person}"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								      	<td rowspan="2" class=forumrow><div align="right">备注：</div></td>
								      	<td colspan="3" class=forumrow><textarea name="comment" cols="73" rows="10">${data.comment}</textarea></td>
								    </tr>
								    <tr> 
								      	<td colspan="4" align="center">
								      		<c:if test="${_action == 'add'}">
										      	<input type="button" class="btnStyle" value="添&nbsp;加" onclick="subform('save');"/>
										        <input type="reset" class="btnStyle" value="清&nbsp;空" />
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
			</tr>	
		</table>
	</form>
</body>
</html>