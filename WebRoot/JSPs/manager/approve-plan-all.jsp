<%@page import="com.cineplex.entity.ScreeningPlan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/table.css" rel="stylesheet" type="text/css">
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
						<a href="#">放映计划管理</a>
					</dt>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getUncheckedPlan.action">待批复</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/manager/getAppliedPlan.action">已批复</a>
					</dd>

				</dl>
			</div>

			<div class="container">
				<s:if test="screeningPlans==null||screeningPlans.size()<1">
					<p>没有待批复的计划</p>
					<input type="button" class="btn btn-primary btn-small"
						name="Submit" onclick="javascript:history.back(-1);" value="返回">

				</s:if>
				<s:else>
					<table class="myTable" style="margin: 0 auto;">
						<thead>
							<tr>
								<th>编号</th>
								<th>电影名</th>
								<th>详情</th>
							</tr>
						</thead>
						<%
					/*
						@SuppressWarnings("unchecked")
						List<ScreeningPlan> screeningPlans = (List<ScreeningPlan>) request
								.getAttribute("uncheckedPlan");
						int count = screeningPlans.size();
						for (int i = 0; i < count; i++) {
							ScreeningPlan screeningPlan = screeningPlans.get(i);
					 */
				%>
						<s:iterator value="screeningPlans" status="index">
							<form method="post"
								action="${pageContext.request.contextPath}/manager/getPlan.action">
								<tr>
									<td><s:property value="#index.index+1" /></td>
									<td><input type="hidden" name="planId"
										value="<s:property value="id"/>"> <s:property
											value="filmName" /></td>

									<td><input type="submit" value="前往"
										class="btn btn-primary btn-small"></td>
								</tr>
								<input type="hidden" name="filmName"
									value="<s:property value="filmName"/>">
							</form>
						</s:iterator>

					</table>
				</s:else>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>
