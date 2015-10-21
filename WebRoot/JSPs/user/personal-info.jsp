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
<title>Purchase Ticket</title>
</head>

<body>
	<jsp:include page="member-navigation.jsp"></jsp:include>
	<div>
		<div class="container">
			<p class="myTitle">个人信息</p>

			<form method="post"
				action="${pageContext.request.contextPath}/user/checkInfo.action">
				<table class="infoTable">
					<tr>
						<td>账户名：</td>
						<td><s:property value="member.accountName" /></td>
					</tr>
					<tr>
						<td>银行卡号：</td>
						<td><s:property value="bankCard.id" /></td>
					</tr>
					<tr>
						<td>会员卡号：</td>
						<td><s:property value="memberCard.id" /></td>
					</tr>
					<tr>
						<td>会员卡等级：</td>
						<td><s:property value="memberCard.level" /></td>
					</tr>
					<tr>
						<td>积分：</td>
						<td><s:property value="memberCard.integral" /></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><s:property value="member.gender" /></td>
					</tr>
					<tr>
						<td>生日：</td>
						<td><s:property value="member.birthday" /></td>
					</tr>
					<tr>
						<td>地址：</td>
						<td><s:property value="member.address" /></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-small" value="修改"></td>
					</tr>

				</table>
				<a
					href="${pageContext.request.contextPath}/user/unbind.action?memberCardId=<s:property value="memberCard.id"/>">解除绑定</a>

			</form>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</div>

</body>

</html>
