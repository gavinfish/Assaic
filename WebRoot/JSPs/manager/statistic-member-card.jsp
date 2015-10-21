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
$(function () {
	var y = ${memberCardCondition.get("有效")};
	var t = ${memberCardCondition.get("停止")};
	var z = ${memberCardCondition.get("暂停")};
	var q = ${memberCardCondition.get("取消")};
        $('#container').highcharts({
            chart: {
                type: 'bar',
                backgroundColor: 'rgba(0,0,0,0)'
            },
            title: {
                text: '会员卡状态统计'
            },
            subtitle: {

            },
            xAxis: {
                categories: ['有效', '停止', '暂停', '取消'],
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '数量(张)',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            tooltip: {
                valueSuffix: ' 张'
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -40,
                y: 100,
                floating: true,
                borderWidth: 1,
                backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor || '#FFFFFF'),
                shadow: true
            },
            credits: {
                enabled: false
            },
            series: [{
                name: '现在',
                data: [y, t, z, q]
            }]
        });
    });
</script>

</head>

<body>
	<jsp:include page="manager-navigation.jsp"></jsp:include>

	<div style="margin: 50px auto auto;"></div>

	<div>
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
					style="min-width: 310px; max-width: 600px; height: 400px; margin: 0 auto"></div>
			</div>

		</div>
	</div>
	<div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>