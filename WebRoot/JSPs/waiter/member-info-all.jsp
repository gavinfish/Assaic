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

	<jsp:include page="waiter-navigation.jsp"></jsp:include>
	<div>
		<div class="container">
			<p class="myTitle">会员信息列表</p>
			<s:if test="members==null||members.size()<1">
				<p>没有会员信息</p>
				<input type="button" class="btn btn-primary btn-small" name="Submit"
					onclick="javascript:history.back(-1);" value="返回">

			</s:if>
			<s:else>
				<table style="width: 60%; margin: 0 auto;">
					<thead>
						<tr>
							<th>编号</th>
							<th>会员账号</th>
							<th>详细信息</th>
						</tr>
					</thead>
					<s:iterator value="members" status="index">
						<form method="post"
							action="${pageContext.request.contextPath}/waiter/getMemberInfo.action">
							<tr>
								<td><s:property value="#index.index+1" /></td>
								<td><s:property value="accountName" /></td>
								<td><input type="submit" class="btn btn-primary btn-small"
									value="前往"></td>
							</tr>
							<input type="hidden" name="memberId"
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
