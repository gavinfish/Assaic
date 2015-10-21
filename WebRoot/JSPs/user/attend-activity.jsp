<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="../css/table.css" rel="stylesheet" type="text/css">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/test.js"></script>
<title>Assaic</title>
</head>

<body>

	<jsp:include page="member-navigation.jsp"></jsp:include>

	<div>
		<div class="container">
			<form method="post"
				action="${pageContext.request.contextPath}/user/attendActivity.action">
				<p class="myTitle">参加活动</p>
				<br>
				<table class="infoTable">
					<tr>
						<td>问题</td>
						<td><s:property value="activity.question1" /></td>
					</tr>
					<tr>
						<td>答案</td>
						<td><select name="answerSelected">
								<option value="1"><s:property value="activity.options1" /></option>
								<option value="2"><s:property value="activity.options2" /></option>
								<option value="3"><s:property value="activity.options3" /></option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-small" value="提交"
							onClick="return Alert('投票成功，请等待结果')"></td>
					</tr>

				</table>

				<input type="hidden" name="activityId"
					value="<s:property value="activityId" />">

			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
