<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>种植过程</title>
	<%@include file="/public/jsp/common.jsp"%>
</head>

<body>
	<form id="form1" method="post">
		<table width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width:100%;">
			      		<tr>
			        		<td class="font12Blue p10"><span class="font12Blue_B">您当前所在位置：种植过程</td>
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
								<input type="hidden" name="stock_id" value=${stock_id}/>
								<table style="width:100%;">
									<tr>
										<td style="25%">生产单元:</td>
										<td style="25%">描述:</td>
									</tr>
									<tr>
										<td>
										</td>
										<td>
										</td>
										<td>
										</td>
										<td>
										</td>
									</tr>
									</tr>
										<td style="text-align:right" colspan="4">
											<input type="button" class="btnStyle" value="&nbsp;查&nbsp;询&nbsp;" onclick="doMethod('search');"/>
										</td>
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
         					 <td class="dataListTitle"><span class="pl10">种植过程</span></td>
       					</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataList">
									<tr>
						                <th width="5%">种植编号</th>
						                <th width="8%">生产单元</th>
						                <th>描述</th>
						                <th>登记日期</th>
						                <th>登记人</th>
						                <th>状态</th>
						                <th>农事活动</th>
						                <th>灌溉记录</th>
						                <th>投入品使用</th>
						                <th>收割记录</th>
						                <th>操作</th>
						            </tr>
						            <c:forEach items="${datas}" var="data" varStatus="status">
						              	<tr>
							                <td>${data.register_id}</td>
							                <td>${data.register_cellid__disp}</td>
							                <td>${data.register_desc}</td>
							                <td>${data.register_regdate__disp}</td>
							                <td>${data.register_person}</td>
							                <td>${data.register_status__disp}</td>
							                <td><a class=linkStyle href="#">农事活动</a></td>
							                <td><a class=linkStyle href="#">灌溉记录</a></td>
							                <td><a class=linkStyle href="#">肥料</a>&nbsp;|&nbsp;<a class=linkStyle href="#">农药</a></td>
							                <td><a class=linkStyle href="#">收割记录</a></td>
							                <td>
							                	<c:if test="${data.register_status == 0 }">
							                		<a class=linkStyle href="grow/register/auditing.html?register_id=${data.register_id}" onclick="return confirm('确定审核吗?')">审核</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="grow/register/edit.html?register_id=${data.register_id}">修改</a>
													&nbsp;|&nbsp;
							                		<a class=linkStyle href="grow/register/delete.html?register_id=${data.register_id}" onclick="return confirm('确定删除吗?')">删除</a>
							                	</c:if>
							                	<c:if test="${data.register_status == 1 }">
							                		<a class=linkStyle href="grow/register/complete.html?register_id=${data.register_id}" onclick="return confirm('确定完成吗?')">完成</a>
							                		&nbsp;|&nbsp;
							                		<a class=linkStyle href="grow/register/disp.html?register_id=${data.register_id}">查看</a>
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