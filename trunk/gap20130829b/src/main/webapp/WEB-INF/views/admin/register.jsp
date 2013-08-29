<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
	<base href="<%=basePath%>">
    <title>用户注册</title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
	    JGAP.on(window, 'load', function() {
	    	validator.regist({id : "userId", name : "用户ID"}, "notnull", {type:'len', length:20});
	    	validator.regist({id : "userName", name : "用户名"}, "notnull", {type:'lenb', length:60});
	    	validator.regist({id : "passWord", name : "密码"}, "notnull");
	    	
	    	validator.regist({id : "passWord2",name : "确认密码"}, "notnull", function() {
	    		var passWord = document.getElementById('passWord').value;
	    		var passWord2 = document.getElementById('passWord2').value;
	    		if (passWord == passWord2) return true;
	    		return '与密码不一致';
	    	});
	    	validator.bindForm("form1");
	   	});
    </script>
</head>
<body>
	<form id="form1" method="post" action="<%=basePath%>admin/registersave.html">
		<table width="100%">
			<tr>
				<td align="center">
					<table style="width:40%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">用户注册</span></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
									<tr>
										<td class=forumrow style="width:30%"><div align="right">用户ID:</div></td>
										<td class=forumrow>
											<input type="text" id="userId" name="userId" size="30"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow><div align="right">用户名:</div></td>
										<td class=forumrow>
											<input type="text" id="userName" name="userName" size="30"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow><div align="right">密码:</div></td>
										<td class=forumrow>
											<input type="password" id="passWord" name="passWord" size="30"/>
										</td>
									</tr>
									<tr>
										<td class=forumrow><div align="right">确认密码:</div></td>
										<td class=forumrow>
											<input type="password" id="passWord2" size="30"/>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>
									 		<input type="submit" class="btnStyle" value="注&nbsp;册"/>
									 		<input type="button" class="btnStyle" value="返&nbsp;回" onclick="location.replace(document.referrer);"/>
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