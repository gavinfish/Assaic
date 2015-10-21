<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<title>Assaic</title>
</head>

<body>

	<header role="banner" class="blog">
		<div class="page-header">
			<h2 class="myTexto">
				<a class="myTexto" style="text-decoration: none;"
					href="${pageContext.request.contextPath}/waiter/errorBack.action">Assaic</a>
			</h2>
			<ul class="menu brackets">
				<li style="margin-left: 20px;"><a
					href="${pageContext.request.contextPath}/waiter/idle1.action">发布电影</a></li>
				<li><a
					href="${pageContext.request.contextPath}/waiter/getAllFilmNames.action">制定计划</a></li>
				<li><a
					href="${pageContext.request.contextPath}/waiter/getActiveFilmNames.action">制定活动</a></li>
				<li><a
					href="${pageContext.request.contextPath}/waiter/getAllFilms.action">售票</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/waiter/getAllMembers.action">会员信息</a></li>
			</ul>
			<a href="${pageContext.request.contextPath}/login/logOut.action"
				class="btn btn-primary btn-small logInOut"
				style="margin-left: auto;">注销</a>
		</div>
	</header>

</body>

</html>
