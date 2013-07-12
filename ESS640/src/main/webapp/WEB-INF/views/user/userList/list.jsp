<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/static/taglibs.jsp"%>

<!DOCTYPE HTML5>
<html>
<head>
	<base href="<%=basePath%>">
	<title>用户列表</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/style.css" />
</head>

<body >
	<div align="center">
		<table cellpadding="0" cellspacing="0" style="width:800px;">
			<tr>
				<td class="dataListTitle"><span class="pl10">用户管理</span></td>
			</tr>
			<tr>
				<td align="left" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
						<tr>
							<th style="width:25%">用户ID</th>
							<th style="width:25%">用户名</th>
							<th style="width:25%">邮&nbsp;箱</th>
							<th style="width:25%">操&nbsp;作</tdth
						</tr>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.asuserUserid }</td>
								<td>${user.asuserUsername}</td>
								<td>${user.asuserEmail}</td>
								<td>
									<a class=linkStyle href="<%=basePath%>user/userEntry/toEdit?id=${user.asuserUserid}">编辑</a>
								    &nbsp;|&nbsp;
								    <a class=linkStyle href="<%=basePath%>user/userEntry/delete?id=${user.asuserUserid}" onclick="return confirm('确定删除吗?')">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td style="text-align:right">
					<input type="button" class="btnStyle" value="新&nbsp;建" onclick="window.location.href='<%=basePath%>user/userEntry/toAdd';"/>
				</td>
			</tr>
		</table>
	</div>	
</body>
</html>
