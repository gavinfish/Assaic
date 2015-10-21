<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>Recharge</title>
<link href="../css/table.css" rel="stylesheet" type="text/css">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/test.js"></script>

</head>

<body>
	<jsp:include page="member-navigation.jsp"></jsp:include>
	<div>
		<div class="container">
			<p class="myTitle">会员卡充值</p>

			<form method="post"
				action="${pageContext.request.contextPath}/user/recharge.action?bankCardId=<s:property value="bankCardId" />&memberCardId=<s:property value="memberCardId" />">
				<table class="infoTable" style="width: 400px;">
					<tr>
						<td>账户名：</td>
						<td><s:property value="#session.account" /></td>
					</tr>
					<tr>
						<td>会员卡号：</td>
						<td><s:property value="memberCardId" /></td>
					</tr>
					<tr>
						<td>银行卡号：</td>
						<td><s:property value="bankCardId" /></td>
					</tr>
					<tr>
						<td>金额：</td>
						<td><input name="money" type="number" max="100000"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-small" value="充值"
							onClick="return Alert('充值成功')"></td>
					</tr>

				</table>

			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
