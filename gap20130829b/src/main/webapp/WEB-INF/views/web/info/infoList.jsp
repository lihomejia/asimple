<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/common.jsp"%>
</head>
<body>
	<%@include file="/public/jsp/web/top.jsp" %>
	<form id="form1" method="post">
		<table border="0" cellspacing="0" cellpadding="0" class="mCenter w960 mt10">
			<!-- list -->
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" style="width:100%;">
						<%@include file="/public/jsp/pager.jsp"%>
						<tr>
         					 <td class="dataListTitle"><span class="pl10">${infoType.name}</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
										<th>编号</th>
										<th>标题</th>
										<th>关键字</th>
									</tr>
									<c:forEach items="${datas}" var="data" varStatus="status">
										<tr>
											<td>${pager.start+status.index}</td>
											<td><a class=linkStyle href="<%=basePath%>web/info/detail.html?id=${data.id}" target="_blank">${data.title}</a></td>
											<td><a class=linkStyle href="<%=basePath%>web/info/detail.html?id=${data.id}" target="_blank">${data.keyword}</a></td>
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
	<%@include file="/public/jsp/web/bottom.jsp" %>
</body>
</html>