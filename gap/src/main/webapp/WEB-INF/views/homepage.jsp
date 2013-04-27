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
								<img src="public/images/userLeft.gif" width="15" height="30" />
							</td>
							<td width="92" align="left" class="content font12White_B"
								nowrap="nowrap">
								当前管理员：
							</td>
							<td width="102" align="left" class="content font12White_B"
								nowrap="nowrap">
								a19000101
							</td>
							<td width="36" align="right" nowrap="nowrap"
								class="content font12White_B">
								<a href="#">退出</a>
							</td>
							<td width="15" align="right">
								<img src="public/images/userRight.gif" width="15" height="30" />
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
																	公司资料
																</p>
															</div>
															<ul id="shiyunul1" class="shiyunul">
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;公司简介</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;公司资质</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;公司新闻</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;产品与服务</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;联系我们</a>
																</li>
															</ul>
															<div id="menudiv2" class="shiyunlei2"
																onclick="zhedie('shiyunul2',this)">
																<p>
																	生产单元管理
																</p>
															</div>
															<ul id="shiyunul2" class="shiyunul">
																<li onclick="changeBgColor('shiyunul2',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="password.html" target="rightframe">&nbsp;生产单元编号</a>
																</li>
																<li onclick="changeBgColor('shiyunul2',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="WWFW010202.html" target="rightframe">&nbsp;生产单元面积</a>
																</li>
																<li onclick="changeBgColor('shiyunul2',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="cell/list.html" target="rightframe">&nbsp;生产单元信息</a>
																</li>
															</ul>
															<div id="menudiv3" class="shiyunlei2"
																onclick="zhedie('shiyunul3',this)">
																<p>
																	养殖类
																</p>
															</div>
															<ul id="shiyunul3" class="shiyunul">
																<li onclick="changeBgColor('shiyunul3',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;登记</a>
																</li>
																<li onclick="changeBgColor('shiyunul3',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;养殖过程</a>
																</li>
																<li onclick="changeBgColor('shiyunul3',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;已完成信息</a>
																</li>
																<li onclick="changeBgColor('shiyunul3',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;已归档信息</a>
																</li>
															</ul>
															<div id="menudiv4" class="shiyunlei2"
																onclick="zhedie('shiyunul4',this)">
																<p>
																	种植类
																</p>
															</div>
															<ul id="shiyunul4" class="shiyunul">
																<li onclick="changeBgColor('shiyunul4',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="grow/register/add.html" target="rightframe">&nbsp;登记</a>
																</li>
																<li onclick="changeBgColor('shiyunul4',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="grow/process/list.html" target="rightframe">&nbsp;种植过程</a>
																</li>
																<li onclick="changeBgColor('shiyunul4',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="grow/completed/list.html" target="rightframe">&nbsp;已完成信息</a>
																</li>
																<li onclick="changeBgColor('shiyunul4',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="grow/archived/list.html" target="rightframe">&nbsp;已归档信息</a>
																</li>
															</ul>
															<div id="menudiv5" class="shiyunlei2"
																onclick="zhedie('shiyunul5',this)">
																<p>
																	饲料
																</p>
															</div>
															<ul id="shiyunul5" class="shiyunul">
																<li onclick="changeBgColor('shiyunul5',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/toStorage.html" target="rightframe">&nbsp;饲料入库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul5',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/findGodownEntryList.html" target="rightframe">&nbsp;饲料入库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul5',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/toDelivery.html" target="rightframe">&nbsp;饲料出库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul5',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/deliverOrderList.html" target="rightframe">&nbsp;饲料出库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul5',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/stockList.html" target="rightframe">&nbsp;饲料库存</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/resource/index.html?resourceNumber=1" target="rightframe">&nbsp;饲料品名维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/resource/index.html?resourceNumber=2" target="rightframe">&nbsp;饲料规格维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/resource/index.html?resourceNumber=3" target="rightframe">&nbsp;饲料生产批号维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/resource/index.html?resourceNumber=4" target="rightframe">&nbsp;饲料生产商维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul1',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="feed/resource/index.html?resourceNumber=5" target="rightframe">&nbsp;饲料种类维护</a>
																</li>
															</ul>
															<div id="menudiv6" class="shiyunlei2"
																onclick="zhedie('shiyunul6',this)">
																<p>
																	肥料
																</p>
															</div>
															<ul id="shiyunul6" class="shiyunul">
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/instock/add.html" target="rightframe">&nbsp;肥料入库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/instock/list.html" target="rightframe">&nbsp;肥料入库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/outstock/add.html" target="rightframe">&nbsp;肥料出库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/outstock/list.html" target="rightframe">&nbsp;肥料出库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/stock/list.html" target="rightframe">&nbsp;肥料库存</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/resource/list.html?type=1" target="rightframe">&nbsp;肥料品名维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/resource/list.html?type=2" target="rightframe">&nbsp;肥料规格维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/resource/list.html?type=3" target="rightframe">&nbsp;肥料生产批号维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/resource/list.html?type=4" target="rightframe">&nbsp;肥料生产商维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul6',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="manure/resource/list.html?type=5" target="rightframe">&nbsp;肥料种类维护</a>
																</li>
															</ul>
															<div id="menudiv7" class="shiyunlei2"
																onclick="zhedie('shiyunul7',this)">
																<p>
																	农药
																</p>
															</div>
															<ul id="shiyunul7" class="shiyunul">
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/instock/add.html" target="rightframe">&nbsp;农药入库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/instock/list.html" target="rightframe">&nbsp;农药入库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/outstock/add.html" target="rightframe">&nbsp;农药出库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/outstock/list.html" target="rightframe">&nbsp;农药出库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/stock/list.html" target="rightframe">&nbsp;农药库存</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/resource/list.html?type=1" target="rightframe">&nbsp;农药品名维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/resource/list.html?type=2" target="rightframe">&nbsp;农药规格维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/resource/list.html?type=3" target="rightframe">&nbsp;农药生产批号维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/resource/list.html?type=4" target="rightframe">&nbsp;农药生产商维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul7',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="pesticide/resource/list.html?type=5" target="rightframe">&nbsp;农药种类维护</a>
																</li>
															</ul>
															<div id="menudiv8" class="shiyunlei2"
																onclick="zhedie('shiyunul8',this)">
																<p>
																	兽药
																</p>
															</div>
															<ul id="shiyunul8" class="shiyunul">
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药入库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药入库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药出库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药出库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药库存</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药品名维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药规格维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药生产批号维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药生产商维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul8',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;兽药种类维护</a>
																</li>
															</ul>
															<div id="menudiv9" class="shiyunlei2"
																onclick="zhedie('shiyunul9',this)">
																<p>
																	消毒剂
																</p>
															</div>
															<ul id="shiyunul9" class="shiyunul">
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂入库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂入库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂出库单</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂出库记录</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂库存</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂品名维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂规格维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂生产批号维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂生产商维护</a>
																</li>
																<li onclick="changeBgColor('shiyunul9',this)">
																	<img src="public/images/fangdian_06.gif" align="absmiddle" />
																	&nbsp;
																	<a href="tab.html" target="rightframe">&nbsp;消毒剂种类维护</a>
																</li>
															</ul>
															<div id="menudiv10" class="shiyunlei2"
																onclick="zhedie('shiyunul10',this)">
																<p>
																	投入品使用
																</p>
															</div>
															<div id="menudiv11" class="shiyunlei2"
																onclick="zhedie('shiyunul11',this)">
																<p>
																	产品出入库
																</p>
															</div>
															<div id="menudiv12" class="shiyunlei2"
																onclick="zhedie('shiyunul12',this)">
																<p>
																	环境管理
																</p>
															</div>
															<div id="menudiv13" class="shiyunlei2"
																onclick="zhedie('shiyunul13',this)">
																<p>
																	培训记录
																</p>
															</div>
															<div id="menudiv14" class="shiyunlei2"
																onclick="zhedie('shiyunul14',this)">
																<p>
																	员工基本信息
																</p>
															</div>
															<div id="menudiv15" class="shiyunlei2"
																onclick="zhedie('shiyunul15',this)">
																<p>
																	投诉建议
																</p>
															</div>
															<div id="menudiv16" class="shiyunlei2"
																onclick="zhedie('shiyunul16',this)">
																<p>
																	法律法规
																</p>
															</div>
															<div id="menudiv17" class="shiyunlei2"
																onclick="zhedie('shiyunul17',this)">
																<p>
																	抱怨处理
																</p>
															</div>
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
					<iframe id="rightframe" name="rightframe" style="width:100%; height:600px; border:0" scrolling="no"></iframe>
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
								本网站由：中国质量认证中心产品认证七部&nbsp;&nbsp;北京中认环宇技术支持
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
