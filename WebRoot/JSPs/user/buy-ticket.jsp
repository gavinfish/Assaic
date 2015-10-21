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
<title>Purchase Ticket</title>
</head>

<body>
	<jsp:include page="member-navigation.jsp"></jsp:include>
	<div>
		<div class="container">

			<p class="myTitle">请选择场次</p>
			<s:if test="filmRecords==null||filmRecords.size()<1">
				<p>暂时没有电影场次</p>
				<input type="button" class="btn btn-primary btn-small" name="Submit"
					onclick="javascript:history.back(-1);" value="返回">
			</s:if>
			<s:else>
				<table>
					<thead>
						<tr>
							<th>编号</th>
							<th>放映厅</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>日期</th>
							<th>选座</th>
						</tr>
					</thead>
					<s:iterator value="filmRecords" status="index">
						<form method="post"
							action="${pageContext.request.contextPath}/user/checkSeats.action">

							<tr>
								<td><s:property value="#index.index+1" /></td>

								<td><s:property value="hall" /></td>

								<td><s:property value="start" /></td>

								<td><s:property value="end" /></td>

								<td><s:property value="date" /></td>

								<td><input type="submit" class="btn btn-primary btn-small"
									value="前往"></td>
							</tr>
							<input type="hidden" name="recordId"
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
