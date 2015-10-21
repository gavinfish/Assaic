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
<link rel="stylesheet" type="text/css" href="../css/xt_css.css">
<title>Purchase Ticket</title>
</head>

<body>
	<jsp:include page="waiter-navigation.jsp"></jsp:include>

	<div style="margin: 50px auto auto;"></div>

	<div>
		<div class="container2">
			<p class="myTitle">会员信息</p>
			<br>

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

			</table>

		</div>

		<div class="container2">
			<p class="myTitle">消费信息</p>
			<br>
			<s:if test="consumptions==null||consumptions.size()<1">
				<p>没有消费记录</p>

			</s:if>
			<s:else>
				<table class="myTable1" style="margin: 0 auto;">
					<thead>
						<tr>
							<th>编号</th>
							<th>电影名</th>
							<th>类型</th>
							<th>日期</th>
							<th>金额</th>
						</tr>
					</thead>

					<s:iterator value="consumptions" status="index">
						<tr>
							<td><s:property value="#index.index+1" /></td>
							<td><s:property value="filmName" /></td>
							<td><s:if test="type=='1'">会员卡</s:if> <s:elseif
									test="type=='2'">积分</s:elseif> <s:elseif test="type=='4'">现金</s:elseif>
								<s:else></s:else></td>
							<td><s:property value="time" /></td>
							<td><s:property value="money" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:else>
		</div>

		<div class="container2">
			<p class="myTitle">缴费信息</p>
			<br>
			<s:if test="recharges==null||recharges.size()<1">
				<p>没有交费记录</p>

			</s:if>
			<s:else>
				<table class="myTable1" style="margin: 0 auto;">
					<thead>
						<tr>
							<th>编号</th>
							<th>日期</th>
							<th>金额</th>
						</tr>
					</thead>

					<s:iterator value="recharges" status="index">
						<tr>
							<td><s:property value="#index.index+1" /></td>
							<td><s:property value="time" /></td>
							<td><s:property value="money" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:else>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>

</body>

</html>
