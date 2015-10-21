<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>Confirm Order</title>
<link href="../css/table.css" rel="stylesheet" type="text/css">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
</head>

<body>
	<jsp:include page="waiter-navigation.jsp"></jsp:include>
	<div>
		<div class="container">
			<form method="post"
				action="${pageContext.request.contextPath}/waiter/choosePayType.action">
				<table>
					<tr>
						<td>支付方式：</td>
						<td><select name="payType">
								<option>无卡</option>
								<option>现金</option>
								<option>会员卡</option>
								<option>积分</option>
						</select></td>
					</tr>
					<tr>
						<td>账户名：</td>
						<td><input type="text" name="accountName"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password"></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-small" value="确认"></td>
					</tr>

				</table>
				<input type="hidden" name="memberId"
					value="<s:property value="member.id" />"> <input
					type="hidden" name="filmId" value="<s:property value="film.id" />">
				<input type="hidden" name="memberCardId"
					value="<s:property value="memberCard.id" />"> <input
					type="hidden" name="seatChosen"
					value="<s:property value="seatChosen" />"> <input
					type="hidden" name="totalMoney"
					value="<s:property value="totalMoney" />"> <input
					type="hidden" name="recordId"
					value="<s:property value="recordId" />">
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
