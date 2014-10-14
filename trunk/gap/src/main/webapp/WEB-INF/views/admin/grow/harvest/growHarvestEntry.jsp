<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
  		JGAP.on(window, 'load', function() {
	    	validator.regist({id : "batch", name : "产品批次号"}, "notnull", "number");
	    	validator.regist({id : "scale", name : "规模"}, "notnull", "number");
	    	validator.regist({id : "yield", name : "产量"}, "notnull", "number");
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
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：收割记录</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">收割记录</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
								    <tr> 
								   	 	<td class=forumrow style="70%"><div align="right">产品名称:</div></td>
										<td class=forumrow>
											<input type="text" name="product" value="${productName}" readonly="readonly"/>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow style="70%"><div align="right">产品批次号:</div></td>
										<td class=forumrow>
											<input type="text" id="batch" name="batch" value="${data.batch}"/>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow style="70%"><div align="right">时间:</div></td>
										<td class=forumrow>
											<input type="text" name="operatedate" value="${data.disp.operatedate}" class="Wdate" onClick="WdatePicker()"/>
										</td>
								    </tr>
								    <tr>
										<td class=forumrow><div align="right">收割方法:</div></td>
										<td class=forumrow>
											<select id="method" name="method">
												<option value=""> 请选择收割方法</option>
												<c:forEach items="${sgffList}" var="dict">
													<option value="${dict.id }" <c:if test="${dict.id==data.method}">selected</c:if>>${dict.name }</option>
												</c:forEach>
											</select>
											<font class=required>*</font>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">规模:</div></td>
										<td class=forumrow>
											<input type="text" id="scale" name="scale" value="${data.scale}"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">产量:</div></td>
										<td class=forumrow>
											<input type="text" id="yield" name="yield" value="${data.yield }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">储存地点:</div></td>
										<td class=forumrow>
											<input type="text" name="storage" value="${data.storage }"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">基地负责人:</div></td>
										<td class=forumrow>
											<input type="text" name="respmanager" value="${data.respmanager}"/>
										</td>
									</tr>
								    <tr>
										<td class=forumrow><div align="right">仓贮负责人:</div></td>
										<td class=forumrow>
											<input type="text" name="storemanager" value="${data.storemanager }"/>
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
								      		<input type="button" class="btnStyle" value="返&nbsp;回" onclick="JGAP.goBack();"/>
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