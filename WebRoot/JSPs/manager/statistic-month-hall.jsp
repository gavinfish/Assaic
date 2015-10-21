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
	var v1 = ${hall1[0]};
	var v2 = ${hall1[1]};
	var v3 = ${hall1[2]};
	var v4 = ${hall1[3]};
	var v5 = ${hall1[4]};
	var v6 = ${hall1[5]};
	var v7 = ${hall1[6]};
	var v8 = ${hall1[7]};
	var v9 = ${hall1[8]};
	var v10 = ${hall1[9]};
	var v11 = ${hall1[10]};
	var v12 = ${hall1[11]};
	var v13 = ${hall1[12]};
	var v14 = ${hall1[13]};
	var v15 = ${hall1[14]};
	var v16 = ${hall1[15]};
	var v17 = ${hall1[16]};
	var v18 = ${hall1[17]};
	var v19 = ${hall1[18]};
	var v20 = ${hall1[19]};
	var v21 = ${hall1[20]};
	var v22 = ${hall1[21]};
	var v23 = ${hall1[22]};
	var v24 = ${hall1[23]};
	var v25 = ${hall1[24]};
	var v26 = ${hall1[25]};
	var v27 = ${hall1[26]};
	var v28 = ${hall1[27]};
	var v29 = ${hall1[28]};
	var v30 = ${hall1[29]};
	var v31 = ${hall1[30]};
	
	var a1 = ${hall2[0]};
	var a2 = ${hall2[1]};
	var a3 = ${hall2[2]};
	var a4 = ${hall2[3]};
	var a5 = ${hall2[4]};
	var a6 = ${hall2[5]};
	var a7 = ${hall2[6]};
	var a8 = ${hall2[7]};
	var a9 = ${hall2[8]};
	var a10 = ${hall2[9]};
	var a11 = ${hall2[10]};
	var a12 = ${hall2[11]};
	var a13 = ${hall2[12]};
	var a14 = ${hall2[13]};
	var a15 = ${hall2[14]};
	var a16 = ${hall2[15]};
	var a17 = ${hall2[16]};
	var a18 = ${hall2[17]};
	var a19 = ${hall2[18]};
	var a20 = ${hall2[19]};
	var a21 = ${hall2[20]};
	var a22 = ${hall2[21]};
	var a23 = ${hall2[22]};
	var a24 = ${hall2[23]};
	var a25 = ${hall2[24]};
	var a26 = ${hall2[25]};
	var a27 = ${hall2[26]};
	var a28 = ${hall2[27]};
	var a29 = ${hall2[28]};
	var a30 = ${hall2[29]};
	var a31 = ${hall2[30]};
	
	var b1 = ${hall3[0]};
	var b2 = ${hall3[1]};
	var b3 = ${hall3[2]};
	var b4 = ${hall3[3]};
	var b5 = ${hall3[4]};
	var b6 = ${hall3[5]};
	var b7 = ${hall3[6]};
	var b8 = ${hall3[7]};
	var b9 = ${hall3[8]};
	var b10 = ${hall3[9]};
	var b11 = ${hall3[10]};
	var b12 = ${hall3[11]};
	var b13 = ${hall3[12]};
	var b14 = ${hall3[13]};
	var b15 = ${hall3[14]};
	var b16 = ${hall3[15]};
	var b17 = ${hall3[16]};
	var b18 = ${hall3[17]};
	var b19 = ${hall3[18]};
	var b20 = ${hall3[19]};
	var b21 = ${hall3[20]};
	var b22 = ${hall3[21]};
	var b23 = ${hall3[22]};
	var b24 = ${hall3[23]};
	var b25 = ${hall3[24]};
	var b26 = ${hall3[25]};
	var b27 = ${hall3[26]};
	var b28 = ${hall3[27]};
	var b29 = ${hall3[28]};
	var b30 = ${hall3[29]};
	var b31 = ${hall3[30]};
	
	var year=${year};
	var month=${month};
        $('#container').highcharts({
            title: {
                text: 'Assaic'+year+'年'+month+'月各厅上座率',
                x: -20 //center
            },
            subtitle: {
            },
            xAxis: {
                categories: []
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
                valueSuffix: '%'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '一号厅',
                data: [v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31]
            },{
                name: '二号厅',
                data: [a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26,a27,a28,a29,a30,a31]
            },{
                name: '三号厅',
                data: [b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31]
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
				action="${pageContext.request.contextPath}/manager/getMonthHallStatistic.action">
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