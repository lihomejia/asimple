<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
  		JGAP.on(window, 'load', function() {
  			validator.regist({id : "nameId", name : "肥料名称"}, "notnull");
	    	validator.regist({id : "usedate", name : "使用时间"}, "date");
	    	validator.regist({id : "reason", name : "使用原因"}, "notnull");
	    	validator.regist({id : "useqty", name : "使用量"}, "notnull", "number");
	    	validator.regist({id : "machinecate", name : "施用机械类别"}, "notnull");
	    	validator.regist({id : "method", name : "使用方法"}, "notnull");
	    	validator.regist({id : "isolation", name : "安全间隔期"}, "notnull", "number");
	    	validator.regist({id : "useperson", name : "使用人员"}, "notnull");
	    	validator.regist({id : "tech", name : "技术负责人"}, "notnull");
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
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：肥料使用</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">肥料使用</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">	
									
								    <tr> 
								   	 	<td class=forumrow style="70%"><div align="right">肥料名称:</div></td>
										<td class=forumrow>
											<select id=nameId name="nameId">
												<option value=""> 请选择肥料名称</option>
												<c:forEach items="${nameList}" var="rs">
													<option value="${rs.id }" <c:if test="${rs.id==data.nameId}">selected</c:if>>${rs.name }</option>
												</c:forEach>
											</select>
											<font class=required>*</font>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow style="70%"><div align="right">使用时间:</div></td>
										<td class=forumrow>
											<input type="text" id="usedate" name="usedate" value="${data.disp.usedate }" class="Wdate" onClick="WdatePicker()"/><font class=required>*</font>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">使用原因:</div></td>
										<td class=forumrow>
											<input type="text" id="reason" name="reason" value="${data.reason}"/><font class=required>*</font>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">使用量:</div></td>
										<td class=forumrow>
											<input type="text" id="useqty" name="useqty" value="${data.useqty}"/><font class=required>*</font>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">施用机械类别:</div></td>
										<td class=forumrow>
											<select id=machinecate name="machinecate">
												<option value=""> 请选择施用机械类别</option>
												<c:forEach items="${jxlbList}" var="dict">
													<option value="${dict.id }" <c:if test="${dict.id==data.machinecate}">selected</c:if>>${dict.name }</option>
												</c:forEach>
											</select>
											<font class=required>*</font>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">使用方法:</div></td>
										<td class=forumrow>
											<select id=method name="method">
												<option value=""> 请选择使用方法</option>
												<c:forEach items="${syffList}" var="dict">
													<option value="${dict.id }" <c:if test="${dict.id==data.method}">selected</c:if>>${dict.name }</option>
												</c:forEach>
											</select>
											<font class=required>*</font>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">安全间隔期:</div></td>
										<td class=forumrow>
											<input type="text" id="isolation" name="isolation" value="${data.isolation}"/><font class=required>*</font>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">使用人员:</div></td>
										<td class=forumrow>
											<input type="text" id="useperson" name="useperson" value="${data.useperson}"/><font class=required>*</font>
										</td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">技术负责人:</div></td>
										<td class=forumrow>
											<input type="text" id="tech" name="tech" value="${data.tech}"/><font class=required>*</font>
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