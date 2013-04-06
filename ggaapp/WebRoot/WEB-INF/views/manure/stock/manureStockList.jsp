<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>肥料库存</title>
	<%@include file="/public/jsp/common.jsp"%>
</head>

<body>
	<form id="form1" method="post">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：肥料库存</td>
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
         					 <td class="dataListTitle"><span class="pl10">肥料库存</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
						                <th>编号</th>
						                <th>肥料名称</th>
						                <th>规格型号</th>
						                <th>生产批号</th>
						                <th>生产商</th>
						                <th>库存数量(公斤)</th>
						                <th>入库记录</th>
						                <th>出库记录</th>
						                <th>操作</th>
				              		</tr>
				              		<c:forEach items="${datas}" var="data" varStatus="status">
				              			<tr>
							                <td>${pager.start+status.index}</td>
							                <td>${data.stock_nameid__disp}</td>
							                <td>${data.stock_sizeid__disp}</td>
							                <td>${data.stock_batchid__disp}</td>
							                <td>${data.stock_producerid__disp}</td>
							                <td style="text-align:right">${data.stock_quantity}</td>
							                <td><a href="manure/instock/list.html?stock_id=${data.stock_id}">入库记录</a></td>
							                <td><a href="manure/outstock/list.html?stock_id=${data.stock_id}">出库记录</a></td>
							                <td></td>
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