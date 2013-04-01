<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>添加饲料入库</title>
		<%@include file="/public/jsp/common.jsp"%>
	</head>

	<body>
		<!--内容菜单-->
		<table border="0" cellspacing="0" cellpadding="0"
			class="w960 mCenter mt10 ">
			<tr>
				<td width="790" align="left" valign="top" class="pl10">
					<table width="100%" border="1" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width: 100%;">
						<tr>
							<td class="font12Blue p10">
								<span class="font12Blue_B">您当前所在位置：添加饲料入库
							</td>
						</tr>
					</table>
					<form name="form1" method="post" action="<c:url value='/feed/storage.html'/>" onsubmit="return formCheck();">
					  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="1" class="dataList">
					    <tr bgcolor=ffffff> 
					      <th height=25 colspan=4 align="center">添加饲料入库</th>
					    </tr>
					    <tr bgcolor=ffffff> 
					      <td width="15%" class=forumrow><div align="right">饲料名称：</div></td>
					      <td width="35%" class=forumrow>
								<select id="rsid" name='rsid'>
									<option selected value=""> 请选择饲料名称</option>
									<c:forEach items="${rsList}" var="rs">
										<option value="${rs.id }">${rs.name }</option>
									</c:forEach>
								</select>
						  </td>
					      <td width="15%" class=forumrow><div align="right">入库时间：</div></td>
					      <td width="35%" class=forumrow><input id="createDate" name="createDate" size="25" /></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">规格/型号：</div></td>
					      <td class=forumrow>
						    <select id="spid" name='spid'>
					          <option value="" selected>请选择规格型号</option>
								<c:forEach items="${spList}" var="sp">
										<option value="${sp.id }">${sp.name }</option>
								</c:forEach>
							</select>
						  </td>
					      <td class=forumrow><div align="right">所属类别：</div></td>
					      <td class=forumrow><select name="typeid" id="typeid">
					         <option value="" selected>请选择类别</option>
					          <c:forEach items="${typeList}" var="type">
								<option value="${type.id }">${type.name }</option>
							  </c:forEach>
					        </select>
					      </td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">生产批号：</div></td>
					      <td class=forumrow>
						  <select id="batchid" name='batchid'>
					          <option value="" selected>请选择生产批号</option>
							   <c:forEach items="${batchList}" var="batch">
								<option value="${batch.id }">${batch.name }</option>
							  </c:forEach>
					         </select>
						  </td>
					      <td class=forumrow><div align="right">有效期：</div></td>
					      <td class=forumrow><input id="expdate" name="expdate" size="25" /></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					    <td class=forumrow><div align="right">生产商：</div></td>
					      <td class=forumrow>
						  	<select id="producerid" name='producerid'>
					          <option value="" selected>请选择生产商家</option>
					          <c:forEach items="${producterList}" var="producter">
								<option value="${producter.id }">${producter.name }</option>
							  </c:forEach>
					         </select>
						  </td>
					      <td class=forumrow><div align="right">供应商：</div></td>
					      <td class=forumrow><input id="suppliers" name="suppliers" type="text" id="pname" size="25" maxlength="30" /></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">入库数量：</div></td>
					      <td colspan="3" class=forumrow> <input name="quantity" type="text" id="quantity" onkeypress="javascript:CheckNum();"  size="15" maxlength="10" /> 公斤 <font color=red>(注意：输入数量必须统一单位，这里的单位是公斤。)</font>
					        <div align="right"></div></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">产地：</div></td>
					      <td class=forumrow><input name="origin" type="text" id="origin" size="25" maxlength="30" /></td>
					      <td class=forumrow><div align="right">包装形式：</div></td>
					      <td class=forumrow><input name="packing" type="text" id="packing" size="25" maxlength="30" /> </td>
					    </tr>
					   <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">有效成分：</div></td>
					      <td class=forumrow><input name="ingredient" type="text" id="ingredient" size="25" maxlength="30" /></td>
					      <td class=forumrow><div align="right">入库人：</div></td>
					      <td class=forumrow><input name="operator" type="text" id="operator" size="25" maxlength="30"/> </td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td rowspan="2" class=forumrow><div align="right">备注1：</div></td>
					      <td colspan="3" class=forumrow><textarea name="remark" cols="73" rows="10" id="remark"></textarea></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td colspan="4" align="center"> 
					      	<input type="submit" class="btnStyle" name="Submit" value="添 加" /> 
					        <input type="reset" class="btnStyle" name="Submit2" value="清 空" />
					      </td>
					    </tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	  <script type="text/javascript">
	  		$(function() {
			    $( "#createDate" ).datepicker();
			    $( "#expdate").datepicker();
			  });
	  
	  		function formCheck(){
				if (document.form1.rsid.value == ""){
		                alert("请输入饲料名称!");
		                document.form1.rsid.focus();
		                return false;
		        }  
				if (document.form1.createDate.value == ""){
		                alert("请输入入库时间!");
		                document.form1.createDate.focus();
		                return false;
		        }
				if (document.form1.spid.value == ""){
		                alert("请输入规格!");
		                document.form1.spid.focus();
		                return false;
		        } 
				if (document.form1.typeid.value == ""){
		                alert("请输入所属类别!");
		                document.form1.typeid.focus();
		                return false;
		        }
				if (document.form1.batchid.value == ""){
		                alert("请输入生产批号!");
		                document.form1.batchid.focus();
		                return false;
		        } 
				if (document.form1.expdate.value == ""){
		                alert("请输入有效期!");
		                document.form1.expdate.focus();
		                return false;
		        }
				if (document.form1.producerid.value == ""){
		                alert("请输入生产厂家!");
		                document.form1.producerid.focus();
		                return false;
		        } 
		        if (document.form1.quantity.value == "" || isNaN(document.form1.quantity.value)){
		        	alert("请输入正确的入库数量!");
		            document.form1.quantity.focus();
		            return false;
		        }
				if (document.form1.operator.value == ""){
	                alert("请输入入库人!");
	                document.form1.operator.focus();
	                return false;
		        }
		        return true;
			}
	  </script>
	</body>
</html>