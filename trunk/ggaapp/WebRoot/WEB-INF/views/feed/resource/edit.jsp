<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>用户管理</title>
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/reset.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>" />
		<script type="text/javascript" src="<c:url value='/js/menujs.js'/>"></script>
	</head>

	<body>
		<%@include file="/public/top.jsp"%>
		<!--内容菜单-->
		<table border="0" cellspacing="0" cellpadding="0"
			class="w960 mCenter mt10 ">
			<tr>
				<%@include file="/public/left.jsp"%>
				<td width="790" align="left" valign="top" class="pl10">
					<form name="form1" method="post" action="<c:url value='/feed/resource/edit.html'/>" onsubmit="return formCheck();">
					  <input id="rid" name="rid" type="hidden" value="${feedResource.id }"/>
					  <input id="resourceNumber" name="resourceNumber" type="hidden" value="${resource.number}"/>
					  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="dataList">
					    <tr height="22"> 
					      <th colspan="2" align="center" valign="middle">修改${resource.title }</th>
					    </tr>
					    <tr bgcolor="#FFFFFF" height="22"> 
					      <td width="32%" height="25" class=forumrow> <div align="right">${resource.resourceName }：</div></td>
					      <td class=forumrow><input id="resourceName" name="resourceName" value="${feedResource.name }" type="text" size="20" maxlength="30" /> 
					      </td>
					    </tr>
					    <tr bgcolor="#FFFFFF" height="22"> 
					      <td height="30" class=forumrow>&nbsp;</td>
					      <td class=forumrow><input type="submit" name="Submit" value="提交" /> <input type="reset" name="Submit2" value="还原" /> 
					    </tr>
					  </table>
					</form>
			<%@include file="/public/bottom.jsp"%>
	  <script type="text/javascript">
	  		function formCheck(){
	  			var resourceName = document.getElementById('resourceName').value;
	  			if(resourceName == ''){
	  				alert("请输入名称!");
	  				document.form1.resourceName.focus();
	  				return false;
	  			}
	  			return true;
	  		}
	  </script>
	</body>
</html>