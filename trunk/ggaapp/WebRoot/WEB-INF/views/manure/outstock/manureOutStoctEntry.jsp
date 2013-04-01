<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonjq.jsp"%>
    <script type="text/javascript">
		function formCheck(){
			if (document.form1.outstock_stockid.value == ""){
                alert("请选择库存肥料!");
                document.form1.outstock_stockid.focus();
                return (false);
        	}  
			if (document.form1.outstock_outdate.value == ""){
                alert("请输入出库时间!");
                document.form1.outstock_outdate.focus();
                return (false);
        	}
        	if(document.form1.outstock_cellid.value == ""){
        		alert("请输入肥料用途!");
                document.form1.outstock_cellid.focus();
                return (false);
        	}
        	if (document.form1.outstock_quantity.value == "" 
        		|| isNaN(document.form1.outstock_quantity.value)
        		|| document.form1.outstock_quantity.value == 0){
	        	alert("请输入正确的出库数量!");
	            document.form1.outstock_quantity.focus();
	            return false;
		     }
		     if (document.form1.outstock_outmanager.value == ""){
                alert("请输入出库人!");
                document.form1.outstock_outmanager.focus();
                return false;
		      }
        	return true;
        }
        
        function doOutStock(){
        	if(formCheck()) {
        		$.ajax({
				   type: "POST",
				   url: "<%=basePath%>/manure/outstock/checkOutStock.html",
				   data: 'outstock_stockid=' + $('#outstock_stockid').val() + '&outstock_quantity=' + $('#outstock_quantity').val(),
				   success: function(rs){
				     	if(!rs){
				     		alert("当前肥料库存不足!");
				     		return;
				     	}
				     	$('#form1').submit();
				   }
				});
        	}
        }
    </script>
</head>
<body>
	<form id="form1" name="form1" method="post" action="<c:url value='/manure/outstock/save.html'/>">
		<input type="hidden" name="outstock_id" value="${outStock.outstock_id}">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：肥料出库</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">肥料出库</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr> 
								    	<td width="15%" class=forumrow><div align="right">肥料名称：</div></td>
								      	<td width="45%" class=forumrow> 
									  		<select id="outstock_stockid" name="outstock_stockid" style="width :90%">
									  			<option value="">请选择出库肥料</option>
									  			<c:forEach items="${stocks}" var="stock">
									  				<option value="${stock.stock_id }" <c:if test="${stock.stock_id == outStock.outstock_stockid}">selected</c:if>>${stock.stock_nameid__disp}_${stock.stock_sizeid__disp}_${stock.stock_batchid__disp}_${stock.stock_producerid__disp}</option>
									  			</c:forEach>
									  		</select>
									  		<font color=red>*</font>
									  	</td>
								      	<td width="15%" class=forumrow><div align="right">出库时间：</div></td>
								      	<td width="25%" class=forumrow><input id="outstock_outdate" name="outstock_outdate" value="${outStock.outstock_outdate}" class="Wdate" onClick="WdatePicker()"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								      	<td  class=forumrow><div align="right">施用于：</div></td>
								      	<td  class=forumrow>
								      		<table cellpadding="0" cellspacing="0" style="width:100%">
								      			<tr>
								      				<td style="width:50%">
									      				<select id="outstock_cellid" name="outstock_cellid" style="width:100%">
													 		<c:forEach items="${cellList}" var="cell">
													 			<option value="${cell.cell_id}" <c:if test="${cell.cell_id == outStock.outstock_cellid}">seleced</c:if>>${cell.cell_code} ${cell.cell_location}</option>
													 		</c:forEach>
													 	</select>
								      				</td>
								      				<td><font color=red>*</font></td>
								      				<td><input name="outstock_quantity" type="text" id="outstock_quantity" size="5" value="${outStock.outstock_quantity}"/></td>
								      				<td><font color=red>*</font>公斤</td>
								      			</tr>
								      		</table>
										 	
										 	
										 	 
									 	</td>
										<td class=forumrow><div align="right">出库人员：</div></td>
								      	<td class=forumrow><input name="outstock_outmanager" type="text" id="outstock_outmanager" value="${outStock.outstock_outmanager}"/><font color=red>*</font></td>
								    </tr>
								    <tr> 
								      	<td rowspan="2" class=forumrow><div align="right">备注：</div></td>
								     	<td colspan="3" class=forumrow><textarea name="outstock_comment" cols="63" rows="5">${outStock.outstock_comment}</textarea></td>
								    </tr>
								    <tr> 
								      	<td colspan="4" align="center" class=forumrow>
								        	<c:if test="${_action == 'add'}">
										      	<input type="button" class="btnStyle" value="添&nbsp;加" onclick="doOutStock()"/> 
								        		<input type="reset" class="btnStyle" value="清&nbsp; 空" />
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="button" class="btnStyle" value="保&nbsp;存" onclick="doOutStock()"/> 
								      		</c:if>
								      		<c:if test="${_action == 'edit' || _action == 'disp'}">
								      			<input type="button" class="btnStyle" value="返&nbsp;回" onclick="window.location.href='<c:url value="/manure/outstock/list.html"/>'"/>
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