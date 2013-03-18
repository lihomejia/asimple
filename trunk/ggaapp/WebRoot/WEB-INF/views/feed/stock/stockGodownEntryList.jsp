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
								<span class="font12Blue_B">您当前所在位置：</span>饲料入库记录
							</td>
						</tr>
					</table>
					<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="dataList">
				        <tr>
				          <td align="left" valign="top"><table width="80%" border="0" cellspacing="0" cellpadding="0" class="dataList">
				              <tr>
				                <th>入库编号</th>
				                <th>饲料名称</th>
				                <th>规格型号</th>
				                <th>生产批号</th>
				                <th>生产商</th>
				                <th>入库数量(公斤)</th>
				                <th>入库人</th>
				                <th>入库时间</th>
				                <th>状态</th>
				                <th>操作</th>
				              </tr>
				              <c:forEach items="${gdeList}" var="gde" varStatus="status">
				              	<tr>
				                <td>${status.index+1 }</td>
				                <td>${gde.rsname }</td>
				                <td>${gde.spname }</td>
				                <td>${gde.batchname}</td>
				                <td>${gde.producername }</td>
				                <td>${gde.quantity }</td>
				                <td>${gde.operator }</td>
				                <td>${gde.createdate }</td>
				                <td>
				                	<c:if test="${gde.status == 1 }">
				                		<span style="color:red">未审核</span>
				                	</c:if>
				                	<c:if test="${gde.status == 2 }">
				                		已通过
				                	</c:if>
				                </td>
				                <td>
				                	<c:if test="${gde.status == 1 }">
				                		<input type="button" value="允许入库" onclick="reviewPassGde('${gde.id }')"/>
				                		<input type="button" value="修改" onclick="editGde('${gde.id }')"/>
				                		<input type="button" value="删除" onclick="deleteGde('${gde.id }')"/>
				                	</c:if>
				                	<c:if test="${gde.status == 2 }">
				                		<input type="button" value="允许入库" disabled="disabled"/>
				                		<input type="button" value="修改" disabled="disabled"/>
				                		<input type="button" value="删除" disabled="disabled"/>
				                	</c:if>
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
		function reviewPassGde(gdeid){
			if(confirm('确认审核通过吗？')){
				document.location.href = "<%=basePath%>feed/reviewPassGde.html?gdeid=" + gdeid;
			}
		}
		function edit(gdeid){
			document.location.href = "<%=basePath%>feed/toEditGde.html?gdeid=" + gdeid;
		}
		function deleteGde(gdeid){
			if(confirm('确认要删除吗？')){
				document.location.href = "<%=basePath%>feed/deleteGde.html?gdeid=" + gdeid;
			}
		}
	</script>
	</body>
</html>