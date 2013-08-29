<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonjqEntry.jsp"%>
    <script type="text/javascript">
    	JGAP.on(window, 'load', function() {
	    	validator.regist({id : "stockId", name : "库存饲料"}, "notnull");
	    	validator.regist({id : "registerId", name : "饲料用途"}, "notnull");
	    	validator.regist({id : "quantity", name : "出库数量"}, "notnull", "number");
	    	validator.regist({id : "outdate", name : "出库时间"}, "date");
	    	validator.bindForm("form1");
	   	});
	   	
	   	function subform2(flag) {
	   		var form = document.forms[0];
        	if (typeof(form._onsubmit) == "function" && !form._onsubmit() 
        		|| typeof(form.onsubmit) == "function" && !form.onsubmit()) {
				return false;	
			}
       		var quantity =document.getElementById('quantity').value;
       		var oquantity = document.getElementById('oquantity').value;
       		quantity = (quantity == '' || isNaN(quantity)) ? 0 : parseFloat(quantity);
       		oquantity = (oquantity == '' || isNaN(oquantity)) ? 0 : parseFloat(oquantity);
       		var dquantity = quantity - oquantity;
       		if (dquantity <= 0) {
       			//当修改的金额比原来的还小，则无需校验库存.
       			subform(flag);
       			return;
       		}
       		
       		$.ajax({
			   type: "POST",
			   url: "<%=basePath%>feed/outstock/checkOutStock.html",
			   data: 'stockId=' + document.getElementById('stockId').value + '&quantity=' + dquantity,
			   success: function(rs){
			     	if(!rs){
			     		alert("当前饲料库存不足!");
			     		return;
			     	}
			     	subform(flag);
			   }
			});
        }
        
        function doStockList() {
			var record = window.showModalDialog("<%=basePath%>feed/stock/select/list.html", '', 'dialogWidth:650px; dialogHeight:400px; edge:Raised; center:yes; help:no; status:no;scroll=no;');
			if (!record) return;
			document.getElementById('stockId').value = record.stockId;
			document.getElementById('nameId').value = record.nameId;
			document.getElementById('specId').value = record.specId;
			document.getElementById('batchId').value = record.batchId;
			document.getElementById('producerId').value = record.producerId;
		}
    </script>
</head>
<body>
	<form id="form1" name="form1" method="post">
		<input type="hidden" name="id" value="${data.id}">
		<input type="hidden" name="stockId" id="stockId" value="${data.stockId}"/>
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：饲料出库</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">饲料出库</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
								    	<td width="15%" class=forumrow><div align="right">饲料名称：</div></td>
								      	<td width="35%" class=forumrow>
										  	<input id="nameId" value="${data.disp.nameId}" readonly="readonly" class="tdbgcolor_txtleft"/>
										  	<c:if test="${_action == 'add'}">
										  		<input type=button class="btnStyle" value="选择库存" onclick="doStockList();" />
										  	</c:if>
									  	</td>
								      	<td width="15%" class=forumrow><div align="right">出库时间：</div></td>
								      	<td width="35%" class=forumrow><input id="outdate" name="outdate" value="${data.disp.outdate}" class="Wdate" onClick="WdatePicker()"/><font color=red>*</font></td>
								    </tr>
								    <tr>
								    	<td class=forumrow><div align="right">规格/型号：</div></td>
								    	<td><input id="specId" value="${data.disp.specId}" readonly="readonly" class="tdbgcolor_txtleft"/></td>
								    	<td class=forumrow><div align="right">出库人员：</div></td>
								      	<td class=forumrow>
								      		<input type="hidden" name="outuserId" size="25" maxlength="30" value="${data.outuserId}"/>
								      		<input type="text" value="${data.disp.outuserId}" disabled="disabled"/>
								      	</td>
								    </tr>
								    <tr>
								    	<td class=forumrow><div align="right">生产批号：</div></td>
								    	<td><input id="batchId" value="${data.disp.batchId}" readonly="readonly" class="tdbgcolor_txtleft"/></td>
								    	<td class=forumrow><div align="right">施用于：</div></td>
								    	<td>
					      					<c:if test="${_action == 'add'}">
							      				<select id="registerId" name="registerId" style="width:80%">
											 		<c:forEach items="${registerList}" var="register">
											 			<option value="${register.id}">${register.description}</option>
											 		</c:forEach>
											 	</select>
											 	<font color=red>*</font>
											 </c:if>
											 <c:if test="${_action != 'add'}">
											 	<input type="hidden" id="registerId" name="registerId" value="${data.registerId}"/>
											 	<input type="hidden" name="cellId" value="${data.cellId}"/>
											 	<input type="text" value="${data.disp.registerId}" disabled="disabled" />
											 </c:if>
					      				</td>
								    </tr>
								    <tr>
								    	<td class=forumrow><div align="right">生产商：</div></td>
								    	<td><input id="producerId" value="${data.disp.producerId}" readonly="readonly" class="tdbgcolor_txtleft"/></td>
								    	<td class=forumrow><div align="right">数量(公斤)：</div></td>
								    	<td>
					      					<input type="hidden" id="oquantity" name="disp['quantity']" size="5" value="${data.quantity}"/>
					      					<input type="text" id="quantity" name="quantity" size="10" value="${data.quantity}"/><font color=red>*</font>
					      				</td>
								    </tr>
								    <tr> 
								      	<td rowspan="2" class=forumrow><div align="right">备注：</div></td>
								     	<td colspan="3" class=forumrow><textarea name="comment" cols="63" rows="5">${data.comment}</textarea></td>
								    </tr>
								    <tr> 
								      	<td colspan="4" align="center" class=forumrow>
								        	<c:if test="${_action == 'add'}">
										      	<input type="button" class="btnStyle" value="添&nbsp;加" onclick="subform2('save');"/> 
								        		<input type="reset" class="btnStyle" value="清&nbsp;空" />
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="button" class="btnStyle" value="保&nbsp;存" onclick="subform2('update');"/> 
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