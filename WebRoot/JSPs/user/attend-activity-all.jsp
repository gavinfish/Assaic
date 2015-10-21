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

<title>Assaic</title>
</head>

<body>

	<jsp:include page="member-navigation.jsp"></jsp:include>
	<div>
		<div class="container">

			<p class="myTitle">选择想参加的活动</p>
			<s:if test="activities==null||activities.size()<1">
				<p>暂时没有可以参加的活动</p>
				<input type="button" class="btn btn-primary btn-small" name="Submit"
					onclick="javascript:history.back(-1);" value="返回">

			</s:if>
			<s:else>
				<br>
				<table>
					<thead>
						<tr>
							<th>编号</th>
							<th>活动名称</th>
							<th>相关电影</th>
							<th>积分</th>
							<th>参与</th>
						</tr>
					</thead>
					<s:iterator value="activities" status="index">
						<form method="post"
							action="${pageContext.request.contextPath}/user/checkActivity.action">
							<tr>
								<td><s:property value="#index.index+1" /></td>
								<td><s:property value="name" /></td>
								<td><s:property value="filmName" /></td>
								<td><s:property value="integral" /></td>
								<td><input type="submit" class="btn btn-primary btn-small"
									value="前往"></td>
							</tr>
							<input type="hidden" name="activityId"
								value="<s:property value="id" />">
						</form>
					</s:iterator>
				</table>
			</s:else>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>

	</div>
</body>

</html>
