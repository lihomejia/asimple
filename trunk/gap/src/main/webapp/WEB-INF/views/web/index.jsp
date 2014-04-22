<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>GAP</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>public/css/reset.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>public/css/style.css" />
</head>

<body>
<%@include file="/public/jsp/web/top.jsp" %>
<!--二级导航-->
<!--内容菜单-->
<table border="0" cellspacing="0" cellpadding="0" class="mCenter w960 mt10">
  <tr>
    <td width="210" align="left" valign="top"><!--产品认证-->
      <table border="0" cellspacing="0" cellpadding="0" class="leftMenu">
        <tr>
          <td class="titleBar"><span class="title">产品认证</span></td>
        </tr>
        <tr>
          <td class="p10"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td>
              <!--轮换图-->
				<div class="qych01_lft">
				<div class="focuspic">
				<div id="focusPic">
				<div id="focusPic_pic"><a href="#"><img src="<%=basePath%>public/images/spacer.gif" /></a></div>
				<div id="focusPic_txt"><span><a href="#"></a></span></div>
				<div id="count"></div>
				</div>
				<script type="text/javascript">
					/* 轮滚速度 */
					var pauseTime=4*1000;
					//定义图片宽度和高度
					var pic_width=170;
					var pic_height=170;
					var txt_lineHeight=30;
					//定义图片地址、链接地址和文字介绍，请用“|”隔开
					var pics='<%=basePath%>public/images/ggdm111.jpg|<%=basePath%>public/images/ggdm112.jpg|<%=basePath%>public/images/ggdm113.jpg|<%=basePath%>public/images/ggdm114.jpg|<%=basePath%>public/images/ggdm115.jpg|<%=basePath%>public/images/ggdm116.jpg'; //*播放图片位置，需要设置，请用"|"隔开
					var texts='|||||';//*flash中图片下方显示的文字信息，请用"|"隔开
					var links='#|#|#|#|#|#';//*播放图片连接位置，需要设置，请用"|"隔开,如需要使用"&"符号请用"@"代替；
					var tagImg = document.getElementById("focusPic").getElementsByTagName("img");
					var tagA = document.getElementById("focusPic").getElementsByTagName("a");
					var tagA2 = document.getElementById("count").getElementsByTagName("a");
					var getTXT = document.getElementById("focusPic_txt");
					var countContent="";
					//初始化操作
					var getPics = pics.split("|");
					var getLinks = links.split("|");
					var getTexts = texts.split("|");
					tagImg[0].style.width=pic_width+"px";
					tagImg[0].style.height=pic_height+"px";
					getTXT.style.lineHeight=txt_lineHeight+"px";
					
					for(i=0;i<getPics.length;i++){
						countContent=countContent+"<a onclick='javascript:change_pic("+i+"); return false;' href='#'>"+(i+1)+"</a>";
					}
					document.getElementById("count").innerHTML = countContent;
					function change_pic(x){
						//替换图片
						tagImg[0].src = getPics[x];
						//替换链接
						for(i=0;i<tagA.length;i++){
							tagA[i].href = getLinks[x];
							tagA[i].target = "_blank";
						}
						//替换描述
						tagA[1].innerHTML = getTexts[x];
						//更改样式
						for(i=0;i<tagA2.length;i++){
							tagA2[i].style.background="url(<%=basePath%>public/images/focuspic_n111.gif) center bottom no-repeat";
							tagA2[i].style.color="#fff";
							tagA2[i].style.textDecoration="none";
						}
						tagA2[x].style.background="url(<%=basePath%>public/images/focuspic_n112.gif) center bottom no-repeat";
						tagA2[x].style.color="#fff";
					}
					function doChange(){
						change_pic(k%getPics.length);
						k++;
						setTimeout("doChange()",pauseTime);
					}
					var k=0;
					doChange();
				</script>
				</div> 
              </td>
            </tr>
          </table></td>
        </tr>
      </table>
      <!--通知公告-->
      <table border="0" cellspacing="0" cellpadding="0" class="leftMenu mt10">
        <tr>
          <td class="titleBar"><span class="title">通知公告</span></td>
          <td align="right" class="titleBar"><a href="<%=basePath%>web/info/list.html?type=TZGG" target="_blank">[更多]</a>&nbsp;</td>
        </tr>
        <tr>
          <td colspan="2" align="left" valign="top" class="p10" style="height:182px;">
		  <MARQUEE  direction="up" HEIGHT="170" WIDTH="170" VSPACE="2" scrollAmount="2" ONMOUSEOUT=this.start() ONMOUSEOVER=this.stop()>
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="font12Blue">
		  	<c:forEach items="${TZGG}" var="info">
		  		<tr>
                	<td width="10" height="26" align="left" class="font12Blue_B">·</td>
                	<td height="26" colspan="2" align="left"><a href="<%=basePath%>web/info/detail.html?id=${info.id}" target="_blank">${info.title}</a></td>
              	</tr>
		  	</c:forEach>
          </table>
		  </MARQUEE>
		  </td>
        </tr>
      </table></td>
    <td align="left" valign="top"><!--质量追溯码-->
      <table border="0" cellspacing="0" cellpadding="0" class="centerMenu">
        <tr>
          <td class="titleBar"><span class="title">质量追溯查询</span></td>
        </tr>
        <tr>
          <td class="p10"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="qualitySearch">
              <tr>
                <td class="p10"><form id="form2" name="form2" method="post" action="<%=basePath%>product/query/doHtml5.html" target="_blank"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="19%" align="left" class="font12Blue_B">产品追溯码：</td>
                      <td width="65%" align="left"><input name="id" type="text" id="id" size="40" class="inputText" /></td>
                      <td width="16%" align="left"><input type="submit" id="btnQuery" value="查 询" class="btnStyle" /></td>
                    </tr>
                  </table>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="mt10">
                    <tr>
                      <td height="73"><input type="button" name="button4" id="button4" value=" " class="counterBtn1" /></td>
                      <td><input type="button" name="button5" id="button5" value=" " class="counterBtn2"/></td>
                      <td><input type="button" name="button6" id="button6" value=" " class="counterBtn3"/></td>
                      <td><input type="button" name="button7" id="button7" value=" " class="counterBtn4"/></td>
                      <td><input type="button" name="button8" id="button8" value=" " class="counterBtn5"/></td>
                      <td><input type="button" name="button9" id="button9" value=" " class="counterBtn6"/></td>
                    </tr>
                    <tr>
                      <td><input type="button" name="button15" id="button15" value=" " class="counterBtn7"/></td>
                      <td><input type="button" name="button14" id="button14" value=" " class="counterBtn8"/></td>
                      <td><input type="button" name="button13" id="button13" value=" " class="counterBtn9"/></td>
                      <td><input type="button" name="button12" id="button12" value=" " class="counterBtn0"/></td>
                      <td><input type="button" name="button11" id="button11" value=" " class="counterBtn_clear"/></td>
                      <td><input type="button" name="button10" id="button10" value=" " class="counterBtn_quit"/></td>
                    </tr>
                  </table></form></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--企业信息化-->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="centerMenu mt10" style="width:100%;">
        <tr>
          <td class="titleBar"><span class="title">企业信息化</span></td>
          <td align="right" class="titleBar"><a href="<%=basePath%>web/info/list.html?type=QYXXH" target="_blank">[更多]</a>&nbsp;</td>
        </tr>
        <tr>
          <td colspan="2" valign="top" class="p10" style="height:182px;">
		   <MARQUEE  direction="up" HEIGHT="178" WIDTH="450" VSPACE="2" scrollAmount="2" ONMOUSEOUT=this.start() ONMOUSEOVER=this.stop()>
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="font12Blue">
		  	<c:forEach items="${QYXXH}" var="info">
		  		<tr>
	              <td width="8" height="26" align="left" class="font12Blue_B">·</td>
			      <td align="left"><a href="<%=basePath%>web/info/detail.html?id=${info.id}" target="_blank">${info.title}</a></td>
			      <td height="26" colspan="3" align="right" class="font12Gray">2013年05月15日</td>
			    </tr>
		    <tr>
		  	</c:forEach>
            </table>
			</MARQUEE>		  </td>
        </tr>
      </table></td>
    <td width="270" align="right" valign="top">
      <!--用户注册-->
      	<script type="text/javascript">
			function doLogin(flag) {
				var _form = document.form1;
				
				_form.action = '<%=basePath%>' + flag + '/login.html';
			}      	
      	</script>
		<table border="0" cellspacing="0" cellpadding="0" class="userReg">
        <tr>
          <td class="p10">
          	<form id="form1" name="form1" method="post" action="<%=basePath%>admin/login.html" target="_blank">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="23" colspan="2" align="left" class="title">用户登录</td>
                </tr>
                <tr>
                  <td width="30%" height="24" align="center">用户名:</td>
                  <td width="70%" height="24" align="left">
                  	<input name="userId" value="admin"/>
                  </td>
                </tr>
                <tr>
                  <td height="24" align="center">密&nbsp;&nbsp;&nbsp;码:</td>
                  <td height="24" align="left">
                  	<input type="password" name="passWord" value="admin"/>
                  </td>
                </tr>
                <tr>
                  <td height="30" colspan="2" align="center"><input type="submit" value="登 录" class="btnStyle" onclick="return doLogin('admin');"/>
                    <input type="submit" value="后台登录" class="btnStyle" onclick="return doLogin('backend');"/></td>
                </tr>
              </table>
            </form>
           </td>
        </tr>
      </table>
      <!--企业新闻-->
      <table border="0" cellspacing="0" cellpadding="0" class="rightMenu mt10">
        <tr>
          <td class="titleBar"><table width="97%" border="0" align="left" cellpadding="0" cellspacing="0">
            <tr>
              <td><span class="title">企业新闻</span></td>
              <td align="right"><a href="<%=basePath%>web/info/list.html?type=QYXW" target="_blank" class="font12White_B">[更多]</a>&nbsp;</td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td valign="top" class="p10" style="height:298px;">
		  <MARQUEE  direction="up" HEIGHT="290" WIDTH="230" VSPACE="2" scrollAmount="2" ONMOUSEOUT=this.start() ONMOUSEOVER=this.stop()>
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="font12Blue">
		  	<c:forEach items="${QYXW}" var="info">
		  		<tr>
	              	<td height="26" align="left" class="font12Blue_B">·</td>
			      	<td height="26" colspan="2" align="left"><a href="<%=basePath%>web/info/detail.html?id=${info.id}" target="_blank">${info.title}</a></td>
		    	</tr>
		  	</c:forEach>
            </table>
		  </MARQUEE>
		  </td>
        </tr>
    </table></td>
  </tr>
</table>
<!--底部-->
<%@include file="/public/jsp/web/bottom.jsp" %>
</body>
</html>