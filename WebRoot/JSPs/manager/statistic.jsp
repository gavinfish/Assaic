<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/xt_css.css">

<title>Assaic</title>

<script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		var s = ${homeDistribution.get("上海")};
		var b = ${homeDistribution.get("北京")};
		var g = ${homeDistribution.get("广州")};
		var j = ${homeDistribution.get("江苏")};
		var q = ${homeDistribution.get("其他")};
		var z = ${homeDistribution.get("浙江")};
		$('#container')
				.highcharts(
						{
							chart : {
								plotBackgroundColor : null,
								plotBorderWidth : null,
								plotShadow : false,
								backgroundColor: 'rgba(255, 255, 255, 0)',
							},
							title : {
								text : '会员居住地统计情况'
							},
							tooltip : {
								pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
							},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										format : '<b>{point.name}</b>: {point.percentage:.1f} %',
										style : {
											color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
													|| 'green'
										}
									}
								}
							},
							series : [ {
								type : 'pie',
								name : '居住地分布',
								data : [ [ '北京', b ], [ '江苏', j ], {
									name : '广州',
									y : g,
									sliced : true,
									selected : true
								}, [ '上海', s ], [ '浙江', z ],
										[ '其他', q ] ]
							} ]
						});
	});
</script>
<script type="text/javascript">
$(function() {
	var m = ${genderDistribution.get("男")};
	var f = ${genderDistribution.get("女")};
	$('#container1')
			.highcharts(
					{
						chart : {
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false,
							backgroundColor: 'rgba(255, 255, 255, 0)',
						},
						title : {
							text : '会员性别统计情况'
						},
						tooltip : {
							pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
						},
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								dataLabels : {
									enabled : true,
									format : '<b>{point.name}</b>: {point.percentage:.1f} %',
									style : {
										color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
												|| 'green'
									}
								}
							}
						},
						series : [ {
							type : 'pie',
							name : '比例',
							data : [ [ '女', f ],{
								name : '男',
								y : m,
								sliced : true,
								selected : true
							} ]
						} ]
					});
});
</script>
<script type="text/javascript">
$(function() {
	var v1 = ${ageDistribution.get("18")};
	var v2 = ${ageDistribution.get("30")};
	var v3 = ${ageDistribution.get("50")};
	var v4 = ${ageDistribution.get("100")};
	$('#container2')
			.highcharts(
					{
						chart : {
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false,
							backgroundColor: 'rgba(255, 255, 255, 0)',
						},
						title : {
							text : '会员年龄统计情况'
						},
						tooltip : {
							pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
						},
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								dataLabels : {
									enabled : true,
									format : '<b>{point.name}</b>: {point.percentage:.1f} %',
									style : {
										color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
												|| 'green'
									}
								}
							}
						},
						series : [ {
							type : 'pie',
							name : '比例',
							data : [ [ '小于18岁', v1 ],{
								name : '18到30',
								y : v2,
								sliced : true,
								selected : true
							},['30到50', v3],['大于50',v4] ]
						} ]
					});
});
</script>
</head>

<body>
	<jsp:include page="manager-navigation.jsp"></jsp:include>

	<div style="margin: 50px auto auto;"></div>


	<div>
		<div class="wmenu">
			<dl>
				<dt class="plan">
					<a href="#">会员统计</a>
				</dt>
				<dd>
					<a href="${pageContext.request.contextPath}/manager/idle.action">基础信息</a>
				</dd>
				<dd>
					<a
						href="${pageContext.request.contextPath}/manager/getActivityStatistic.action">活动情况</a>
				</dd>
				<dd>
					<a
						href="${pageContext.request.contextPath}/manager/getMemberCardStatistic.action">会员卡状态</a>
				</dd>
			</dl>

			<dl>
				<dt class="plan">
					<a href="#">影院统计</a>
				</dt>
				<dd>
					<a
						href="${pageContext.request.contextPath}/manager/getPeopleStatistic.action">人数统计</a>
				</dd>
				<dd>
					<a
						href="${pageContext.request.contextPath}/manager/getHallAttendance.action">影厅上座率</a>
				</dd>
				<dd>
					<a
						href="${pageContext.request.contextPath}/manager/getFilmAttendance.action">电影上座率</a>
				</dd>
				<dd>
					<a
						href="${pageContext.request.contextPath}/manager/getMoneyStatistic.action">购票情况</a>
				</dd>
			</dl>

			<dl>
				<dt class="plan">
					<a href="#">自定义统计</a>
				</dt>
				<dd>
					<a
						href="${pageContext.request.contextPath}/manager/getMonthPeopleStatistic.action?year=2015&month=4">人数统计</a>
				</dd>
				<dd>
					<a
						href="${pageContext.request.contextPath}/manager/getMonthHallStatistic.action?year=2015&month=4">影厅上座率</a>
				</dd>
			</dl>
		</div>



		<div>
			<script src="../js/highcharts.js"></script>

			<div id="container"
				style="min-width: 310px; height: 300px; max-width: 600px; margin: 0 auto"></div>
			<div id="container1"
				style="min-width: 310px; height: 300px; max-width: 600px; margin: 0 auto"></div>
			<div id="container2"
				style="min-width: 310px; height: 300px; max-width: 600px; margin: 0 auto"></div>
		</div>
	</div>

	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<p style="visibility: hidden">什么鬼</p>
	<div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>





</body>

</html>
