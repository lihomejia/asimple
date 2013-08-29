<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品查询</title>

<style type="text/css">
table {
	width: 100%;
	font-size: 10pt;
}

.sub1 {
	padding: 5px 0 5px 11px;
	font-size: 11pt;
	font-weight: 900;
	background-color: #ddd;
	font-size: 11pt;
    text-shadow: 3px 3px 3px #FF0000;
}

.title {
	font-weight: 700;
	text-align: right;
	width: 70px;
	vertical-align: top;
}

.liner {
	height: 1px;
	background-color: #eee;
}
</style>
</head>
<body>
<%=request.getAttribute("content") %>
</body>
</html>