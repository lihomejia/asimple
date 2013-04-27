<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>" target="_self">
	<title>肥料库存</title>
	<%@include file="/public/jsp/common.jsp"%>
	<script type="text/javascript">
		function doSelect(record) {
			window.returnValue = record;
			window.close();
		}
	</script>
</head>

<body onkeydown="if(event.keyCode==116){window.location.reload();}">
	<form id="form1" method="post">
		<table width="100%">
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
							                <td><input type="button" class="btnStyle" value="选择" onclick="doSelect({stockId:'${data.id}',nameId:'${data.disp.nameId}',specId:'${data.disp.specId}',batchId:'${data.disp.batchId}',producerId:'${data.disp.producerId}'});"/></td>
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