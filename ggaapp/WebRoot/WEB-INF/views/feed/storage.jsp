<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>添加饲料入库</title>
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
					<table width="100%" border="1" cellspacing="0" cellpadding="0" class="subNav mCenter" style="width: 100%;">
						<tr>
							<td class="font12Blue p10">
								<span class="font12Blue_B">您当前所在位置：添加饲料入库
							</td>
						</tr>
					</table>
					<form name="form1" method="post" action="<c:url value='/feed/resource/edit.html'/>" onsubmit="return formCheck();">
					  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" class="dataList">
					    <tr bgcolor=ffffff> 
					      <th height=25 colspan=4 align="center">添加饲料入库</th>
					    </tr>
					    <tr bgcolor=ffffff> 
					      <td width="15%" class=forumrow><div align="right">饲料名称：</div></td>
					      <td width="35%" class=forumrow>
						    <select name='ppselect' onChange='document.form1.goodname.value=(this.options[this.selectedIndex].value)'>
					          <option selected>请选择饲料名称</option>
							    <option value=8991>8991</option><option value=8993>8993</option><option value=7#>7#</option><option value=1#>1#</option><option value=2#>2#</option><option value=3#>3#</option><option value=4#>4#</option><option value=5#>5#</option><option value=0#>0#</option><option value=8888>8888</option><option value=0#>0#</option><option value=8992>8992</option><option value=TO#>TO#</option><option value=AO#>AO#</option><option value=鱼苗开口料>鱼苗开口料</option><option value=鱼苗01>鱼苗01</option><option value=111>111</option>
					         </select>
						  </td>
					      <td width="15%" class=forumrow><div align="right">入库时间：</div></td>
					      <td width="35%" class=forumrow><input name="ruku_date" onfocus="calendar()" size="25" /></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">规格/型号：</div></td>
					      <td class=forumrow>
						    <select name='ggselect' onchange='document.form1.guige.value=(this.options[this.selectedIndex].value)'>
					          <option selected>请选择规格型号</option>
							    <option value=5kg/袋>5kg/袋</option><option value=25kg/袋>25kg/袋</option><option value=20kg/袋>20kg/袋</option><option value=10kg/袋>10kg/袋</option>
					         </select>
						  </td>
					      <td class=forumrow><div align="right">所属类别：</div></td>
					      <td class=forumrow><select name="leibie" id="leibie">
					         <option value="" selected>======请选择类别======</option>
					          <option value=55>鱼苗料</option><option value=54>虾料</option><option value=53>海水鱼料</option><option value=27>罗非鱼料</option>
					          
					        </select>
					      </td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">生产批号：</div></td>
					      <td class=forumrow>
						  <select name='phselect' onchange='document.form1.pihao.value=(this.options[this.selectedIndex].value)'>
					          <option selected>请选择生产批号</option>
							    <option value=20081224>20081224</option><option value=20081223>20081223</option><option value=20081227>20081227</option><option value=20090112>20090112</option><option value=20090104>20090104</option><option value=20090118>20090118</option><option value=20090120>20090120</option><option value=20090321>20090321</option><option value=20090326>20090326</option><option value=20090213>20090213</option><option value=20090302>20090302</option>
					         </select>
						  
						  
						  </td>
					      <td class=forumrow><div align="right">有效期：</div></td>
					      <td class=forumrow><input name="youxiaoqi" onfocus="calendar()" size="25" /></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					    <td class=forumrow><div align="right">生产商：</div></td>
					      <td class=forumrow>
						  <select name='shselect' onChange='document.form1.shengchansh.value=(this.options[this.selectedIndex].value)'>
					          <option selected>请选择生产商家</option>
							    <option value=广州海维饲料有限公司>广州海维饲料有限公司</option><option value=珠海市世海饲料有限公司>珠海市世海饲料有限公司</option>
					         </select>
						  
						  </td>
					      <td class=forumrow><div align="right">供应商：</div></td>
					      <td class=forumrow><input name="gongyingsh" type="text" id="pname" size="25" maxlength="30" /></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">入库数量：</div></td>
					      <td colspan="3" class=forumrow> <input name="shuliang" type="text" id="shuliang" onkeypress="javascript:CheckNum();"  size="15" maxlength="10" /> 公斤 <font color=red>(注意：输入数量必须统一单位，这里的单位是公斤。)</font>
					        <div align="right"></div></td>
					    </tr>
					   
					    <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">产地：</div></td>
					      <td class=forumrow><input name="chandi" type="text" id="pname" size="25" maxlength="30"></td>
					      <td class=forumrow><div align="right">包装形式：</div></td>
					      <td class=forumrow><input name="baozhuang" type="text" id="pname" size="25" maxlength="30" /> </td>
					    </tr>
					   <tr  bgcolor=ffffff> 
					      <td class=forumrow><div align="right">有效成分：</div></td>
					      <td class=forumrow><input name="youxiaochf" type="text" id="pname" size="25" maxlength="30" /></td>
					      <td class=forumrow><div align="right">入库人：</div></td>
					      <td class=forumrow><input name="rukuren" type="text" id="pname" size="25" maxlength="30" value=杜云浩 /> </td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td rowspan="2" class=forumrow><div align="right">备注：</div></td>
					      <td colspan="3" class=forumrow><textarea name="beizhu" cols="70" rows="10" id="beizhu"></textarea></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td colspan="2" class=forumrow>&nbsp;</td>
					      <td class=forumrow><a href="javascript:change(document.all.beizhu,-50)"><img src="Image/minus.gif" alt="缩小文本框" width="20" height="20" border="0" /></a> 
					        <a href="javascript:change(document.all.beizhu,50)"><img src="Image/plus.gif" alt="放大文本框" width="20" height="20" border="0" /></a></td>
					    </tr>
					    <tr  bgcolor=ffffff> 
					      <td colspan="4" align="center" class=forumrow> <input type="submit" name="Submit" value="添 加" /> 
					        <input type="reset" name="Submit2" value="清 空" /></td>
					    </tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	  <script type="text/javascript">
	  </script>
	</body>
</html>