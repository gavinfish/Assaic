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
	var v1 = ${people[0]};
	var v2 = ${people[1]};
	var v3 = ${people[2]};
	var v4 = ${people[3]};
	var v5 = ${people[4]};
	var v6 = ${people[5]};
	var v7 = ${people[6]};
	var v8 = ${people[7]};
	var v9 = ${people[8]};
	var v10 = ${people[9]};
	var v11 = ${people[10]};
	var v12 = ${people[11]};
	var v13 = ${people[12]};
	var v14 = ${people[13]};
	var v15 = ${people[14]};
	var v16 = ${people[15]};
	var v17 = ${people[16]};
	var v18 = ${people[17]};
	var v19 = ${people[18]};
	var v20 = ${people[19]};
	var v21 = ${people[20]};
	var v22 = ${people[21]};
	var v23 = ${people[22]};
	var v24 = ${people[23]};
	var v25 = ${people[24]};
	var v26 = ${people[25]};
	var v27 = ${people[26]};
	var v28 = ${people[27]};
	var v29 = ${people[28]};
	var v30 = ${people[29]};
	var v31 = ${people[30]};
	var year = ${year};
	var month = ${month};
        $('#container').highcharts({
            title: {
                text: 'Assaic'+year+'年'+month+'月人数统计',
                x: -20 //center
            },
            subtitle: {
            },
            xAxis: {
                categories: []
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
                data: [v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31]
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
			<form
				action="${pageContext.request.contextPath}/manager/getMonthPeopleStatistic.action">
				<p class="myLabel" style="margin: 0 auto;">
					年份<select name="year">
						<option>2010</option>
						<option>2011</option>
						<option>2012</option>
						<option>2013</option>
						<option>2014</option>
						<option selected="selected">2015</option>
					</select> 月份<select name="month">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select> <input type="submit" value="查看" class="btn btn-primary btn-small">
				</p>
			</form>
			<br>
		</div>
		<div>
			<script src="../js/highcharts.js"></script>

			<div id="container"
				style="min-width: 310px; height: 200px; max-width: 700px; margin: 0 auto"></div>

		</div>

	</div>
	<div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>