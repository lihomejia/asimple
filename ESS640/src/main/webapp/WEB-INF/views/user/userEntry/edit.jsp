<%@ page language="java" pageEncoding="UTF-8"%>
<%@include  file="/static/taglibs.jsp"%>

<!DOCTYPE HTML5>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>编辑页面</title>
  </head>
  
  <body>
  	<form id="form1" name="form1" action="user/userEntry/edit" method="post">
  		<input type="hidden" name="asuserUserid" value="${user.asuserUserid}"/>
	    <table>
	    	<tr>
	    		<td>用户名：<input type="text" name="asuserUsername" value="${user.asuserUsername }"/></td>
	    	</tr>
	    	<tr>
	    		<td>邮&nbsp;箱：<input type="text" name="asuserEmail" value="${user.asuserEmail }"/></td>
	    	</tr>
	    	<tr>
	    		<td><input type="submit" value="提交"/></td>
	    	</tr>
	    </table>
    </form>
  </body>
</html>
