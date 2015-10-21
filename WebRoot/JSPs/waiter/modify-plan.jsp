
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" type="text/css" href="../css/xt_css.css">

<title>Assaic</title>
</head>

<body>
	<jsp:include page="waiter-navigation.jsp"></jsp:include>
	<div>
		<div>
			<div class="wmenu">
				<dl>
					<dt class="plan">
						<a href="#">放映计划管理</a>
					</dt>
					<dd>
						<a
							href="${pageContext.request.contextPath}/waiter/getAllFilmNames.action">制定计划</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/waiter/getUnpassedPlan.action">修改计划</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/waiter/getPassedPlan.action">计划历史</a>
					</dd>

				</dl>
			</div>

			<div class="container">
				<form
					action="${pageContext.request.contextPath}/waiter/modifyPlan.action"
					method="post">
					<p class="myTitle">修改计划</p>
					<table class="myTable" style="margin: 0 auto;">
						<tr>
							<td>放映厅</td>
							<td><label> <input name="hall1" type="checkbox"
									value="true"
									<s:if test="screeningPlan.hall1==true">checked="true"</s:if>>一号放映厅
							</label> <label> <input name="hall2" type="checkbox" value="true"
									<s:if test="screeningPlan.hall2==true">checked="true"</s:if>>二号放映厅
							</label> <label> <input name="hall3" type="checkbox" value="true"
									<s:if test="screeningPlan.hall3==true">checked="true"</s:if>>三号放映厅
							</label></td>
						</tr>
						<tr>
							<td>电影名</td>
							<td><input disabled="disabled" name="filmName" type="text"
								value="<s:property value="filmName" />"></td>
						</tr>
						<tr>
							<td>开始日期</td>
							<td><input id="inputDate" class="myInput inputDate"
								name="startDate" type="date"
								value="<s:property value="startDate" />"></td>
						</tr>
						<tr>
							<td>持续天数</td>
							<td><input name="lastDay" type="text"
								value="<s:property value="lastDay" />"></td>
						</tr>
						<tr>
							<td>开始时间</td>
							<td><input name="startTime" type="time"
								value="<s:property value="screeningPlan.period1" />"></td>
						</tr>
						<tr>
							<td>价格(元)</td>
							<td><input name="price" type="text"
								value="<s:property value="screeningPlan.price" />"></td>
						</tr>
						<tr>
							<td>批复</td>
							<td><s:property value="screeningPlan.comment" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="提交计划"
								class="btn btn-primary btn-small"></td>
						</tr>
					</table>
					<input name="planId" type="hidden"
						value="<s:property value="planId" />"> <input
						name="filmName" type="hidden"
						value="<s:property value="filmName" />">
				</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>





</body>

</html>
