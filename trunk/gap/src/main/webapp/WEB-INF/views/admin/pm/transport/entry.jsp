<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <%@include file="/public/jsp/commonEntry.jsp"%>
    <script type="text/javascript">
		JGAP.on(window, 'load', function() {

            validator.regist({id : "transportdate", name : "运输日期"}, "date");
            validator.regist({id : "quantity", name : "运输数量"}, "notnull", "number");
            validator.regist({id : "productId", name : "产品名称"}, "notnull");
            validator.regist({id : "batch", name : "产品批次号"}, "notnull");
           
	    	validator.bindForm("form1");
	   	});
    </script>
</head>
<body>
	<form id="form1" method="post">
		<input type="hidden" name="id" value="${data.id}"/>
		<table width="100%">
			<tr>
				<td>
					<table style="width:100%;">
						<tr>
							<td class="dataListTitle"><span class="pl10">运输记录维护</span></td>
						</tr>
						<tr>
							<td>
								<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="dataList">
                                    <tr> 
                                        <td width="15%" class=forumrow><div align="right">运输日期:</div></td>
                                        <td width="35%" class=forumrow>
                                            <input type="text" id="transportdate" name="transportdate" value="${data.disp.transportdate}" class="Wdate" onClick="WdatePicker()"/><font class=required>*</font>
                                        </td>
                                        <td width="18%" class=forumrow><div align="right">运输数量：</div></td>
                                        <td width="32%" class=forumrow>
                                            <input id="quantity" name="quantity" value="${data.quantity}"/><font class=required>*</font>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <td class=forumrow><div align="right">产品名称:</div></td>
                                        <td class=forumrow>
                                            <c:if test="${_action == 'add'}">
                                                <select id=productId name="productId">
                                                    <option selected value="">请选择产品种类</option>
                                                    <c:forEach items="${cplbList}" var="dict">
                                                        <option value="${dict.id }">${dict.name}</option>
                                                    </c:forEach>
                                                </select>
                                                <font color=red>*</font>
                                            </c:if>
                                            <c:if test="${_action != 'add'}">
                                                <input type="hidden" id="productId" name="productId" value="${data.productId}"/>
                                                <input type="text" value="${data.disp.productId}" disabled="disabled"/>
                                            </c:if>
                                        </td>
                                        <td class=forumrow><div align="right">产品批次号：</div></td>
                                        <td class=forumrow>
                                            <input id="batch" name="batch" value="${data.batch}"/><font class=required>*</font>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <td class=forumrow><div align="right">包装规格:</div></td>
                                        <td class=forumrow>
                                            <input type="text" id="spec" name="spec" value="${data.spec}" />
                                        </td>
                                        <td class=forumrow><div align="right">产品等级：</div></td>
                                        <td class=forumrow>
                                            <input id="level" name="level" value="${data.level}"/>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <td class=forumrow><div align="right">运输方名称:</div></td>
                                        <td class=forumrow>
                                            <input type="text" id="partner" name="partner" value="${data.partner}" />
                                        </td>
                                        <td class=forumrow><div align="right">运输方联系方式：</div></td>
                                        <td class=forumrow>
                                            <input id="contact" name="contact" value="${data.contact}"/>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <td rowspan="2" class=forumrow><div align="right">备注：</div></td>
                                        <td colspan="3" class=forumrow><textarea name="comment" cols="73" rows="10">${data.comment}</textarea></td>
                                    </tr>
									<tr>
										<td colspan="4" align="center">
											<c:if test="${_action == 'add'}">
										      	<input type="button" class="btnStyle" value="确&nbsp;认" onclick="subform('save');"/>
								      		</c:if>
								      		<c:if test="${_action == 'edit'}">
								      			<input type="button" class="btnStyle" value="保&nbsp;存" onclick="subform('update');"/> 
								      		</c:if>
								      		<input type="button" class="btnStyle" value="返&nbsp;回" onclick="JGAP.goBack();"/>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
		</table>
	</form>
</body>
</html>