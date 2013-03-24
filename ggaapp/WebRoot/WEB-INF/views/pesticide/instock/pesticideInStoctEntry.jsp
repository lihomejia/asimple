<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/public/css/reset.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/public/css/style.css'/>" />
    <%@include file="/public/jsp/jquery.jsp"%>
    <script type="text/javascript">
	    $(function() {
	    	$( "#instock_indate" ).datepicker();
	    	$( "#instock_expirydate").datepicker();
	  	});
	  
  		function formCheck(){
			if (document.form1.instock_nameid.value == ""){
	                alert("请输入农药名称!");
	                document.form1.instock_nameid.focus();
	                return false;
	        }  
			if (document.form1.instock_indate.value == ""){
	                alert("请输入入库时间!");
	                document.form1.instock_indate.focus();
	                return false;
	        }
			if (document.form1.instock_sizeid.value == ""){
	                alert("请输入规格!");
	                document.form1.instock_sizeid.focus();
	                return false;
	        } 
			if (document.form1.instock_kindid.value == ""){
	                alert("请输入所属类别!");
	                document.form1.instock_kindid.focus();
	                return false;
	        }
			if (document.form1.instock_batchid.value == ""){
	                alert("请输入生产批号!");
	                document.form1.instock_batchid.focus();
	                return false;
	        } 
			if (document.form1.instock_expirydate.value == ""){
	                alert("请输入有效期!");
	                document.form1.instock_expirydate.focus();
	                return false;
	        }
			if (document.form1.instock_producerid.value == ""){
	                alert("请输入生产厂家!");
	                document.form1.instock_producerid.focus();
	                return false;
	        } 
	        if (document.form1.instock_quantity.value == "" || isNaN(document.form1.instock_quantity.value)){
	        	alert("请输入正确的入库数量!");
	            document.form1.instock_quantity.focus();
	            return false;
	        }
			if (document.form1.instock_inmanager.value == ""){
                alert("请输入入库人!");
                document.form1.instock_inmanager.focus();
                return false;
	        }
	        return true;
		}
    </script>
</head>
<body>
	<form id="form1" name="form1" method="post" action="<c:url value='/pesticide/instock/save.html'/>" onsubmit="return formCheck();">
		<input type="hidden" name="instock_id" value="${inStock.instock_id}">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：农药入库</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">农药入库</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr> 
								    	<td width="15%" class=forumrow><div align="right">农药名称：</div></td>
								      	<td width="35%" class=forumrow>
											<select id=instock_nameid name="instock_nameid">
												<option selected value=""> 请选择农药名称</option>
												<c:forEach items="${nameList}" var="rs">
													<option value="${rs.resource_id }" <c:if test="${rs.resource_id==inStock.instock_nameid}">selected</c:if>>${rs.resource_name }</option>
												</c:forEach>
											</select>
											<font color=red>*</font>
									  	</td>
								      	<td width="15%" class=forumrow><div align="right">入库时间：</div></td>
								      	<td width="35%" class=forumrow><input id="instock_indate" name="instock_indate" size="25" value="${inStock.instock_indate}"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								      	<td class=forumrow><div align="right">规格/型号：</div></td>
								      	<td class=forumrow>
										    <select id="instock_sizeid" name='instock_sizeid'>
									          <option value="" selected>请选择规格型号</option>
												<c:forEach items="${sizeList}" var="rs">
													<option value="${rs.resource_id }" <c:if test="${rs.resource_id==inStock.instock_sizeid}">selected</c:if>>${rs.resource_name }</option>
												</c:forEach>
											</select>
											<font color=red>*</font>
									  	</td>
								      	<td class=forumrow><div align="right">所属类别：</div></td>
								      	<td class=forumrow>
								      		<select name="instock_kindid" id="instock_kindid">
										    	<option value="" selected>请选择类别</option>
									        	<c:forEach items="${kindList}" var="rs">
													<option value="${rs.resource_id }" <c:if test="${rs.resource_id==inStock.instock_kindid}">selected</c:if>>${rs.resource_name }</option>
											  	</c:forEach>
										    </select>
										    <font color=red>*</font>
								      	</td>
								    </tr>
								    <tr> 
								      	<td class=forumrow><div align="right">生产批号：</div></td>
								      	<td class=forumrow>
									  		<select id="instock_batchid" name='instock_batchid'>
								          		<option value="" selected>请选择生产批号</option>
										   		<c:forEach items="${batchList}" var="rs">
													<option value="${rs.resource_id }" <c:if test="${rs.resource_id==inStock.instock_batchid}">selected</c:if>>${rs.resource_name }</option>
										 		</c:forEach>
								         	</select>
								         	<font color=red>*</font>
									  	</td>
								      	<td class=forumrow><div align="right">有效期：</div></td>
								      	<td class=forumrow><input id="instock_expirydate" name="instock_expirydate" size="25" value="${inStock.instock_expirydate}"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								    	<td class=forumrow><div align="right">生产商：</div></td>
								      	<td class=forumrow>
										  	<select id="instock_producerid" name='instock_producerid'>
										        <option value="" selected>请选择生产商家</option>
										        <c:forEach items="${producerList}" var="rs">
													<option value="${rs.resource_id }" <c:if test="${rs.resource_id==inStock.instock_producerid}">selected</c:if>>${rs.resource_name }</option>
												</c:forEach>
									        </select>
									        <font color=red>*</font>
									  	</td>
								      	<td class=forumrow><div align="right">供应商：</div></td>
								      	<td class=forumrow><input name="instock_vendor" type="text" size="25" maxlength="30" value="${inStock.instock_vendor}"/></td>
								    </tr>
								    <tr> 
								    	<td class=forumrow><div align="right">入库数量：</div></td>
								      	<td colspan="3" class=forumrow>
								      		<input name="instock_quantity" type="text" id="instock_quantity" onkeypress="javascript:CheckNum();"  size="15" maxlength="10" value="${inStock.instock_quantity}"/><font color=red>*</font> 公斤 <font color=red>(注意：输入数量必须统一单位，这里的单位是公斤。)</font>
								       	 	<div align="right"></div>
								        </td>
								    </tr>
								    <tr> 
										<td class=forumrow><div align="right">产地：</div></td>
									    <td class=forumrow><input name="instock_location" type="text" size="25" maxlength="30" value="${inStock.instock_location}"/></td>
									    <td class=forumrow><div align="right">包装形式：</div></td>
									    <td class=forumrow><input name="instock_wrap" type="text" size="25" maxlength="30" value="${inStock.instock_wrap}"/> </td>
								    </tr>
								   	<tr> 
								      	<td class=forumrow><div align="right">有效成分：</div></td>
								      	<td class=forumrow><input name="instock_element" type="text" size="25" maxlength="30" value="${inStock.instock_element}"/></td>
								      	<td class=forumrow><div align="right">入库人：</div></td>
								      	<td class=forumrow><input name="instock_inmanager" type="text" id="instock_inmanager" size="25" maxlength="30" value="${inStock.instock_inmanager}"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								      	<td rowspan="2" class=forumrow><div align="right">备注：</div></td>
								      	<td colspan="3" class=forumrow><textarea name="instock_comment" cols="73" rows="10">${inStock.instock_comment}</textarea></td>
								    </tr>
								    <tr> 
								      	<td colspan="4" align="center">
								      		<c:if test="${_action == 'add'}">
										      	<input type="submit" class="btnStyle" value="添&nbsp;加" /> 
										        <input type="reset" class="btnStyle" value="清&nbsp;空" />
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="submit" class="btnStyle" value="保&nbsp;存" /> 
								      		</c:if>
								      		<c:if test="${_action == 'edit' || _action == 'disp'}">
								      			<input type="button" class="btnStyle" value="返&nbsp;回" onclick="window.location.href='<c:url value="/pesticide/instock/list.html"/>'"/>
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