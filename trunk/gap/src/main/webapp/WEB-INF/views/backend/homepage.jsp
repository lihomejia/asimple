<%@page import="com.company.gap.medicine.enumeration.MedicineResourceType"%>
<%@page import="com.company.gap.feed.enumeration.FeedResourceType"%>
<%@page import="com.company.gap.disinfectant.enumeration.DisinfectantResourceType"%>
<%@page import="com.company.gap.info.enumeration.InfoType"%>
<%@page import="com.company.gap.pesticide.enumeration.PesticideResourceType"%>
<%@page import="com.company.gap.manure.enumeration.ManureResourceType"%>
<%@page import="com.company.gap.resource.enumeration.DictType"%>
<%@page import="com.company.gap.resource.model.Dict"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Homepage</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>public/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>public/css/style.css" />
		<script type="text/javascript" src="<%=basePath%>public/js/menujs.js"></script>
		
		<script type="text/javascript">

			function shows(names) {
				document.getElementById(names).style.display='block';
			}
			function hiddens(names) {
				document.getElementById(names).style.display='none';
			}
			function shows2(names,ids) {
				document.getElementById(ids).className='current';		
				document.getElementById(names).style.display='block';
			}
			function hiddens2(names,ids) {
				document.getElementById(ids).className='';
				document.getElementById(names).style.display='none';
			}
			function expand(el) {
				childObj = document.getElementById("child" + el);
		
				if (childObj.style.display == 'none')
				{
					childObj.style.display = 'block';
				}
				else
				{
					childObj.style.display = 'none';
				}
				return;
			}
	</script>
	</head>
	<body>
		<!--头部-->
		<table border="0" cellspacing="0" cellpadding="0" class="w960 mCenter">
			<tr>
				<td align="left" valign="top" class="header_sub">
					<table width="260" border="0" cellspacing="0" cellpadding="0"
						class="userLoginBar">
						<tr>
							<td width="15" align="right">
								<img src="<%=basePath%>public/images/userLeft.gif" width="15" height="30" />
							</td>
							<td width="92" align="left" class="content font12White_B"
								nowrap="nowrap">
								当前管理员：
							</td>
							<td width="102" align="left" class="content font12White_B"
								nowrap="nowrap">
								${user.userName }
							</td>
							<td width="36" align="right" nowrap="nowrap"
								class="content font12White_B">
								<a href="<%=basePath%>backend/logout.html">退出</a>
							</td>
							<td width="15" align="right">
								<img src="<%=basePath%>public/images/userRight.gif" width="15" height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="0" class="mCenter w960">

			<tr>
				<td width="10" colspan="3" class="mainNavBottomBg"></td>
			</tr>
		</table>
		<!--二级导航-->
		<!--内容菜单-->
		<table border="0" cellspacing="0" cellpadding="0" class="w960 mCenter">
			<tr>
				<td width="170" align="left" valign="top">
					<table height="100%" cellspacing="0" cellpadding="0" width="170"
						border="0" class="userMenu">
						<tr>
							<td width="169" align="center" valign="top">
								<table width="187" height="100%" border="0" align="center"
									cellpadding="0 " cellspacing="0">
									<tr>
										<td width="100%" height="1" valign="top">
											<table cellspacing="0" cellpadding="0 " width="187"
												border="0">
												<tbody>
													<tr>
														<td height="42" align="left" class="left_tit">
															<strong>菜单</strong>
														</td>
													</tr>
													<tr>
														<td align="left">
															<div id="menudiv1" class="shiyunlei2"
																onclick="zhedie('shiyunul1',this)">
																<p>
																	公司管理
																</p>
															</div>
															<ul id="shiyunul1" class="shiyunul">
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="<%=basePath%>public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="<%=basePath%>backend/company/list.html" target="rightframe">&nbsp;公司维护</a>
																</li>
															</ul>
															<div id="menudiv2" class="shiyunlei2"
																onclick="zhedie('shiyunul2',this)">
																<p>
																	新闻公告
																</p>
															</div>
															<ul id="shiyunul2" class="shiyunul">
															<%
															for (InfoType infoType : InfoType.values()) {
															%>
																<li onclick="changeBgColor('shiyunul2',this)">
																	<img src="<%=basePath%>public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="<%=basePath%>backend/info/list.html?type=<%=infoType %>" target="rightframe">&nbsp;<%=infoType.getTitle() %></a>
																</li>
															 <%
															 }
															 %>
															</ul>
														</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td width="1" bgcolor="#d1e6f7"></td>
						</tr>
					</table>
				</td>
				<td width="790" align="left" valign="top" class="pl10">
					<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width: 100%;">
						<tr>
							<td class="font12Blue p10">
								<span class="font12Blue_B">您当前所在位置：</span>首页
							</td>
						</tr>
					</table> -->
					<iframe id="rightframe" name="rightframe" frameborder="no" style="width:100%; height:600px; border:0;" scrolling="no"></iframe>
				</td>
			</tr>
		</table>
		<!--底部-->
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="footer">
			<tr>
				<td valign="middle">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="24" align="center">
								本网站由：中国质量认证中心产品认证七部&nbsp;&nbsp;北京中认环宇技术支持 <a href="<%=basePath%>CaptureActivity.apk" style="color:blue">安卓下载</a>
							</td>
						</tr>
						<tr>
							<td height="24" align="center">
								Copyright&nbsp;&copy;&nbsp;2000-2010&nbsp;&nbsp;&nbsp;&nbsp;中国质量认证中心&nbsp;京ICP证030724&nbsp;&nbsp;声明：各个企业发布的信息由企业自身负责法律责任
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
