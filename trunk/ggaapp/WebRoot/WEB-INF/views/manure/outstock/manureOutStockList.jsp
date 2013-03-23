<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>肥料出库记录</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/public/css/reset.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/public/css/style.css'/>" />
	<script type="text/javascript">
		function reviewPassDeliveryOrder(doid){
			if(confirm('确认审核通过吗？')){
				document.location.href = "<%=basePath%>feed/reviewPassDeliveryOrder.html?doid=" + doid;
			}
		}
		function editDeliveryOrder(doid){
			document.location.href = "<%=basePath%>feed/editDeliveryOrder.html?doid=" + doid;
		}
		function delDeliveryOrder(doid){
			if(confirm('确认要删除吗？')){
				document.location.href = "<%=basePath%>feed/delDeliveryOrder.html?doid=" + doid;
			}
		}
	</script>
</head>

<body>
	<form id="form1" method="post">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：肥料出库记录</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">查询</span></td>
						</tr>
						<tr>
							<td>
								<table style="width:100%;">
									<tr>
										<td style="30%">出库批号</td>
										<td></td>
									</tr>
									<tr>
										<td>
											<input type="text"/>
										</td>
										<td style="text-align:right">
											<input type="button" class="btnStyle" value="&nbsp;查&nbsp;询&nbsp;" onclick="doMethod('search');"/>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<!-- list -->
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" style="width:100%;">
						<tr>
							<td>
								<table cellspacing="0" style="width: 100%;">
									<tr>
										<td>
											<div style="margin-bottom: -4px">
												<%@include file="/public/jsp/view_infos.jsp"%>
											</div>
										</td>
										<td style="text-align: right;">
											<div>
												<%@include file="/public/jsp/view_pages.jsp"%>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
         					 <td class="dataListTitle"><span class="pl10">肥料出库记录</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
						                <th width="5%">出库编号</th>
						                <th width="8%">饲料名称</th>
						                <th>规格型号</th>
						                <th>生产批号</th>
						                <th>生产商</th>
						                <th>出库数量(公斤)</th>
						                <th>出库人</th>
						                <th>出库时间</th>
						                <th>状态</th>
						                <th>操作</th>
						            </tr>
						            <c:forEach items="${deliveryOrderList}" var="order" varStatus="status">
						              	<tr>
							                <td>${status.index+1 }</td>
							                <td>${order.rsname }</td>
							                <td>${order.spname }</td>
							                <td>${order.batchname}</td>
							                <td>${order.producername }</td>
							                <td>${order.quantity }</td>
							                <td>${order.operator }</td>
							                <td>${order.deliveryDate }</td>
							                <td>
							                	<c:if test="${order.status == 1 }">
							                		<span style="color:red">未审核</span>
							                	</c:if>
							                	<c:if test="${order.status == 2 }">
							                		已通过
							                	</c:if>
							                </td>
							                <td>
							                	<c:if test="${order.status == 1 }">
							                		<input type="button" value="允许出库" onclick="reviewPassDeliveryOrder('${order.id }')"/>
							                		<input type="button" value="修改" onclick="editDeliveryOrder('${order.id }')"/>
							                		<input type="button" value="删除" onclick="delDeliveryOrder('${order.id }')"/>
							                	</c:if>
							                	<c:if test="${order.status == 2 }">
							                		<input type="button" value="允许出库" disabled="disabled"/>
							                		<input type="button" value="修改" disabled="disabled"/>
							                		<input type="button" value="删除" disabled="disabled"/>
							                	</c:if>
							               	</td>
						              	</tr>
						            </c:forEach>
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