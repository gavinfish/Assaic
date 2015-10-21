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
<script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
<title>Assaic</title>

<script type="text/javascript">
$(function () {
	var m1 = ${monthPeople[11]};
	var m2 = ${monthPeople[10]};
	var m3 = ${monthPeople[9]};
	var m4 = ${monthPeople[8]};
	var m5 = ${monthPeople[7]};
	var m6 = ${monthPeople[6]};
	var m7 = ${monthPeople[5]};
	var m8 = ${monthPeople[4]};
	var m9 = ${monthPeople[3]};
	var m10 = ${monthPeople[2]};
	var m11 = ${monthPeople[1]};
	var m12 = ${monthPeople[0]};
        $('#container').highcharts({
            title: {
                text: 'Assaic最近一年人数',
                x: -20 //center
            },
            subtitle: {
            },
            xAxis: {
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
            },
            yAxis: {
                title: {
                    text: '人次'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '人次'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: 'People',
                data: [m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12]
            }]
        });
    });
    
</script>

<script type="text/javascript">
$(function () {
	var d1 = ${dayPeople[6]};
	var d2 = ${dayPeople[5]};
	var d3 = ${dayPeople[4]};
	var d4 = ${dayPeople[3]};
	var d5 = ${dayPeople[2]};
	var d6 = ${dayPeople[1]};
	var d7 = ${dayPeople[0]};
        $('#container1').highcharts({
            title: {
                text: 'Assaic最近一周人数',
                x: -20 //center
            },
            subtitle: {
            },
            xAxis: {
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                    'Jul']
            },
            yAxis: {
                title: {
                    text: '人次'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '人次'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: 'People',
                data: [d1, d2, d3, d4, d5, d6, d7]
            }]
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
				style="min-width: 310px; height: 200px; max-width: 600px; margin: 0 auto"></div>
			<div id="container1"
				style="min-width: 310px; height: 200px; max-width: 600px; margin: 0 auto"></div>
		</div>

	</div>
	<div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>