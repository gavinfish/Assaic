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

<title>Assaic</title>
</head>

<body>
	<jsp:include page="manager-navigation.jsp"></jsp:include>

	<div>
		<div>

			<div class="wmenu">
				<dl>
					<dt class="plan">
						<a href="#">会员统计</a>
					</dt>
					<dd>
						<a href="${pageContext.request.contextPath}/manager/idle.action">基础信息</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getActivityStatistic.action">活动情况</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getMemberCardStatistic.action">会员卡状态</a>
					</dd>
				</dl>

				<dl>
					<dt class="plan">
						<a href="#">影院统计</a>
					</dt>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getPeopleStatistic.action">人数统计</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getHallAttendance.action">影厅上座率</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getFilmAttendance.action">电影上座率</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getMoneyStatistic.action">购票情况</a>
					</dd>
				</dl>

				<dl>
					<dt class="plan">
						<a href="#">自定义统计</a>
					</dt>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getMonthPeopleStatistic.action?year=2015&month=4">人数统计</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getMonthHallStatistic.action?year=2015&month=4">影厅上座率</a>
					</dd>
				</dl>
			</div>


			<div class="container">
				<table class="myTable" style="margin: 0 auto;">
					<thead>
						<tr>
							<th>购票类型</th>
							<th>数量</th>
							<th>总额</th>
						</tr>
					</thead>

					<tr>
						<td>卡购票</td>
						<td><s:property value="ticketCount[0]" /></td>
						<td><s:property value="ticketMoney[0]" /></td>
					</tr>
					<tr>
						<td>现金购票</td>
						<td><s:property value="ticketCount[1]" /></td>
						<td><s:property value="ticketMoney[1]" /></td>
					</tr>

				</table>
			</div>

		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>