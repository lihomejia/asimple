<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>收割记录</title>
	<%@include file="/public/jsp/common.jsp"%>
</head>

<body>
	<form id="form1" method="post">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：收割记录</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<!-- list -->
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" style="width:100%;">
						<tr>
							<td>
								<table cellspacing="0" style="width: 100%;">
									<tr>
										<td>
											<div style="margin-bottom: -4px">
												<%@include file="/public/jsp/view_infos.jsp"%>
											</div>
										</td>
										<td style="text-align: right;">
											<div>
												<%@include file="/public/jsp/view_pages.jsp"%>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
         					 <td class="dataListTitle"><span class="pl10">收割记录</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
						                <th>序号</th>
						                <th>产品名称</th>
						                <th>产品批号</th>
						                <th>时间</th>
						                <th>规模</th>
						                <th>产量</th>
						                <th>储存地点</th>
						                <th>基地负责人</th>
						                <th>仓贮负责人</th>
						                <th>状态</th>
						                <th>备注</th>
						                <th>操作</th>
						            </tr>
						            <c:forEach items="${datas}" var="data" varStatus="status">
						              	<tr>
						              		<td>${pager.start+status.index}</td>
						              		<td>${data.product}</td>
						              		<td>${data.batch }</td>
						              		<td>${data.__disp.operatedate }</td>
						              		<td>${data.scale }</td>
						              		<td>${data.yield }</td>
						              		<td>${data.storage }</td>
						              		<td>${data.respmanager }</td>
						              		<td>${data.storemanager }</td>
						              		<td>${data.__disp.status}</td>
						              		<td>${data.comment }</td>
						              		<td>
						              			<c:if test="${data.status == 0}">
						              				<a class=linkStyle href="grow/harvest/approve.html?id=${data.id}&registerId=${registerId}" onclick="return confirm('确定批准吗?')">批准</a>
													&nbsp;|&nbsp;
						              				<a class=linkStyle href="grow/harvest/edit.html?id=${data.id}&registerId=${registerId}">修改</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="grow/harvest/delete.html?id=${data.id}&registerId=${registerId}" onclick="return confirm('确定删除吗?')">删除</a>
						              			</c:if>
						              			<c:if test="${data.status == 2}">
						              				<a class=linkStyle href="grow/harvest/disp.html?id=${data.id}&registerId=${registerId}">查看</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="grow/harvest/nullify.html?id=${data.id}&registerId=${registerId}" onclick="return confirm('确定作废吗?')">作废</a>
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
			<tr><td>&nbsp;</td></tr>
			</tr>
				<td style="text-align:right">
					<input type="button" class="btnStyle" value="&nbsp;添&nbsp;加&nbsp;" onclick='window.location.href="<c:url value='/grow/harvest/add.html'/>?registerId=${registerId}"'/>
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>