<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link rel="stylesheet" href="../css/table.css" type="text/css">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/test.js"></script>
<title>Choose Plan</title>
</head>

<body>
	<jsp:include page="waiter-navigation.jsp"></jsp:include>
	<div>
		<div class="container">
			<form method="post"
				action="${pageContext.request.contextPath}/waiter/choosePlan.action">

				<table>
					<thead>
						<tr>
							<th>编号</th>
							<th>放映厅</th>
							<th>开始日期</th>
							<th>结束日期</th>
							<th>开始时间</th>
							<th>选择</th>
						</tr>
					</thead>
					<s:iterator value="screeningPlans" status="index">

						<tr>
							<td><s:property value="#index.index+1" /></td>

							<td><s:if test="hall1==true">&nbsp;&nbsp;一号厅</s:if> <s:if
									test="hall2==true">&nbsp;&nbsp;二号厅</s:if> <s:if
									test="hall3==true">&nbsp;&nbsp;三号厅</s:if></td>

							<td><s:property value="startDate" /></td>

							<td><s:property value="endDate" /></td>

							<td><s:property value="period1" /></td>

							<td><input type="checkBox" value="screeningPlanId"></td>
						</tr>
						<input type="hidden" name="screeningPlanId"
							value="<s:property value="id" />">
					</s:iterator>
				</table>
				<input type="hidden" name="activityName"
					value="<s:property value="activityName" />"> <input
					type="hidden" name="filmName"
					value="<s:property value="filmName" />"> <input
					type="hidden" name="answer1" value="<s:property value="answer1" />">
				<input type="hidden" name="answer2"
					value="<s:property value="answer2" />"> <input
					type="hidden" name="answer3" value="<s:property value="answer3" />">
				<input type="hidden" name="filmId"
					value="<s:property value="filmId" />"> <input type="hidden"
					name="question" value="<s:property value="question" />"> <input
					type="hidden" name="integral"
					value="<s:property value="integral" />"> <input
					type="submit" class="btn btn-primary btn-small" value="确定"
					onClick="return Alert('制定成功')">
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>