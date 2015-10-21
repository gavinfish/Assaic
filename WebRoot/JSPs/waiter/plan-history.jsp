
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

			<div>
				<div class="container">
					<s:if test="screeningPlans==null||screeningPlans.size()<1">
						<p>没有已经批复的计划</p>
						<input type="button" class="btn btn-primary btn-small"
							name="Submit" onclick="javascript:history.back(-1);" value="返回">

					</s:if>
					<s:else>
						<p class="myTitle">通过的计划</p>
						<table class="myTable1" style="margin: 0 auto;">
							<thead>
								<tr>
									<th>编号</th>
									<th>电影名</th>
									<th>日期</th>
									<th>状态</th>
									<th>批复</th>
								</tr>
							</thead>

							<s:iterator value="screeningPlans" status="index">
								<tr>
									<td><s:property value="#index.index+1" /></td>
									<td><s:property value="filmName" /></td>
									<td><s:property value="startDate" /></td>
									<td><s:if test="state=='yes'">
									同意
								</s:if> <s:else>
									不同意
								</s:else></td>
									<td><s:property value="comment" /></td>
								</tr>

							</s:iterator>

						</table>
					</s:else>
				</div>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>



</body>

</html>
