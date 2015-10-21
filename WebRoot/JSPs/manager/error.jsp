<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<title>Assaic</title>
</head>

<body>
	<jsp:include page="manager-navigation.jsp"></jsp:include>

	<div style="margin: 20px;"></div>

	<div>
		<p class="myTitle">出错啦！！！</p>
		<p>
			<s:property value="errorMessage" />
		</p>

		<form
			action="${pageContext.request.contextPath}/manager/errorBack.action">
			<input type="submit" class="btn btn-primary btn-small" value="返回">
		</form>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
