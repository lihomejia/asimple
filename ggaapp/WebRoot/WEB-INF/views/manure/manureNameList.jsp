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
		
		function deleteConfirm() {
			if(confirm('确定删除吗?')){return true;}return false;
		}
    </script>
</head>
<body>
	<form id="form1" method="post">
		<table width="100%">
			<!-- search -->
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：肥料品名维护</td>
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
										<td style="30%">肥料名称</td>
										<td style="text-align:right">
											<input type="button" class="btnStyle" value="&nbsp;新&nbsp;建&nbsp;" onclick="window.location.href='add.html?type=1';"/>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" name="searcher.sfs['name'].value" value="${searcher.sfs['name'].value}"/>
											<input type="hidden" name="searcher.sfs['name'].name" value="resource_name"/>
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
         					 <td class="dataListTitle"><span class="pl10">肥料品名维护</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
										<th style="width:10%">ID</th>
										<th style="width:20%">肥料名称</th>
										<th style="width:20%">操作</th>
									</tr>
									<c:forEach items="${datas}" var="data">
										<tr>
											<td>${data['resource_id']}</td>
											<td>${data['resource_name']}</td>
											<td>
												<a class=linkStyle href="manure/resource/entry.html?type=1&resourceId=${data.resource_id}">修改</a>
												&nbsp;|&nbsp;
												<a class=linkStyle href="manure/resource/delete.html?type=1&resourceId=${data.resource_id}" onclick="return deleteConfirm();">删除</a>
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