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
								<input type="hidden" name="stock_id" value=${stock_id}/>
								<table style="width:100%;">
									<tr>
										<td style="25%">肥料名称:</td>
										<td style="25%">规格型号:</td>
										<td style="25%">生产批号:</td>
										<td style="25%">生产商:</td>
									</tr>
									<tr>
										<td>
											<select name="data['nameid']">
												<c:forEach items="${nameList}" var="resource" >
													<option value="${resource.resource_id}"  <c:if test="${resource.resource_id==data.nameid}">selected</c:if>>${resource.resource_name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['sizeid']">
												<c:forEach items="${sizeList}" var="resource" >
													<option value="${resource.resource_id}"  <c:if test="${resource.resource_id==data.sizeid}">selected</c:if>>${resource.resource_name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['batchid']">
												<c:forEach items="${batchList}" var="resource" >
													<option value="${resource.resource_id}"  <c:if test="${resource.resource_id==data.batchid}">selected</c:if>>${resource.resource_name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['producerid']">
												<c:forEach items="${producerList}" var="resource" >
													<option value="${resource.resource_id}"  <c:if test="${resource.resource_id==data.producerid}">selected</c:if>>${resource.resource_name}</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									</tr>
										<td style="text-align:right" colspan="4">
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
						            <c:forEach items="${datas}" var="data" varStatus="status">
						              	<tr>
							                <td>${data.outstock_id}</td>
							                <td>${data.outstock_nameid__disp }</td>
							                <td>${data.outstock_sizeid__disp }</td>
							                <td>${data.outstock_batchid__disp}</td>
							                <td>${data.outstock_producerid__disp }</td>
							                <td style="text-align:right">${data.outstock_quantity }</td>
							                <td>${data.outstock_outmanager }</td>
							                <td>${data.outstock_outdate__disp }</td>
							                <td>${data.outstock_status__disp }</td>
							                <td>
							                	<c:if test="${data.outstock_status == 0 }">
							                		<a class=linkStyle href="manure/outstock/auditing.html?outstock_id=${data.outstock_id}" onclick="return confirm('确定审核吗?')">审核</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="manure/outstock/edit.html?outstock_id=${data.outstock_id}">修改</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="manure/outstock/delete.html?outstock_id=${data.outstock_id}" onclick="return confirm('确定删除吗?')">删除</a>
							                	</c:if>
							                	<c:if test="${data.outstock_status == 1 }">
							                		<a class=linkStyle href="manure/outstock/disp.html?outstock_id=${data.outstock_id}">查看</a>
							                		&nbsp;|&nbsp;
							                		<a class=linkStyle href="manure/outstock/nullify.html?outstock_id=${data.outstock_id}" onclick="return confirm('确定作废吗?')">作废</a>
							                	</c:if>
							                	<c:if test="${data.instock_status == 2 }">
							                		<a class=linkStyle href="manure/outstock/disp.html?outstock_id=${data.outstock_id}">查看</a>
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