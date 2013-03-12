<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<script type="text/javascript">
	    	window.location.replace("homepage.html");
	    </script>
	    <meta http-equiv="refresh" content="0.1;url=homepage.do">
	    <meta http-equiv="description" content="this is my page">
	    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	</head>

	<body>
		
	</body>
</html>
