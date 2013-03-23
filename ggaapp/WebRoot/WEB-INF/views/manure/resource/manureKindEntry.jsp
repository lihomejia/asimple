<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/public/css/reset.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/public/css/style.css'/>" />
    <script type="text/javascript">
    
	    function doSubmit() {
	   	 	if (document.getElementById('resource_name').value == '') {
	    		alert('肥料种类不能为空');
	    		return false;
	    	}
			var form = document.getElementById('form1');
			form.submit();
		}
		
		function doCancel() {
			window.location.href = "list.html?type=5";
		}
    </script>
</head>
<body>
	<form id="form1" method="post" action="manure/resource/save.html">
		<input type="hidden" name="type" value="5"/>
		<input type="hidden" name="data['resource_id']" value="${data.resource_id }"/>
		<input type="hidden" name="data['resource_type']" value="5"/>
		
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">肥料种类维护</span></td>
						</tr>
						<tr>
							<td>
								<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
										<td class=forumrow style="30%"><div align="right">肥料种类:</div></td>
										<td class=forumrow>
											<input id="resource_name" type="text" name="data['resource_name']" value="${data.resource_name }"/>
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