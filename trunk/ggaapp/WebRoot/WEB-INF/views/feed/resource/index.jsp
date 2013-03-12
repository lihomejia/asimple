<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>用户管理</title>
		<link rel="stylesheet" type="text/css" href="<c:url value='/public/css/reset.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/public/css/style.css'/>" />
		<script type="text/javascript" src="<c:url value='/public/js/menujs.js'/>"></script>
	</head>
  <body>
	<!--内容菜单-->
	<table border="0" cellspacing="0" cellpadding="0"
		class="w960 mCenter mt10 ">
		<tr>
			<td width="790" align="left" valign="top" class="pl10">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="subNav mCenter" style="width: 100%;">
					<tr>
						<td class="font12Blue p10">
							<span class="font12Blue_B">您当前所在位置：</span>${resource.title }
						</td>
					</tr>
				</table>
				<form id="form2" name="form2" method="post" action="siliao_class.asp?typeid=4">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="mt10">
					 <tr>
			          <td class="dataListTitle"><span class="pl10">${resource.title }</span></td>
       				 </tr>
       				 <tr>
						<td align="left" valign="top">
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
								<tr>
									<th>${resource.resourceName }</th>
									<th>操作</th>
								</tr>
								<c:forEach items="${resources}" var="res">
									<tr>
										<td>${res.name }</td>
										<td>
											<a href="<c:url value='/feed/resource/toEdit.html?rid=${res.id }&resourceNumber=${resource.number}'/>">修改</a>
											<a href="<c:url value='/feed/resource/delete.html?rid=${res.id }&resourceNumber=${resource.number}'/>" onclick="{if(confirm('确定删除吗?')){return true;}return false;}">删除</a>
										</td>
									</tr>
								</c:forEach>
							</table>
						</td></tr>
					</table>
				</form>
				<form name="form1" method="post" action="<c:url value='/feed/resource/add.html'/>" onsubmit="return formCheck();">
				  <input id="resourceNumber" name="resourceNumber" type="hidden" value="${resource.number}" />
				  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
				    <tr height="22"> 
				      <th colspan="2" align="center" valign="middle">添加${resource.resourceName }</th>
				    </tr>
				    <tr bgcolor="#FFFFFF" height="22"> 
				      <td width="32%" height="25" class=forumrow> <div align="right">${resource.resourceName }：</div></td>
				      <td class=forumrow><input id="resourceName" name="resourceName" type="text" id="anclass2" size="20" maxlength="35" /> 
				      </td>
				    </tr>
				    <tr bgcolor="#FFFFFF" height="22"> 
				      <td height="30" class=forumrow>&nbsp;</td>
				      <td class=forumrow><input type="submit" name="Submit" value="添 加" class="btnStyle"/></td>
				    </tr>
				  </table>
				</form>
			</td>
		</tr>
	</table>
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
