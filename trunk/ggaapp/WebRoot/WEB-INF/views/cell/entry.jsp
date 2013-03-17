<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/public/css/reset.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/public/css/style.css'/>" />
    <%@include file="/public/jsp/jquery.jsp"%>
    <script type="text/javascript">
    	$(function() {
		    $( "#cdate").datepicker();
		});
    
    
	    function doSubmit() {
			var form = document.getElementById('form1');
			form.submit();
		}
		
		function doCancel() {
			window.location.href = "list.html";
		}
    </script>
</head>
<body>
	<form id="form1" method="post" action="cell/save.html">
		<input type="hidden" name="data['cell_id']" value="${data.cell_id }"/>
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">生产单元维护</span></td>
						</tr>
						<tr>
							<td>
								<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
										<td class=forumrow style="30%"><div align="right">单元代码:</div></td>
										<td class=forumrow>
											<input type="text" name="data['cell_code']" value="${data.cell_code }"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="70%"><div align="right">单元位置:</div></td>
										<td class=forumrow>
											<input type="text" name="data['cell_location']" value="${data.cell_location }"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="70%"><div align="right">单元面积:</div></td>
										<td class=forumrow>
											<input type="text" name="data['cell_area']" value="${data.cell_area }"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow style="70%"><div align="right">建档时间:</div></td>
										<td class=forumrow>
											<input type="text" id="cdate" name="data['cell_cdate']" value="${data.cell_cdate }"/>
										</td>
									</tr>
									<tr>
										<td style="text-align:right"><input type="button" value="&nbsp;取&nbsp;消&nbsp;" class="btnStyle" onclick="doCancel();"/></td>
										<td style="text-align:left"><input type="button" value="&nbsp;确&nbsp;认&nbsp;" class="btnStyle" onclick="doSubmit();"/></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
		</table>
	</form>
</body>
</html>