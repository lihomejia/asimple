<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
	<title>兽药库存</title>
	<%@include file="/public/jsp/common.jsp"%>
</head>

<body>
	<form id="form1" method="post">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：兽药库存</td>
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
										<td style="25%">兽药名称:</td>
										<td style="25%">规格型号:</td>
										<td style="25%">生产批号:</td>
										<td style="25%">生产商:</td>
									</tr>
									<tr>
										<td>
											<select name="data['nameId']">
												<c:forEach items="${nameList}" var="resource" >
													<option value="${resource.id}"  <c:if test="${resource.id==data.nameId}">selected</c:if>>${resource.name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['specId']">
												<c:forEach items="${specList}" var="resource" >
													<option value="${resource.id}"  <c:if test="${resource.id==data.specId}">selected</c:if>>${resource.name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['batchId']">
												<c:forEach items="${batchList}" var="resource" >
													<option value="${resource.id}"  <c:if test="${resource.id==data.batchId}">selected</c:if>>${resource.name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['producerId']">
												<c:forEach items="${producerList}" var="resource" >
													<option value="${resource.id}"  <c:if test="${resource.id==data.producerId}">selected</c:if>>${resource.name}</option>
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
						<%@include file="/public/jsp/pager.jsp"%>
						<tr>
         					 <td class="dataListTitle"><span class="pl10">兽药库存</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
						                <th>编号</th>
						                <th>兽药名称</th>
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
							                <td>${data.disp.nameId}</td>
							                <td>${data.disp.specId}</td>
							                <td>${data.disp.batchId}</td>
							                <td>${data.disp.producerId}</td>
							                <td style="text-align:right">${data.quantity}</td>
							                <td><a href="<%=basePath%>medicine/instock/list.html?stockId=${data.id}">入库记录</a></td>
							                <td><a href="<%=basePath%>medicine/outstock/list.html?stockId=${data.id}">出库记录</a></td>
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