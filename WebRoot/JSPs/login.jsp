<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<title>Welcome Assaic</title>
</head>
<body>
	<p class="texto">Assaic</p>
	<div class="Registro">
		<form action="${pageContext.request.contextPath}/login/login.action"
			method="post">

			<span class="fontawesome-user"></span> <input type="text"
				name="account" required placeholder="******@**.com"
				autocomplete="off"> <span class="fontawesome-lock"></span> <input
				type="password" class="last" name="password" id="password" required
				placeholder="******" autocomplete="off"> <input
				type="submit" value="登录" title="Registra tu cuenta">
		</form>
	</div>

	<div>
		<a href="/cineplex/JSPs/register.jsp" class="register-hint">注册</a>
	</div>

</body>
</html>