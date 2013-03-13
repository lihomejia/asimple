<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/public/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
    <title>肥料库存</title>
    <style type="text/css">
    

    /*分页样式*/
	#divPage {
		text-align:left;
		margin:10px 0px;
		height:30px;
		font-size:12px;
	}	
	#divPage a, #divPage span {
		text-decoration:none;
		color:Blue;
		background-color:White;
		padding:3px 5px;
		font-family:Consolas;
		text-align:center;
		border:solid 1px #ddd;
		display:inline-block;
	}	
	#divPage span {
		color:gray;
	}		
	#divPage a:hover {
		color:Red;
	}
	#divPage .aCur {
		background-color:green;
		color:White;
		font-weight:bold;
	}
	</style>
    <script type="text/javascript">
    
    
    //js表格 生成表格代码
	//arrTh 表头信息
	//arrTr 数据
    var getTable = function(arrTh, arrTr){
    	var arrTab = [];
    	arrTab.push('<table style="width:100%" class="dataList">');
    	arrTab.push('<tr>');
    	
    	var dataIndexs = [];
		for(var i=0; i < arrTh.length; i++) {
			arrTab.push('<th style="width:', arrTh[i].width, ';">', arrTh[i].header, '</th>');
			dataIndexs.push(arrTh[i].dataIndex);
		}
		arrTab.push('</tr>');
		for(var i=0; i<arrTr.length; i++) {
			arrTab.push('<tr>');
			var trdata = arrTr[i];
			for(var j=0; j < dataIndexs.length; j++) {
				arrTab.push('<td>', trdata[dataIndexs[j]], '</td>');
			}
			arrTab.push('</tr>');
		}
		arrTab.push('</table>');
		return arrTab.join('');
	}
	
	//js分页
	//el:分页容器 count:总记录数 pageStep:每页显示多少个 pageNum:第几页 fnGo:分页跳转函数
    var jsPage = function(el, count, pageStep, pageNum, fnGo) {
		this.getLink = function(fnGo, pageNum, text) {
			return '<a href="#" onclick="return ' + fnGo + '(' + pageNum + ');">' + text + '</a>';
		}
		
		//总页数
		var pageNumAll = Math.ceil(count / pageStep);
		
		pageNum = Math.max(pageNum, 1);
		pageNum = Math.min(pageNum, pageNumAll);
		var pageBar = [];
		
		pageBar.push('[' + pageNum+'/'+pageNumAll+'页]');
		pageBar.push('[共' + count + '个]');
		
		if (pageNum > 1) {
			pageBar.push('[' + this.getLink(fnGo, 1, '首页') + ']');
			pageBar.push('[' + this.getLink(fnGo, pageNum-1, '上一页') + ']');
		} else {
			pageBar.push('<span>[首页]</span>');
			pageBar.push('<span>[上一页]</span>');
		}
		
		if (pageNum < pageNumAll) {
			pageBar.push('[' + this.getLink(fnGo, pageNum+1, '下一页') + ']');
			pageBar.push('[' + this.getLink(fnGo, pageNumAll, '尾页') + ']');
		} else {
			pageBar.push('<span>[下一页]</span>');
			pageBar.push('<span>[尾页]</span>');
		}
		pageBar.push('<input style="width:30px;" value="' + pageNum + '"/>');
		pageBar.push('<input type="button" value="Goto" style="cursor: pointer;"/>');
		var divPage = document.getElementById(el);
		divPage.innerHTML = '<div align="center">' + pageBar.join(' ') + '</div>';
    }
    </script>
</head>
<body>
<div id="divData"></div>
<div id="divPage"></div>
<script type="text/javascript">
	function goPage(pageIndex) {
		var arrTh = [{
			header : 'ID',
			dataIndex : 'mastockId',
			width : '10%'
		}, {
			header : '列2',
			dataIndex : 'mastockTotqty',
			width : '20%'
		}, {
			header : '列3',
			dataIndex : 'mastockUsedqty',
			width : '20%'
		}, {
			header : '列4',
			dataIndex : 'mastockBalqty',
			width : '30%'
		}];
		
		
		$.ajax({
			url : 'manure/stockQueryPage.do',
			data : {
				page : pageIndex
			},
			dataType : "json",
			success : function(data, textStatus) {
				
		
				document.getElementById('divData').innerHTML = getTable(arrTh, data.records);
				jsPage('divPage', data.total, 10, pageIndex, 'goPage');
			}
		});
		
		
		return false;
	}
	goPage(1);
</script>
</body>
</html>