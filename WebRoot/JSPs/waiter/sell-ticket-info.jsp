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
				action="${pageContext.request.contextPath}/waiter/sellTicket.action">
				<table>
					<tr>
						<td>账户名：</td>
						<td><s:property value="accountName" /></td>
					</tr>
					<tr>
						<td>电影名：</td>
						<td><s:property value="film.name" /></td>
					</tr>
					<tr>
						<td>时间：</td>
						<td><s:property value="filmRecord.start" /></td>
					</tr>
					<tr>
						<td>放映厅：</td>
						<td><s:property value="filmRecord.hall" /></td>
					</tr>
					<tr>
						<td>座位号：</td>
						<td><s:property value="seatChosen" /></td>
					</tr>
					<tr>
						<td>总费用：</td>
						<td><s:property value="totalMoney" /></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-small" value="确认支付"></td>
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
					value="<s:property value="recordId" />"> <input
					type="hidden" name="payType" value="<s:property value="payType" />">
				<input type="hidden" name="hall"
					value="<s:property value="filmRecord.hall" />">
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
