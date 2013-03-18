<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>饲料入库记录</title>
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
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width: 100%;">
						<tr>
							<td class="font12Blue p10">
								<span class="font12Blue_B">您当前所在位置：</span>饲料库存
							</td>
						</tr>
					</table>
					<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="dataList">
				        <tr>
				          <td align="left" valign="top"><table width="80%" border="0" cellspacing="0" cellpadding="0" class="dataList">
				              <tr>
				                <th>库存编号</th>
				                <th>饲料名称</th>
				                <th>规格型号</th>
				                <th>生产批号</th>
				                <th>生产商</th>
				                <th>库存数量(公斤)</th>
				                <th>入库记录</th>
				                <th>出库记录</th>
				                <th>最后操作日期</th>
				              </tr>
				              <c:forEach items="${stocks}" var="stock" varStatus="status">
				              	<tr>
				                <td>${status.index+1 }</td>
				                <td>${stock.rsname }</td>
				                <td>${stock.spname }</td>
				                <td>${stock.batchname}</td>
				                <td>${stock.producername }</td>
				                <td>${stock.total_quantity }</td>
				                <td><a href="#">入库记录</a></td>
				                <td><a href="#">出库记录</a></td>
				                <td>
				                	${stock.updatetime }
				                </td>
				              </tr>
				              </c:forEach>
				            </table>
				           </td>
				        </tr>
				      </table>
				</td>
			</tr>
		</table>
	<script type="text/javascript">
		
	</script>
	</body>
</html>