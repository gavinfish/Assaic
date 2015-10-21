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
	<jsp:include page="member-navigation.jsp"></jsp:include>


	<div>
		<div>

			<div class="wmenu">
				<dl>
					<dt class="plan">
						<a>我的足迹</a>
					</dt>
					<dd>
						<a
							href="${pageContext.request.contextPath}/user/getConsumption.action">消费记录</a>
					</dd>
					<dd>
						<a
							href="${pageContext.request.contextPath}/user/getRecharge.action">充值记录</a>
					</dd>
				</dl>
			</div>



			<div class="container">
				<s:if test="%{historyType=='consumption'}">
					<p class="myTitle">消费记录</p>
					<s:if test="consumptions==null||consumptions.size()<1">
						<p>没有消费记录</p>
						<input type="button" class="btn btn-primary btn-small"
							name="Submit" onclick="javascript:history.back(-1);" value="返回">

					</s:if>
					<s:else>
						<br>
						<table class="myTable1" style="margin: 0 auto;">
							<thead>
								<tr>
									<th>编号</th>
									<th>电影名</th>
									<th>类型</th>
									<th>日期</th>
									<th>金额</th>
								</tr>
							</thead>

							<s:iterator value="consumptions" status="index">
								<tr>
									<td><s:property value="#index.index+1" /></td>
									<td><s:property value="filmName" /></td>
									<td><s:if test="type=='1'">会员卡</s:if> <s:elseif
											test="type=='2'">积分</s:elseif> <s:elseif test="type=='4'">现金</s:elseif>
										<s:else></s:else></td>
									<td><s:property value="time" /></td>
									<td><s:property value="money" /></td>
								</tr>
							</s:iterator>
						</table>
					</s:else>
				</s:if>

				<s:if test="%{historyType=='recharge'}">
					<p class="myTitle">充值记录</p>
					<s:if test="recharges==null||recharges.size()<1">
						<p>没有充值记录</p>
						<input type="button" class="btn btn-primary btn-small"
							name="Submit" onclick="javascript:history.back(-1);" value="返回">

					</s:if>
					<s:else>
						<br>
						<table class="myTable1" style="margin: 0 auto;">
							<thead>
								<tr>
									<th>编号</th>
									<th>日期</th>
									<th>金额</th>
								</tr>
							</thead>

							<s:iterator value="recharges" status="index">
								<tr>
									<td><s:property value="#index.index+1" /></td>
									<td><s:property value="time" /></td>
									<td><s:property value="money" /></td>
								</tr>
							</s:iterator>
						</table>
					</s:else>
				</s:if>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>
