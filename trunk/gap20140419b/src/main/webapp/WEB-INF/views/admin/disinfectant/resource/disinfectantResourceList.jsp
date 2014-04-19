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
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：${resource.title}</td>
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
										<td style="30%">${resource.name}</td>
										<td>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" name="searcher.sfs['name'].value" value="${searcher.sfs['name'].value}"/>
											<input type="hidden" name="searcher.sfs['name'].name" value="name"/>
											<input type="hidden" name="searcher.sfs['name'].op.code" value="1"/>
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
						<%@include file="/public/jsp/pager.jsp"%>
						<tr>
         					 <td class="dataListTitle"><span class="pl10">${resource.title}</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
										<th>编号</th>
										<th>${resource.name}</th>
										<th>备注</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
									<c:forEach items="${datas}" var="data" varStatus="status">
										<tr>
											<td>${pager.start+status.index}</td>
											<td>${data.name}</td>
											<td>${data.comment}</td>
											<td>${data.disp.status}</td>
											<td>
												<c:if test="${data.status == 0}">
													<a class=linkStyle href="<%=basePath%>admin/disinfectant/resource/approve.html?type=${type}&id=${data.id}" onclick="return confirm('确定批准吗?');">批准</a>
													&nbsp;|&nbsp;
													<a class=linkStyle href="<%=basePath%>admin/disinfectant/resource/edit.html?type=${type}&id=${data.id}">修改</a>
													&nbsp;|&nbsp;
													<a class=linkStyle href="<%=basePath%>admin/disinfectant/resource/delete.html?type=${type}&id=${data.id}" onclick="return confirm('确定删除吗?');">删除</a>
												</c:if>
												<c:if test="${data.status == 2}">
													<a class=linkStyle href="<%=basePath%>admin/disinfectant/resource/nullify.html?type=${type}&id=${data.id}" onclick="return confirm('确定作废吗?');">作废</a>
													&nbsp;|&nbsp;
													<a class=linkStyle href="<%=basePath%>admin/disinfectant/resource/disp.html?type=${type}&id=${data.id}">查看</a>
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
					<input type="button" class="btnStyle" value="&nbsp;新&nbsp;建&nbsp;" onclick="window.location.href='<%=basePath%>admin/disinfectant/resource/add.html?type=${type}';"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>