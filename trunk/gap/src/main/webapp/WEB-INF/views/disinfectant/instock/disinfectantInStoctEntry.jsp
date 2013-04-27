<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
  	<%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
    	JGAP.on(window, 'load', function() {
	    	validator.regist({id : "nameId", name : "消毒剂名称"}, "notnull");
	    	validator.regist({id : "specId", name : "规格"}, "notnull");
	    	validator.regist({id : "kindId", name : "所属类别"}, "notnull");
	    	validator.regist({id : "batchId", name : "生产批号"}, "notnull");
	    	validator.regist({id : "producerId", name : "生产厂家"}, "notnull");
	    	validator.regist({id : "quantity", name : "入库数量"}, "notnull", "number");
	    	validator.regist({id : "indate", name : "入库时间"}, "date");
	    	validator.regist({id : "expirydate", name : "有效期"}, "date");
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
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：消毒剂入库</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">消毒剂入库</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr> 
								    	<td width="15%" class=forumrow><div align="right">消毒剂名称：</div></td>
								      	<td width="35%" class=forumrow>
											<select id=nameId name="nameId">
												<option value=""> 请选择消毒剂名称</option>
												<c:forEach items="${nameList}" var="rs">
													<option value="${rs.id }" <c:if test="${rs.id==data.nameId}">selected</c:if>>${rs.name }</option>
												</c:forEach>
											</select>
											<font class=required>*</font>
									  	</td>
								      	<td width="15%" class=forumrow><div align="right">入库时间：</div></td>
								      	<td width="35%" class=forumrow><input id="indate" name="indate" size="25" value="${data.disp.indate}" class="Wdate" onClick="WdatePicker()"/><font class=required>*</font></td>
								    </tr>
								    <tr> 
								      	<td class=forumrow><div align="right">规格/型号：</div></td>
								      	<td class=forumrow>
										    <select id="specId" name="specId">
									          <option value="">请选择规格型号</option>
												<c:forEach items="${specList}" var="rs">
													<option value="${rs.id }" <c:if test="${rs.id==data.specId}">selected</c:if>>${rs.name }</option>
												</c:forEach>
											</select>
											<font class=required>*</font>
									  	</td>
								      	<td class=forumrow><div align="right">所属类别：</div></td>
								      	<td class=forumrow>
								      		<select name="kindId" id="kindId">
										    	<option value="">请选择类别</option>
									        	<c:forEach items="${kindList}" var="rs">
													<option value="${rs.id }" <c:if test="${rs.id==data.kindId}">selected</c:if>>${rs.name }</option>
											  	</c:forEach>
										    </select>
										    <font class=required>*</font>
								      	</td>
								    </tr>
								    <tr> 
								      	<td class=forumrow><div align="right">生产批号：</div></td>
								      	<td class=forumrow>
									  		<select id="batchId" name="batchId">
								          		<option value="">请选择生产批号</option>
										   		<c:forEach items="${batchList}" var="rs">
													<option value="${rs.id }" <c:if test="${rs.id==data.batchId}">selected</c:if>>${rs.name }</option>
										 		</c:forEach>
								         	</select>
								         	<font class=required>*</font>
									  	</td>
								      	<td class=forumrow><div align="right">有效期：</div></td>
								      	<td class=forumrow><input id="expirydate" name="expirydate" size="25" value="${data.disp.expirydate}" class="Wdate" onClick="WdatePicker()"/><font class=required>*</font></td>
								    </tr>
								    <tr> 
								    	<td class=forumrow><div align="right">生产商：</div></td>
								      	<td class=forumrow>
										  	<select id="producerId" name="producerId">
										        <option value="">请选择生产商家</option>
										        <c:forEach items="${producerList}" var="rs">
													<option value="${rs.id }" <c:if test="${rs.id==data.producerId}">selected</c:if>>${rs.name }</option>
												</c:forEach>
									        </select>
									        <font class=required>*</font>
									  	</td>
								      	<td class=forumrow><div align="right">供应商：</div></td>
								      	<td class=forumrow><input name="vendor" type="text" size="25" maxlength="30" value="${data.vendor}"/></td>
								    </tr>
								    <tr> 
								    	<td class=forumrow><div align="right">入库数量：</div></td>
								      	<td colspan="3" class=forumrow>
								      		<input name="quantity" type="text" id="quantity" onkeypress="javascript:CheckNum();"  size="15" maxlength="10" value="${data.quantity}"/><font class=required>*</font> 公斤 <font color=red>(注意：输入数量必须统一单位，这里的单位是公斤。)</font>
								       	 	<div align="right"></div>
								        </td>
								    </tr>
								    <tr> 
										<td class=forumrow><div align="right">产地：</div></td>
									    <td class=forumrow><input name="location" type="text" size="25" maxlength="30" value="${data.location}"/></td>
									    <td class=forumrow><div align="right">包装形式：</div></td>
									    <td class=forumrow><input name="wrap" type="text" size="25" maxlength="30" value="${data.wrap}"/> </td>
								    </tr>
								   	<tr> 
								      	<td class=forumrow><div align="right">有效成分：</div></td>
								      	<td class=forumrow><input name="element" type="text" size="25" maxlength="30" value="${data.element}"/></td>
								      	<td class=forumrow><div align="right">入库人：</div></td>
								      	<td class=forumrow>
								      		<input type="hidden" name="inuserId" size="25" maxlength="30" value="${data.inuserId}"/>
								      		<input type="text" value="${data.disp.inuserId}" disabled="disabled"/>
								      	</td>
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