<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/common.jsp"%>
</head>
<body>
	<form id="form1" method="post">
		<table width="100%">
			<!-- search -->
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：生产单元管理</td>
			      		</tr>
			   		 </table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">查询</span></td>
						</tr>
						<tr>
							<td>
								<table style="width:100%;">
									<tr>
										<td style="30%">单元代码</td>
										<td style="30%">单元位置</td>
										<td style="30%">单元面积</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>
											<input type="text" name="searcher.sfs['code'].value" value="${searcher.sfs['code'].value}"/>
											<input type="hidden" name="searcher.sfs['code'].name" value="cell_code"/>
											<input type="hidden" name="searcher.sfs['code'].op.code" value="1"/>
										</td>
										<td>
											<input type="text" name="searcher.sfs['location'].value" value="${searcher.sfs['location'].value}"/>
											<input type="hidden" name="searcher.sfs['location'].name" value="cell_location"/>
											<input type="hidden" name="searcher.sfs['location'].op.code" value="1"/>
										</td>
										<td>
											<input type="text" name="searcher.sfs['area'].value" value="${searcher.sfs['area'].value}"/>
											<input type="hidden" name="searcher.sfs['area'].name" value="cell_area"/>
											<input type="hidden" name="searcher.sfs['area'].op.code" value="1"/>
										</td>
										<td style="text-align:right">
											<input type="button" class="btnStyle" value="&nbsp;新&nbsp;建&nbsp;" onclick="window.location.href='<c:url value="/cell/add.html"/>';"/>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td style="text-align:right"><input type="button" class="btnStyle" value="&nbsp;查&nbsp;询&nbsp;" onclick="doMethod('search');"/></td>
									</tr>
								</table>
							</td>
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
         					 <td class="dataListTitle"><span class="pl10">生产单元管理</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
										<th>编号</th>
										<th>单元代码</th>
										<th>单元位置</th>
										<th>单元面积</th>
										<th>建档时间</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
									<c:forEach items="${datas}" var="data" varStatus="status">
										<tr>
											<td>${pager.start+status.index}</td>
											<td>${data.cell_code}</td>
											<td>${data.cell_location}</td>
											<td style="text-align:right">${data.cell_area}</td>
											<td>${data.__disp.cdate}</td>
											<td>${data.__disp.status}</td>
											<td>
												<c:if test="${data.cell_status == 0}">
							                		<a class=linkStyle href="cell/edit.html?cellId=${data.cell_id}">修改</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="cell/delete.html?cellId=${data.cell_id}" onclick="return confirm('确定删除吗?')">删除</a>
							                	</c:if>
							                	<c:if test="${data.cell_status == 1}">
							                		<a class=linkStyle href="cell/disp.html?cellId=${data.cell_id}">查看</a>
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
	</form>
</body>
</html>