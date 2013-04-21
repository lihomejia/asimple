<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>肥料入库记录</title>
	<%@include file="/public/jsp/common.jsp"%>
</head>

<body>
	<form id="form1" method="post">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：肥料入库记录</td>
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
								<input type="hidden" name="stockId" value=${stockId}/>
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
													<option value="${resource.id}"  <c:if test="${resource.id==data.nameId}">selected</c:if>>${resource.name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['sizeid']">
												<c:forEach items="${specList}" var="resource" >
													<option value="${resource.id}"  <c:if test="${resource.id==data.specId}">selected</c:if>>${resource.name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['batchid']">
												<c:forEach items="${batchList}" var="resource" >
													<option value="${resource.id}"  <c:if test="${resource.id==data.batchId}">selected</c:if>>${resource.name}</option>
												</c:forEach>
											</select>
										</td>
										<td>
											<select name="data['producerid']">
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
         					 <td class="dataListTitle"><span class="pl10">肥料入库记录</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
						                <th width="5%">编号</th>
						                <th width="8%">肥料名称</th>
						                <th>规格型号</th>
						                <th>生产批号</th>
						                <th>生产商</th>
						                <th>入库数量(公斤)</th>
						                <th>入库人</th>
						                <th>入库时间</th>
						                <th>状态</th>
						                <th>操作</th>
						            </tr>
						            <c:forEach items="${datas}" var="data" varStatus="status">
						              	<tr>
							                <td>${pager.start+status.index}</td>
							                <td>${data.__disp.nameId}</td>
							                <td>${data.__disp.specId}</td>
							                <td>${data.__disp.batchId}</td>
							                <td>${data.__disp.producerId}</td>
							                <td style="text-align:right">${data.quantity}</td>
							                <td>${data.__disp.inuserId}</td>
							                <td>${data.__disp.indate}</td>
							                <td>${data.__disp.status}</td>
							                <td>
							                	<c:if test="${data.status == 0 }">
							                		<a class=linkStyle href="manure/instock/approve.html?id=${data.id}" onclick="return confirm('确定批准吗?')">批准</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="manure/instock/edit.html?id=${data.id}">修改</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="manure/instock/delete.html?id=${data.id}" onclick="return confirm('确定删除吗?')">删除</a>
							                	</c:if>
							                	<c:if test="${data.status == 2 }">
							                		<a class=linkStyle href="manure/instock/disp.html?id=${data.id}">查看</a>
							                		&nbsp;|&nbsp;
							                		<a class=linkStyle href="manure/instock/nullify.html?id=${data.id}" onclick="return confirm('确定作废吗?')">作废</a>
							                	</c:if>
							                	<c:if test="${data.status == 3 }">
							                		<a class=linkStyle href="manure/instock/disp.html?id=${data.id}">查看</a>
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