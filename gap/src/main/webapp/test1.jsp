<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@page import="org.apache.commons.dbcp.BasicDataSource"%>
<%@include file="/public/jsp/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<%@include file="/public/jsp/common.jsp"%>
	    <meta http-equiv="description" content="this is my page">
	    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	</head>
	
	<%
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setUrl("jdbc:mysql://127.12.45.129:3306/gap?useOldAliasMetadataBehavior=true&useUnicode=true&characterEncoding=utf-8");
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUsername("root");
	dataSource.setPassword("root");
	
	jdbcTemplate.setDataSource(dataSource);
	
	out.println(jdbcTemplate.queryForList("select * from t_production_cell"));
	%>

	<body>
		<input class="Wdate" onClick="WdatePicker()"/>
	</body>
</html>
