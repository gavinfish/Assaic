<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/register.css" rel="stylesheet" type="text/css" />


<title>Register</title>
</head>
<body>
	<p class="texto">Assaic</p>

	<script type="text/javaScript">
function checkPasswords(){
	var pass1 = document.getElementById("password");
    var pass2 = document.getElementById("password1");

    if (pass1.value != pass2.value)
        pass1.setCustomValidity("两次输入的密码不匹配");
    else
        pass1.setCustomValidity("");
}
</script>

	<div class="Registro">
		<form
			action="${pageContext.request.contextPath}/login/register.action"
			method="post" onsubmit="return checkForm(this)">
			<label>账号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</label> &nbsp;<input class="myInput" name="account" type="email" required
				placeholder="******" autocomplete="off" /><br /> <label>密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</label> <input class="myInput" name="password" id="password" type="password"
				onchange="checkPasswords()" required placeholder="******"
				autocomplete="off" /><br /> <label>密码确认：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</label> <input class="myInput" name="password1" id="password1"
				type="password" onchange="checkPasswords()" required
				placeholder="******" autocomplete="off" /><br /> <label>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
				type="radio" name="gender" class="gender" value="男"
				checked="checked" /> <label>男</label> <input type="radio"
				name="gender" class="gender" value="女" /> <label
				style="margin-right: 50px;">女</label> <br /> <label>生日：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</label> &nbsp;<input name="birthday" type="date" class="myInput inputDate"
				id="inputDate" /><br /> <label>地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<select name="address" class="last">
				<option>江苏</option>
				<option>上海</option>
				<option>北京</option>
				<option>广州</option>
				<option>浙江</option>
				<option>其他</option>
			</select> <input type="submit" value="注册" />


		</form>
	</div>

	<div>
		<a href="/cineplex/JSPs/login.jsp" class="register-hint">登陆</a>
	</div>

</body>
</html>