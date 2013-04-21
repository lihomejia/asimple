<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>饲料入库记录</title>
		<%@include file="/public/jsp/commonjq.jsp"%>
	</head>

	<body>
		<!--内容菜单-->
		<table border="0" cellspacing="0" cellpadding="0"
			class="w960 mCenter mt10 ">
			<tr>
				<td width="790" align="left" valign="top" class="pl10">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width: 100%;">
						<tr>
							<td class="font12Blue p10">
								<span class="font12Blue_B">您当前所在位置：</span>饲料出库单
							</td>
						</tr>
					</table>
					  <form id=form1 name=form1 method="post" action="<c:url value='/feed/delivery.html'/>">
						<table cellpadding="2" cellspacing="1" border="0" width="95%" class="dataList" align=center>
					    <tr bgcolor=ffffff> 
					      <th height=25 colspan=4 align="center">饲料出库</th>
					    </tr>
					    <tr bgcolor=ffffff> 
					      <td width="10%" class=forumrow><div align="right">饲料名称：</div></td>
					      <td width="40%" class=forumrow> 
						  		<select id="stockid" name="stockid">
						  			<option value="">请选择出库饲料</option>
						  			<c:forEach items="${stocks}" var="stock">
						  				<option value="${stock.id }">${stock.rsname }_${stock.spname }_${stock.batchname }_${stock.producername}_${stock.typename}</option>
						  			</c:forEach>
						  		</select>
						  </td>
					      <td width="10%" class=forumrow><div align="right">出库时间：</div></td>
					      <td width="40%" class=forumrow><input id="deliveryDate" name="deliveryDate" />
					      </td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td  class=forumrow><div align="right">施用于：</div></td>
					      <td  class=forumrow>
							 <input id="useObject" name="useObject" /> 数量
							 <input name="quantity" type="text" id="quantity" size="5" /> 公斤
						 </td>
							<td class=forumrow><div align="right">出库人员：</div></td>
					      	<td class=forumrow><input name="operator" type="text" id="operator" /></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td rowspan="2" class=forumrow><div align="right">备注：</div></td>
					      <td colspan="3" class=forumrow><textarea name="remark" cols="63" rows="5" id="remark"></textarea></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td colspan="4" align="center" class=forumrow> <input type="button" value="确  定" onclick="delivery()"/> 
					        <input type="reset" name="Submit2" value="清 空" /></td>
					    </tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	  <script type="text/javascript">
	  		$(function() {
			    $( "#deliveryDate" ).datepicker();
			  });
			  
		function formCheck(){
			if (document.form1.stockid.value == ""){
                alert("请选择库存饲料!");
                document.form1.stockid.focus();
                return (false);
        	}  
			if (document.form1.deliveryDate.value == ""){
                alert("请输入出库时间!");
                document.form1.deliveryDate.focus();
                return (false);
        	}
        	if(document.form1.useObject.value == ""){
        		alert("请输入饲料用途!");
                document.form1.useObject.focus();
                return (false);
        	}
        	if (document.form1.quantity.value == "" || isNaN(document.form1.quantity.value)){
	        	alert("请输入正确的出库数量!");
	            document.form1.quantity.focus();
	            return false;
		     }
		     if (document.form1.operator.value == ""){
                alert("请输入出库人!");
                document.form1.operator.focus();
                return false;
		      }
        	return true;
        }
        
        function delivery(){
        	if(formCheck()){
        		$.ajax({
				   type: "POST",
				   url: "<%=basePath%>/feed/checkDelivery.html",
				   data: 'stockid=' + $('#stockid').val() + '&useQuantity=' + $('#quantity').val(),
				   success: function(rs){
				     	if(!rs){
				     		alert("当前饲料库存不足!");
				     		return;
				     	}
				     	$('#form1').submit();
				   }
				});
        	}
        }
	  </script>
	</body>
</html>