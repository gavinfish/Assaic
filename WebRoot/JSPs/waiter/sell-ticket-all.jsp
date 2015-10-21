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
<title>Sell Ticket</title>
</head>

<body>
	<jsp:include page="waiter-navigation.jsp"></jsp:include>
	<div>
		<div class="container">
			<p class="myTitle">请选择影片</p>
			<s:if test="films==null||films.size()<1">
				<p>该时段没有电影</p>
				<input type="button" class="btn btn-primary btn-small" name="Submit"
					onclick="javascript:history.back(-1);" value="返回">

			</s:if>
			<s:else>
				<table>
					<thead>
						<tr>
							<th>编号</th>
							<th>电影名</th>
							<th>类型</th>
							<th>介绍</th>
							<th>票价</th>
							<th>抢购</th>
						</tr>
					</thead>

					<s:iterator value="films" status="index">
						<form method="post"
							action="${pageContext.request.contextPath}/waiter/getFilmRecords.action">

							<tr>
								<td><s:property value="#index.index+1" /></td>

								<td><s:property value="name" /></td>

								<td><s:property value="type" /></td>

								<td><s:property value="description" /></td>

								<td><s:property value="price" /></td>

								<td><input type="submit" class="btn btn-primary btn-small"
									value="出售"></td>
							</tr>
							<input type="hidden" name="filmId"
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