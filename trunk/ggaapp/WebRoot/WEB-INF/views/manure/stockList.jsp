<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/public/css/style.css'/>" />
    <script type="text/javascript">
	    function doMethod(method) {
			var form = document.getElementById('form1');
			var url = form.action || window.location.href;
			form.action = url.replace(/(\/\w+\.html)/i, "/" + method + ".html");
			form.submit();
		}
    </script>
</head>
<body>
	<form id="form1" method="post">
		<table width="960">
			<!-- search -->
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td>查询</td>
						</tr>
						<tr>
							<td>
								<table style="width:100%;">
									<tr>
										<td style="30%">条件1</td>
										<td style="30%">条件2</td>
										<td style="30%">条件3</td>
									</tr>
									<tr>
										<td><input type="text"/></td>
										<td><input type="text"/></td>
										<td><input type="text"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td style="text-align:right"><input type="button" value='&nbsp;查&nbsp;询&nbsp;'/></td>
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
							<td>
								<table style="width:100%" border=1>
									<tr>
										<th width=100>ID</th>
										<th width=200>NAME</th>
									</tr>
									<c:forEach items="${datas}" var="data">
										<tr>
											<td>${data.mastockId}</td>
											<td>${data.mastockTotqty}</td>
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