<%@ page language="java" pageEncoding="UTF-8"%>
<script language="javascript" type="text/javascript">
	function shows(names) {
		document.getElementById(names).style.display = 'block';
	}
	function hiddens(names) {
		document.getElementById(names).style.display = 'none';
	}
	function shows2(names, ids) {
		document.getElementById(ids).className = 'current';
		document.getElementById(names).style.display = 'block';
	}
	function hiddens2(names, ids) {
		document.getElementById(ids).className = '';
		document.getElementById(names).style.display = 'none';
	}
</script>

<!--头部-->
<table border="0" cellspacing="0" cellpadding="0" class="w960 mCenter">
  <tr>
    <td class="header">&nbsp;</td>
  </tr>
  <tr>
    <td height="5"></td>
  </tr>
</table>
<!--导航-->
<div class="mainNav">
  <div class="mainNav_downMenu1" id="mainNav_downMenu1" style="display:none;" onmouseover="shows2('mainNav_downMenu1','menu1')" onmouseout="hiddens2('mainNav_downMenu1','menu1')">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><a href="<%=basePath%>web/info/list.html?type=TZGG">通知公告</a></td>
      </tr>
      <tr>
        <td><a href="<%=basePath%>web/info/list.html?type=QYXW">企业新闻</a></td>
      </tr>
    </table>
  </div>
  <div class="mainNav_downMenu2" id="mainNav_downMenu2" style="display:none" onmouseover="shows2('mainNav_downMenu2','menu2')" onmouseout="hiddens2('mainNav_downMenu2','menu2')">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><a href="<%=basePath%>web/info/list.html?type=TZGG">相关法规</a></td>
      </tr>
      <tr>
        <td><a href="<%=basePath%>web/info/list.html?type=TZGG">相关条例</a></td>
      </tr>
      <tr>
        <td><a href="<%=basePath%>web/info/list.html?type=TZGG">管理办法</a></td>
      </tr>
      <tr>
        <td><a href="<%=basePath%>web/info/list.html?type=TZGG">相关标准</a></td>
      </tr>
    </table>
  </div>
  <div class="mainNav_downMenu4" id="mainNav_downMenu4" style="display:none" onmouseover="shows2('mainNav_downMenu4','menu4')" >
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><a href="#" id=downMenu1 onmouseover="shows('menu4Nav_downMenu1')" onmouseout="hiddens('menu4Nav_downMenu1')" >种植类</a></td>
        </tr>
        <tr>
            <td><a href="#" id=downMenu2 onmouseover="shows('menu4Nav_downMenu2')" onmouseout="hiddens('menu4Nav_downMenu2')" >养殖类</a></td>
        </tr>
    </table>
  </div>
  
  
  <div class="menu4Nav_downMenu1" id="menu4Nav_downMenu1" style="display:none" onmouseover="shows2('menu4Nav_downMenu1','downMenu1')" onmouseout="hiddens2('menu4Nav_downMenu1','downMenu1')">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <c:forEach items="${companyList1}" var="company">
	    <tr>
        	<td><a href="<%=basePath%>company/${company.companyno}.html" target="_blank">${company.companyname}</a></td>
      	</tr>
  	</c:forEach>
    </table>
  </div>
    <div class="menu4Nav_downMenu2" id="menu4Nav_downMenu2" style="display:none" onmouseover="shows2('menu4Nav_downMenu2','downMenu2')" onmouseout="hiddens2('menu4Nav_downMenu2','downMenu2')">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <c:forEach items="${companyList2}" var="company">
        <tr>
            <td><a href="<%=basePath%>company/${company.companyno}.html" target="_blank">${company.companyname}</a></td>
        </tr>
    </c:forEach>
    </table>
  </div>
  <table border="0" cellspacing="0" cellpadding="0" class="mCenter w960">
    <tr>
      <td width="5" align="left" class="mainNavLeftBg">&nbsp;</td>
      <td class="mainNavCenterBg">
      	<a href="<%=basePath%>web/index.html">首  页</a>
      	<a href="#" id="menu1" onmouseover="shows('mainNav_downMenu1')" onmouseout="hiddens('mainNav_downMenu1')" >新闻公告</a>
		<a href="#" id="menu2" onmouseover="shows('mainNav_downMenu2')" onmouseout="hiddens('mainNav_downMenu2')" >法律法规</a>
		<a href="#">产品认证</a>
		<a href="#" id="menu4" onmouseover="shows('mainNav_downMenu4')" onmouseout="hiddens('mainNav_downMenu4')" >GAP企业</a>
		<a href="#">投诉信息</a>
	  </td>
      <td width="5" align="right" class="mainNavRightBg">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3" class="mainNavBottomBg"></td>
    </tr>
  </table>
</div>