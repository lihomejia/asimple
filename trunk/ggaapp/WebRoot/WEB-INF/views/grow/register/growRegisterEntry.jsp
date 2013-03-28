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
	    	$( "#register_regdate" ).datepicker();
	  	});
	  
  		function formCheck(){
			if (document.form1.register_cellid.value == ""){
                alert("请选择生产单元!");
            	document.form1.register_cellid.focus();
                return false;
	        }  
			if (document.form1.register_regdate.value == ""){
                alert("请输入登记时间!");
                document.form1.register_regdate.focus();
                return false;
	        }
			if (document.form1.register_desc.value == ""){
                alert("请输入描述!");
                document.form1.register_desc.focus();
                return false;
	        } 
			if (document.form1.register_person.value == ""){
                alert("请输入登记人!");
                document.form1.register_person.focus();
                return false;
	        }
	        return true;
		}
    </script>
</head>
<body>
	<form id="form1" name="form1" method="post" action="<c:url value='/grow/register/save.html'/>" onsubmit="return formCheck();">
		<input type="hidden" name="register_id" value="${register.register_id}">
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
											<select id=register_cellid name="register_cellid">
												<option selected value="">请选择生产单元</option>
												<c:forEach items="${cellList}" var="cell">
													<option value="${cell.cell_id }" <c:if test="${cell.cell_id==register.register_cellid}">selected</c:if>>${cell.cell_code}</option>
												</c:forEach>
											</select>
											<font color=red>*</font>
									  	</td>
								      	<td width="15%" class=forumrow><div align="right">登记时间：</div></td>
								      	<td width="35%" class=forumrow><input id="register_regdate" name="register_regdate" size="25" value="${register.register_regdate}"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								   	 	<td class=forumrow><div align="right">描述：</div></td>
								      	<td width="35%" class=forumrow><input id="register_desc" name="register_desc" size="25" value="${register.register_desc}"/><font color=red>*</font></td>
								      	<td class=forumrow><div align="right">登记人：</div></td>
								      	<td width="35%" class=forumrow><input id="register_person" name="register_person" size="25" value="${register.register_person}"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								      	<td rowspan="2" class=forumrow><div align="right">备注：</div></td>
								      	<td colspan="3" class=forumrow><textarea name="register_comment" cols="73" rows="10">${register.register_comment}</textarea></td>
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
								      			<input type="button" class="btnStyle" value="返&nbsp;回" onclick="window.location.href='<c:url value="/grow/process/list.html"/>'"/>
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