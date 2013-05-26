<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript" src="<%=basePath%>public/ueditor1_2_5_0-utf8-jsp/editor_config.js" ></script>
	<script type="text/javascript" src="<%=basePath%>public/ueditor1_2_5_0-utf8-jsp/editor_all_min.js"></script>
    <script type="text/javascript">
	    JGAP.on(window, 'load', function() {
	    	validator.regist({id : "title", name : "标题"}, "notnull");
	    	validator.regist({id : "keyword", name : "关键字"}, "notnull");
	    	validator.regist({id : "content_editor", name : "内容"}, function() {
	    		var content = UE.getEditor('content_editor').getContent();
	    		if (content != '') {
	    			document.getElementById('content').value = content;
	    			return true;
	    		}
	    		
	    		return '不能为空';
	    	});
	    	validator.bindForm("form1");
	    	
	   		var editor = UE.getEditor('content_editor');
	   		editor.ready(function() {
				UE.getEditor('content_editor').setContent(document.getElementById('content').value);
	   		});
	   	});
    </script>
</head>
<body>
	<form id="form1" method="post">
		<input type="hidden" name="id" value="${data.id}"/>
		<input type="hidden" name="type" value="${type}"/>
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">${resourceType.title}</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
										<td class=forumrow style="40%"><div align="right">标题:</div></td>
										<td class=forumrow>
											<input id="title" type="text" name="title" value="${data.title }" size="90"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow><div align="right">关键字:</div></td>
										<td class=forumrow>
											<input id="keyword" type="text" name="keyword" value="${data.keyword}" size="90"/>
										</td>
									</tr>
									
									<tr>
										<td class=forumrow><div align="right">内容:</div></td>
										<td class=forumrow>
											<input type="hidden" id="content" name="content" value="${data.content}">
											<textarea id="content_editor"></textarea>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>
											<c:if test="${_action == 'add'}">
										      	<input type="button" class="btnStyle" value="确&nbsp;认" onclick="subform('save');"/>
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="button" class="btnStyle" value="保&nbsp;存" onclick="subform('update');"/> 
								      		</c:if>
								      		<input type="button" class="btnStyle" value="返&nbsp;回" onclick="JGAP.goBack();"/>
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