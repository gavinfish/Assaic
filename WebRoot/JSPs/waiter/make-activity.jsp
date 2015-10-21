<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<link href="../css/table.css" rel="stylesheet" type="text/css">
<link href="../css/xt_css.css" rel="stylesheet" type="text/css">
<title>Assaic</title>
</head>

<body>
	<jsp:include page="waiter-navigation.jsp"></jsp:include>
	<div>
		<div class="container" style="margin: 0 auto;">
			<form method="post"
				action="${pageContext.request.contextPath}/waiter/makeActivity.action">
				<p class="myTitle">制定活动</p>
				<table class="myTable" style="margin: 0 auto;">
					<tr>
						<td>活动名称</td>
						<td><input type="text" required name="activityName"></td>
					</tr>
					<tr>
						<td>相关电影</td>
						<td><select name="filmName">
								<s:iterator value="films">
									<option><s:property value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td>问题</td>
						<td><input type="text" required name="question"></td>
					</tr>
					<tr>
						<td>答案一</td>
						<td><input type="text" required name="answer1"></td>
					</tr>
					<tr>
						<td>答案二</td>
						<td><input type="text" required name="answer2"></td>
					</tr>
					<tr>
						<td>答案三</td>
						<td><input type="text" required name="answer3"></td>
					</tr>
					<tr>
						<td>积分</td>
						<td><input type="number" required name="integral"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-small" value="选择匹配计划"></td>
					</tr>

				</table>
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
