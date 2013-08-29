<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <link rel="stylesheet" href="<%=basePath%>public/kindeditor-4.1.7/themes/default/default.css" />
	<script type="text/javascript" src="<%=basePath%>public/kindeditor-4.1.7/kindeditor.js"></script>
	<script type="text/javascript" src="<%=basePath%>public/kindeditor-4.1.7/lang/zh_CN.js"></script>
    <script type="text/javascript">
    	var editor;
		KindEditor.ready(function(K) {
			editor = K.create('#content');
		});	
	    JGAP.on(window, 'load', function() {
	    	validator.regist({id : "content", name : "内容"}, function() {
	    		editor.sync();
	    		if (KindEditor('#content').val() != '') {
	    			return true;
	    		}
	    		else {
	    			return '不能为空';
	    		}
	    	});
	    	validator.bindForm("form1");
	   	});
    </script>
</head>
<body>
	<form id="form1" method="post">
		<input type="hidden" name="id" value="${data.id}"/>
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">资料</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									
									<tr>
										<td class=forumrow><div align="right">内容:</div></td>
										<td class=forumrow>
											<textarea id="content" name="content" style="width:100%;height:480px;">${data.content}</textarea>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>
								      		<input type="button" class="btnStyle" value="保&nbsp;存" onclick="subform('update');"/> 
										</td>
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