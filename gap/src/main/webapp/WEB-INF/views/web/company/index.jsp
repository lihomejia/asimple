<%@page import="com.company.gap.cinfo.model.Cinfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>GAP</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>public/css/reset.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>public/css/style.css" />
</head>

<body>
<!--头部-->
<table border="0" cellspacing="0" cellpadding="0" class="w960 mCenter">
  <tr>
    <td class="header">&nbsp;</td>
  </tr>
  <tr>
    <td height="5"></td>
  </tr>
</table>
<!--二级导航-->
<!--内容菜单-->
<table border="0" cellspacing="0" cellpadding="0" class="mCenter w960 mt10">
  <tr>
    <td align="left" valign="top">
      <!--公司简介-->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="centerMenu" style="width:100%;">
        <tr>
          <td class="titleBar"><span class="title">公司简介</span></td>
          <td align="right" class="titleBar"></td>
        </tr>
        <tr>
          <td colspan="2" valign="top" class="p10" style="height:432px;">
          		<c:forEach items="${GSJJ}" var="info">
          			${info.content}
          		</c:forEach>
		   </td>
        </tr>
      </table></td>
    <td width="270" align="right" valign="top">
      <!--用户注册-->
		<table border="0" cellspacing="0" cellpadding="0" class="userReg">
        <tr>
          <td class="p10">
          	<form id="form1" name="form1" method="post" action="<%=basePath%>admin/${companyno}/login.html" target="_blank">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="23" colspan="2" align="left" class="title">用户登录</td>
                </tr>
                <tr>
                  <td width="30%" height="24" align="center">用户名:</td>
                  <td width="70%" height="24" align="left">
                  	<input name="userId" value="admin"/>
                  </td>
                </tr>
                <tr>
                  <td height="24" align="center">密&nbsp;&nbsp;&nbsp;码:</td>
                  <td height="24" align="left">
                  	<input type="password" name="passWord" value="admin"/>
                  </td>
                </tr>
                <tr>
                  <td height="30" colspan="2" align="center"><input type="submit" value="登 录" class="btnStyle"/>
                    <input type="reset" value="重置" class="btnStyle"/></td>
                </tr>
              </table>
            </form>
           </td>
        </tr>
      </table>
      <!--公司新闻-->
      <table border="0" cellspacing="0" cellpadding="0" class="rightMenu mt10">
        <tr>
          <td class="titleBar"><table width="97%" border="0" align="left" cellpadding="0" cellspacing="0">
            <tr>
              <td><span class="title">公司新闻</span></td>
              <td align="right"><a href="<%=basePath%>company/${companyno}/cinfo/list2.html?type=GSXW" target="_blank" class="font12White_B">[更多]</a>&nbsp;</td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td valign="top" class="p10" style="height:118px;">
		  <MARQUEE  direction="up" HEIGHT="108" WIDTH="230" VSPACE="2" scrollAmount="2" ONMOUSEOUT=this.start() ONMOUSEOVER=this.stop()>
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="font12Blue">
		  	<c:forEach items="${GSXW}" var="info">
		  		<tr>
	              	<td height="26" align="left" class="font12Blue_B">·</td>
			      	<td height="26" colspan="2" align="left"><a href="<%=basePath%>company/${companyno}/cinfo/detail.html?id=${info.id}" target="_blank">${info.title}</a></td>
		    	</tr>
		  	</c:forEach>
            </table>
		  </MARQUEE>
		  </td>
        </tr>
    </table>
    <!-产品服务-->
      <table border="0" cellspacing="0" cellpadding="0" class="rightMenu mt10">
        <tr>
          <td class="titleBar"><table width="97%" border="0" align="left" cellpadding="0" cellspacing="0">
            <tr>
              <td><span class="title">产品服务</span></td>
              <td align="right"><a href="<%=basePath%>company/${companyno}/cinfo/list2.html?type=CPFW" target="_blank" class="font12White_B">[更多]</a>&nbsp;</td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td valign="top" class="p10" style="height:118px;">
		  <MARQUEE  direction="up" HEIGHT="108" WIDTH="230" VSPACE="2" scrollAmount="2" ONMOUSEOUT=this.start() ONMOUSEOVER=this.stop()>
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="font12Blue">
		  	<c:forEach items="${CPFW}" var="info">
		  		<tr>
	              	<td height="26" align="left" class="font12Blue_B">·</td>
			      	<td height="26" colspan="2" align="left"><a href="<%=basePath%>company/${companyno}/cinfo/detail.html?id=${info.id}" target="_blank">${info.title}</a></td>
		    	</tr>
		  	</c:forEach>
            </table>
		  </MARQUEE>
		  </td>
        </tr>
    </table>
    </td>
  </tr>
</table>
<!--底部-->
<%@include file="/public/jsp/web/bottom.jsp" %>
</body>
</html>