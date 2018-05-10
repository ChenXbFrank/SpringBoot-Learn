<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta charset="UTF-8">
<title>freemarker</title>
</head>
<body>
	<h1 th:inline="text">Hello freemarker</h1>
	<p>姓名：${name}</p>
	<p>年龄：${age}</p>
</body>
</html>