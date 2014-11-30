<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/common.jsp"%>
</head>
<body>
	<form id="form1" method="post">
		<table width="100%">
			<!-- search -->
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：销售记录管理</td>
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
										<td style="30%">产品名称</td>
										<td style="30%">采购商名称</td>
										<td style="30%">采购商联系方式</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>
											<input type="text" name="searcher.sfs['product'].value" value="${searcher.sfs['product'].value}"/>
											<input type="hidden" name="searcher.sfs['product'].name" value="product"/>
											<input type="hidden" name="searcher.sfs['product'].op.code" value="1"/>
										</td>
										<td>
											<input type="text" name="searcher.sfs['purchaser'].value" value="${searcher.sfs['purchaser'].value}"/>
											<input type="hidden" name="searcher.sfs['purchaser'].name" value="purchaser"/>
											<input type="hidden" name="searcher.sfs['purchaser'].op.code" value="1"/>
										</td>
										<td>
											<input type="text" name="searcher.sfs['contact'].value" value="${searcher.sfs['contact'].value}"/>
											<input type="hidden" name="searcher.sfs['contact'].name" value="contact"/>
											<input type="hidden" name="searcher.sfs['contact'].op.code" value="1"/>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td style="text-align:right"><input type="button" class="btnStyle" value="&nbsp;查&nbsp;询&nbsp;" onclick="doMethod('search');"/></td>
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
         					 <td class="dataListTitle"><span class="pl10">销售记录管理</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
									    <th>编号</th>
										<th>销售时间</th>
										<th>产品名称</th>
										<th>产品批次号</th>
										<th>销售数量</th>
										<th>包装规格</th>
										<th>产品等级</th>
										<th>采购商名称</th>
										<th>采购商联系方式</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
									<c:forEach items="${datas}" var="data" varStatus="status">
										<tr>
											<td>${pager.start+status.index}</td>
											<td>${data.disp.saledate}</td>
											<td>${data.product}</td>
											<td>${data.batch}</td>
											<td>${data.quantity}</td>
											<td>${data.spec}</td>
											<td>${data.level}</td>
											<td>${data.purchaser}</td>
											<td>${data.contact}</td>
											<td>${data.disp.status}</td>
											<td>
												<c:if test="${data.status == 0}">
							                		<a class=linkStyle href="<%=basePath%>admin/pm/sale/approve.html?id=${data.id}" onclick="return confirm('确定批准吗?')">批准</a>
							                		&nbsp;|&nbsp;
							                		<a class=linkStyle href="<%=basePath%>admin/pm/sale/edit.html?id=${data.id}">修改</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="<%=basePath%>admin/pm/sale/delete.html?id=${data.id}" onclick="return confirm('确定删除吗?')">删除</a>
							                	</c:if>
							                	<c:if test="${data.status == 2}">
							                		<a class=linkStyle href="<%=basePath%>admin/pm/sale/disp.html?id=${data.id}">查看</a>
							                		&nbsp;|&nbsp;
							                		<a class=linkStyle href="<%=basePath%>admin/pm/sale/nullify.html?id=${data.id}" onclick="return confirm('确定作废吗?')">作废</a>
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
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td style="text-align:right">
					<input type="button" class="btnStyle" value="新&nbsp;建" onclick="window.location.href='<%=basePath%>admin/pm/sale/add.html';"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>