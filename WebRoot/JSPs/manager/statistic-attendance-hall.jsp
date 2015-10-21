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
	var h11 = ${hallAttendance.get("一号影厅")[6]};
	var h12 = ${hallAttendance.get("一号影厅")[5]};
	var h13 = ${hallAttendance.get("一号影厅")[4]};
	var h14 = ${hallAttendance.get("一号影厅")[3]};
	var h15 = ${hallAttendance.get("一号影厅")[2]};
	var h16 = ${hallAttendance.get("一号影厅")[1]};
	var h17 = ${hallAttendance.get("一号影厅")[0]};
	
	var h21 = ${hallAttendance.get("二号影厅")[6]};
	var h22 = ${hallAttendance.get("二号影厅")[5]};
	var h23 = ${hallAttendance.get("二号影厅")[4]};
	var h24 = ${hallAttendance.get("二号影厅")[3]};
	var h25 = ${hallAttendance.get("二号影厅")[2]};
	var h26 = ${hallAttendance.get("二号影厅")[1]};
	var h27 = ${hallAttendance.get("二号影厅")[0]};
	
	var h31 = ${hallAttendance.get("三号影厅")[6]};
	var h32 = ${hallAttendance.get("三号影厅")[5]};
	var h33 = ${hallAttendance.get("三号影厅")[4]};
	var h34 = ${hallAttendance.get("三号影厅")[3]};
	var h35 = ${hallAttendance.get("三号影厅")[2]};
	var h36 = ${hallAttendance.get("三号影厅")[1]};
	var h37 = ${hallAttendance.get("三号影厅")[0]};
        $('#container').highcharts({
            title: {
                text: '各影厅一周内上座率',
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
                    text: '上座率(%)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '°C'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '一号厅',
                data: [h11, h12, h13, h14, h15, h16, h17]
            },{
                name: '二号厅',
                data: [h21, h22, h23, h24, h25, h26, h27]
            },{
                name: '三号厅',
                data: [h31, h32, h33, h34, h35, h36, h37]
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
		</div>

	</div>
	<div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>