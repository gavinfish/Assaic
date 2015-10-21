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
			<div class="container" style="margin: 0 auto;">
				<form method="post" name="form1">

					<s:iterator value="screeningPlan" id="plan" status="st">
						<table class="myTable1" style="margin: 0 auto;">
							<tr>
								<td>编号：</td>
								<td><s:property value="id" /></td>
							</tr>
							<tr>
								<td>电影名：</td>
								<td><s:property value="filmName" /></td>
							</tr>
							<tr>
								<td>放映厅：</td>
								<td><s:if test="hall1==true">一号厅&nbsp;</s:if> <s:if
										test="hall2==true">二号厅&nbsp;</s:if> <s:if test="hall3==true">三号厅&nbsp;</s:if>
								</td>
							</tr>
							<tr>
								<td>座位数：</td>
								<td><s:property value="seat" /></td>
							</tr>
							<tr>
								<td>开始日期：</td>
								<td><s:property value="startDate" /></td>
							</tr>
							<tr>
								<td>结束日期：</td>
								<td><s:property value="endDate" /></td>
							</tr>
							<tr>
								<td>时间段：</td>
								<td><s:property value="period1" /></td>
							</tr>
							<tr>
								<td>票价：</td>
								<td><s:property value="price" /></td>
							</tr>
							<tr>
								<td>批复状态：</td>
								<td><s:if test="state=='not'">未批复</s:if></td>
							</tr>
							<tr>
								<td>评价：</td>
								<td><textarea name="comment"><s:property
											value="comment" /></textarea></td>
							</tr>
							<tr>
								<td><input type="submit" value="同意"
									class="btn btn-primary btn-small" onclick="agree()"></td>
								<td><input type="submit" value="不同意"
									class="btn btn-primary btn-small" onclick="disAgree()"></td>
							</tr>
						</table>
						<input type="hidden" name="filmName"
							value="<s:property value="filmName"/>">
						<input type="hidden" name="planId"
							value="<s:property value="id"/>">
						<script type="text/javascript">
	function agree(){
		form1.action="${pageContext.request.contextPath}/manager/replyPlan.action?Agree=true";
		form1.submit();
	}
	function disAgree(){
		form1.action="${pageContext.request.contextPath}/manager/replyPlan.action?Agree=false";
		form1.submit();
	}
</script>
						<div style="color: red">
							<s:fielderror />
						</div>
					</s:iterator>
				</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>
