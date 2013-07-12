<%@ page language="java" pageEncoding="UTF-8"%>
<%@include  file="/static/taglibs.jsp"%>

<!DOCTYPE HTML5>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加界面</title>
  </head>
  
  <body>
  	<form id="form1" name="form1" action="user/userEntry/add" method="post">
	    <table>
	    	<tr>
	    		<td>用户ID：<input type="text" name="asuserUserid"/></td>
	    	</tr>
	    	<tr>
	    		<td>用户名：<input type="text" name="asuserUsername"/></td>
	    	</tr>
	    	<tr>
	    		<td>邮&nbsp;箱：<input type="text" name="asuserEmail"/></td>
	    	</tr>
	    	<tr>
	    		<td><input type="submit" value="提交"/></td>
	    	</tr>
	    </table>
    </form>
  </body>
</html>
