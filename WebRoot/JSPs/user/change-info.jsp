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
<title>Purchase Ticket</title>
</head>

<body>
	<jsp:include page="member-navigation.jsp"></jsp:include>
	<div>
		<div class="container">
			<p class="myTitle">修改信息</p>

			<form method="post"
				action="${pageContext.request.contextPath}/user/changeInfo.action">
				<table style="width: 50%; margin: 0 auto;">
					<tr>
						<td>账户名：</td>
						<td><input type="text"
							value="<s:property value="member.accountName"/>"
							disabled="disabled"></td>
					</tr>
					<tr>
						<td>银行卡号：</td>
						<td><input type="text"
							value="<s:property value="bankCard.id"/>" disabled="disabled"></td>
					</tr>
					<tr>
						<td>会员卡号：</td>
						<td><input type="text"
							value="<s:property value="memberCard.id"/>" disabled="disabled"></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="gender" class="gender"
							value="男" checked="checked" /> <label>男</label> <input
							type="radio" name="gender" class="gender" value="女" /> <label
							style="margin-right: 50px;">女</label></td>
					</tr>
					<tr>
						<td>生日：</td>
						<td><input name="birthday" type="date"
							value="<s:property value="birthday"/>"></td>
					</tr>
					<tr>
						<td>地址：</td>
						<td><select name="address">
								<option <s:if test="member.address=='上海'">selected=true</s:if>>上海</option>
								<option <s:if test="member.address=='江苏'">selected=true</s:if>>江苏</option>
								<option <s:if test="member.address=='北京'">selected=true</s:if>>北京</option>
								<option <s:if test="member.address=='广州'">selected=true</s:if>>广州</option>
								<option <s:if test="member.address=='浙江'">selected=true</s:if>>浙江</option>
								<option <s:if test="member.address=='其他'">selected=true</s:if>>其他</option>
						</select></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-small" value="修改"
							onClick="return Alert('修改成功')"></td>
					</tr>

				</table>
			</form>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
