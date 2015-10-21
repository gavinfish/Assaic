<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<link href="../css/table.css" rel="stylesheet" type="text/css">

<link href="../css/xt_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/test.js"></script>

<title>Assaic</title>

</head>

<body>
	<jsp:include page="waiter-navigation.jsp"></jsp:include>

	<div>
		<div class="container" style="margin: 0 auto;">

			<form method="post"
				action="${pageContext.request.contextPath}/waiter/publishFilm.action">
				<p class="myTitle">发布电影</p>
				<table class="myTable" style="width: 300px; margin: 0 auto;">

					<tr>
						<td>电影名称：</td>
						<td><input type="text" required name="filmName"
							style="width: 130px; height: 25px"></td>
					</tr>

					<tr>
						<td>电影类型：</td>
						<td><select id="filmType" name="filmType"
							style="width: 132px; height: 22px">
								<option>爱情</option>
								<option>动作</option>
								<option>喜剧</option>
								<option>文艺</option>
								<option>科幻</option>
								<option>动画</option>
								<option>其他</option>
						</select></td>
					</tr>

					<tr>
						<td>电影描述：</td>
						<td><textarea name="description" required
								style="width: 184px; height: 72px"></textarea></td>
					</tr>

					<tr>
						<td>时间(分):</td>
						<td><input type="number" min="1" max="300" required
							name="length" style="width: 130px; height: 25px"></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-small" value="提交"
							onClick="return Alert('发布成功')"></td>
					</tr>

				</table>

			</form>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</div>

</body>

</html>
