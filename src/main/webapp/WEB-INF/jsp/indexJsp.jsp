<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSP</title>
</head>
<body>
	<h1 th:inline="text">Hello JSP</h1>
	<p>姓名：${name}</p>
	<p>年龄：${age}</p>
</body>
</html>