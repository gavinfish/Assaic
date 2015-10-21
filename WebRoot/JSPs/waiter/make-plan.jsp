
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
<link href="../css/xt_css.css" rel="stylesheet" type="text/css">
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
							href="${pageContext.request.contextPath}/waiter/getAllFilmNames.action">
							制定计划</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/waiter/getUnpassedPlan.action">
							修改计划</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/waiter/getPassedPlan.action">
							计划历史</a>
					</dd>
				</dl>
			</div>
			<div class="container">
				<form
					action="${pageContext.request.contextPath}/waiter/makePlan.action"
					method="post">
					<p class="myTitle">制定计划</p>
					<table class="myTable" style="margin: 0 auto;">
						<tr>
							<td>放映厅</td>
							<td><label><input name="hall1" type="checkbox"
									value="true"> 一号放映厅 </label> <label><input name="hall2"
									type="checkbox" value="true"> 二号放映厅 </label> <label><input
									name="hall3" type="checkbox" value="true"> 三号放映厅 </label></td>
						</tr>
						<tr>
							<td>电影</td>
							<td><select id="filmSelected" name="filmSelected">
									<%
							@SuppressWarnings("unchecked")
							List<String> filmNames = (List<String>)request.getAttribute("filmNames");
							for(int i = 0; i < filmNames.size(); i++){
								out.print("<option>"+filmNames.get(i)+"</option>");
							}
						%>
							</select></td>
						</tr>
						<tr>
							<td>开始日期</td>
							<td><input id="inputDate" class="myInput inputDate"
								name="startDate" type="date"></td>
						</tr>

						<tr>
							<td>持续时间</td>
							<td><input name="lastDay" required type="number" min="1"></td>
						</tr>

						<tr>
							<td>开始时间</td>
							<td><input name="startTime" required type="time"></td>
						</tr>

						<tr>
							<td>价格(元)</td>
							<td><input name="price" required type="number" min="1"
								max="1000"></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="提交计划"
								class="btn btn-primary btn-small"></td>
						</tr>

					</table>
				</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
