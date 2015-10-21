<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">
<title>Assaic</title>
<style type="text/css">
/*<![CDATA[*/
.l, label {
	display: list-item;
	width: 30px;
	height: 30px;
	overflow: hidden
}

.l {
	background: url("../images/a3.jpg") no-repeat
}

a.n {
	background: url("../images/a1.jpg") no-repeat
}
</style>
</head>

<body>
	<jsp:include page="waiter-navigation.jsp"></jsp:include>
	<div>
		<form method="post"
			action="${pageContext.request.contextPath}/waiter/idle.action">

			<p class="myTitle">请选择座位</p>
			<div class="mySeat">
				<img src="../images/screen.png"> <br>
				<div>
					<p class="myLabel">
						<br> <img src="../images/a2.jpg">&nbsp;&nbsp;&nbsp;
						不可选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="../images/a3.jpg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						可选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="../images/a1.jpg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						已选
					</p>
				</div>
				<table class="seatTable">
					<tr>
						<td></td>
						<td>一</td>
						<td>二</td>
						<td>三</td>
						<td>四</td>
						<td>五</td>
						<td>六</td>
						<td>七</td>
						<td>八</td>
						<td>九</td>
						<td>十</td>
					</tr>

					<tr>
						<td>1</td>
						<td style="vertical-align: middle;"><s:if
								test="seats[0]=='0'">
								<label for="seat1" style="margin: 0 auto;"> <a
									href="#y1" id="x1" class="l" onclick="seat1.checked=true"></a>
									<a href="#x1" id="y1" class="n l" onclick="seat1.checked=false"></a>
									<input type="checkbox" id="seat1" name="seatChosen" value="1">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[1]=='0'">
								<label for="seat2" style="margin: 0 auto;"> <a
									href="#y2" id="x2" class="l" onclick="seat2.checked=true"></a>
									<a href="#x2" id="y2" class="n l" onclick="seat2.checked=false"></a>
									<input type="checkbox" id="seat2" name="seatChosen" value="2">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[2]=='0'">
								<label for="seat3" style="margin: 0 auto;"> <a
									href="#y3" id="x3" class="l" onclick="seat3.checked=true"></a>
									<a href="#x3" id="y3" class="n l" onclick="seat3.checked=false"></a>
									<input type="checkbox" id="seat3" name="seatChosen" value="3">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[3]=='0'">
								<label for="seat4" style="margin: 0 auto;"> <a
									href="#y4" id="x4" class="l" onclick="seat4.checked=true"></a>
									<a href="#x4" id="y4" class="n l" onclick="seat4.checked=false"></a>
									<input type="checkbox" id="seat4" name="seatChosen" value="4">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[4]=='0'">
								<label for="seat5" style="margin: 0 auto;"> <a
									href="#y5" id="x5" class="l" onclick="seat5.checked=true"></a>
									<a href="#x5" id="y5" class="n l" onclick="seat5.checked=false"></a>
									<input type="checkbox" id="seat5" name="seatChosen" value="5">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[5]=='0'">
								<label for="seat6" style="margin: 0 auto;"> <a
									href="#y6" id="x6" class="l" onclick="seat6.checked=true"></a>
									<a href="#x6" id="y6" class="n l" onclick="seat6.checked=false"></a>
									<input type="checkbox" id="seat6" name="seatChosen" value="6">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[6]=='0'">
								<label for="seat7" style="margin: 0 auto;"> <a
									href="#y7" id="x7" class="l" onclick="seat7.checked=true"></a>
									<a href="#x7" id="y7" class="n l" onclick="seat7.checked=false"></a>
									<input type="checkbox" id="seat7" name="seatChosen" value="7">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[7]=='0'">
								<label for="seat8" style="margin: 0 auto;"> <a
									href="#y8" id="x8" class="l" onclick="seat8.checked=true"></a>
									<a href="#x8" id="y8" class="n l" onclick="seat8.checked=false"></a>
									<input type="checkbox" id="seat8" name="seatChosen" value="8">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[8]=='0'">
								<label for="seat9" style="margin: 0 auto;"> <a
									href="#y9" id="x9" class="l" onclick="seat9.checked=true"></a>
									<a href="#x9" id="y9" class="n l" onclick="seat9.checked=false"></a>
									<input type="checkbox" id="seat9" name="seatChosen" value="9">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[9]=='0'">
								<label for="seat10" style="margin: 0 auto;"> <a
									href="#y10" id="x10" class="l" onclick="seat10.checked=true"></a>
									<a href="#x10" id="y10" class="n l"
									onclick="seat10.checked=false"></a> <input type="checkbox"
									id="seat10" name="seatChosen" value="10">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
					</tr>

					<tr>
						<td>2</td>
						<td style="vertical-align: middle;"><s:if
								test="seats[10]=='0'">
								<label for="seat11" style="margin: 0 auto;"> <a
									href="#y11" id="x11" class="l" onclick="seat11.checked=true"></a>
									<a href="#x11" id="y11" class="n l"
									onclick="seat11.checked=false"></a> <input type="checkbox"
									id="seat11" name="seatChosen" value="11">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[11]=='0'">
								<label for="seat12" style="margin: 0 auto;"> <a
									href="#y12" id="x12" class="l" onclick="seat12.checked=true"></a>
									<a href="#x12" id="y12" class="n l"
									onclick="seat12.checked=false"></a> <input type="checkbox"
									id="seat12" name="seatChosen" value="12">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[12]=='0'">
								<label for="seat13" style="margin: 0 auto;"> <a
									href="#y13" id="x13" class="l" onclick="seat13.checked=true"></a>
									<a href="#x13" id="y13" class="n l"
									onclick="seat13.checked=false"></a> <input type="checkbox"
									id="seat13" name="seatChosen" value="13">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[13]=='0'">
								<label for="seat14" style="margin: 0 auto;"> <a
									href="#y14" id="x14" class="l" onclick="seat14.checked=true"></a>
									<a href="#x14" id="y14" class="n l"
									onclick="seat14.checked=false"></a> <input type="checkbox"
									id="seat14" name="seatChosen" value="14">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[14]=='0'">
								<label for="seat15" style="margin: 0 auto;"> <a
									href="#y15" id="x15" class="l" onclick="seat15.checked=true"></a>
									<a href="#x15" id="y15" class="n l"
									onclick="seat15.checked=false"></a> <input type="checkbox"
									id="seat15" name="seatChosen" value="15">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[15]=='0'">
								<label for="seat16" style="margin: 0 auto;"> <a
									href="#y16" id="x16" class="l" onclick="seat16.checked=true"></a>
									<a href="#x16" id="y16" class="n l"
									onclick="seat16.checked=false"></a> <input type="checkbox"
									id="seat16" name="seatChosen" value="16">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[16]=='0'">
								<label for="seat17" style="margin: 0 auto;"> <a
									href="#y17" id="x17" class="l" onclick="seat17.checked=true"></a>
									<a href="#x17" id="y17" class="n l"
									onclick="seat17.checked=false"></a> <input type="checkbox"
									id="seat17" name="seatChosen" value="17">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[17]=='0'">
								<label for="seat18" style="margin: 0 auto;"> <a
									href="#y18" id="x18" class="l" onclick="seat18.checked=true"></a>
									<a href="#x18" id="y18" class="n l"
									onclick="seat18.checked=false"></a> <input type="checkbox"
									id="seat18" name="seatChosen" value="18">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[18]=='0'">
								<label for="seat19" style="margin: 0 auto;"> <a
									href="#y19" id="x19" class="l" onclick="seat19.checked=true"></a>
									<a href="#x19" id="y19" class="n l"
									onclick="seat19.checked=false"></a> <input type="checkbox"
									id="seat19" name="seatChosen" value="19">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[19]=='0'">
								<label for="seat20" style="margin: 0 auto;"> <a
									href="#y20" id="x20" class="l" onclick="seat20.checked=true"></a>
									<a href="#x20" id="y20" class="n l"
									onclick="seat20.checked=false"></a> <input type="checkbox"
									id="seat20" name="seatChosen" value="20">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
					</tr>

					<tr>
						<td>3</td>
						<td style="vertical-align: middle;"><s:if
								test="seats[20]=='0'">
								<label for="seat21" style="margin: 0 auto;"> <a
									href="#y21" id="x21" class="l" onclick="seat21.checked=true"></a>
									<a href="#x21" id="y21" class="n l"
									onclick="seat21.checked=false"></a> <input type="checkbox"
									id="seat21" name="seatChosen" value="21">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[21]=='0'">
								<label for="seat22" style="margin: 0 auto;"> <a
									href="#y22" id="x22" class="l" onclick="seat22.checked=true"></a>
									<a href="#x22" id="y22" class="n l"
									onclick="seat22.checked=false"></a> <input type="checkbox"
									id="seat22" name="seatChosen" value="22">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[22]=='0'">
								<label for="seat23" style="margin: 0 auto;"> <a
									href="#y23" id="x23" class="l" onclick="seat23.checked=true"></a>
									<a href="#x23" id="y23" class="n l"
									onclick="seat23.checked=false"></a> <input type="checkbox"
									id="seat23" name="seatChosen" value="23">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[23]=='0'">
								<label for="seat24" style="margin: 0 auto;"> <a
									href="#y24" id="x24" class="l" onclick="seat24.checked=true"></a>
									<a href="#x24" id="y24" class="n l"
									onclick="seat24.checked=false"></a> <input type="checkbox"
									id="seat24" name="seatChosen" value="24">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[24]=='0'">
								<label for="seat25" style="margin: 0 auto;"> <a
									href="#y25" id="x25" class="l" onclick="seat25.checked=true"></a>
									<a href="#x25" id="y25" class="n l"
									onclick="seat25.checked=false"></a> <input type="checkbox"
									id="seat25" name="seatChosen" value="25">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[25]=='0'">
								<label for="seat26" style="margin: 0 auto;"> <a
									href="#y26" id="x26" class="l" onclick="seat26.checked=true"></a>
									<a href="#x26" id="y26" class="n l"
									onclick="seat26.checked=false"></a> <input type="checkbox"
									id="seat26" name="seatChosen" value="26">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[26]=='0'">
								<label for="seat27" style="margin: 0 auto;"> <a
									href="#y27" id="x27" class="l" onclick="seat27.checked=true"></a>
									<a href="#x27" id="y27" class="n l"
									onclick="seat27.checked=false"></a> <input type="checkbox"
									id="seat27" name="seatChosen" value="27">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[27]=='0'">
								<label for="seat28" style="margin: 0 auto;"> <a
									href="#y28" id="x28" class="l" onclick="seat28.checked=true"></a>
									<a href="#x28" id="y28" class="n l"
									onclick="seat28.checked=false"></a> <input type="checkbox"
									id="seat28" name="seatChosen" value="28">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[28]=='0'">
								<label for="seat29" style="margin: 0 auto;"> <a
									href="#y29" id="x29" class="l" onclick="seat29.checked=true"></a>
									<a href="#x29" id="y29" class="n l"
									onclick="seat29.checked=false"></a> <input type="checkbox"
									id="seat29" name="seatChosen" value="29">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[29]=='0'">
								<label for="seat30" style="margin: 0 auto;"> <a
									href="#y30" id="x30" class="l" onclick="seat30.checked=true"></a>
									<a href="#x30" id="y30" class="n l"
									onclick="seat30.checked=false"></a> <input type="checkbox"
									id="seat30" name="seatChosen" value="30">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
					</tr>

					<tr>
						<td>4</td>
						<td style="vertical-align: middle;"><s:if
								test="seats[30]=='0'">
								<label for="seat31" style="margin: 0 auto;"> <a
									href="#y31" id="x31" class="l" onclick="seat31.checked=true"></a>
									<a href="#x31" id="y31" class="n l"
									onclick="seat31.checked=false"></a> <input type="checkbox"
									id="seat31" name="seatChosen" value="31">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[31]=='0'">
								<label for="seat32" style="margin: 0 auto;"> <a
									href="#y32" id="x32" class="l" onclick="seat32.checked=true"></a>
									<a href="#x32" id="y32" class="n l"
									onclick="seat32.checked=false"></a> <input type="checkbox"
									id="seat32" name="seatChosen" value="32">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[32]=='0'">
								<label for="seat33" style="margin: 0 auto;"> <a
									href="#y33" id="x33" class="l" onclick="seat33.checked=true"></a>
									<a href="#x33" id="y33" class="n l"
									onclick="seat33.checked=false"></a> <input type="checkbox"
									id="seat33" name="seatChosen" value="33">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[33]=='0'">
								<label for="seat34" style="margin: 0 auto;"> <a
									href="#y34" id="x34" class="l" onclick="seat34.checked=true"></a>
									<a href="#x34" id="y34" class="n l"
									onclick="seat34.checked=false"></a> <input type="checkbox"
									id="seat34" name="seatChosen" value="34">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[34]=='0'">
								<label for="seat35" style="margin: 0 auto;"> <a
									href="#y35" id="x35" class="l" onclick="seat35.checked=true"></a>
									<a href="#x35" id="y35" class="n l"
									onclick="seat35.checked=false"></a> <input type="checkbox"
									id="seat35" name="seatChosen" value="35">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[35]=='0'">
								<label for="seat36" style="margin: 0 auto;"> <a
									href="#y36" id="x36" class="l" onclick="seat36.checked=true"></a>
									<a href="#x36" id="y36" class="n l"
									onclick="seat36.checked=false"></a> <input type="checkbox"
									id="seat36" name="seatChosen" value="36">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[36]=='0'">
								<label for="seat37" style="margin: 0 auto;"> <a
									href="#y37" id="x37" class="l" onclick="seat37.checked=true"></a>
									<a href="#x37" id="y37" class="n l"
									onclick="seat37.checked=false"></a> <input type="checkbox"
									id="seat37" name="seatChosen" value="37">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[37]=='0'">
								<label for="seat38" style="margin: 0 auto;"> <a
									href="#y38" id="x38" class="l" onclick="seat38.checked=true"></a>
									<a href="#x38" id="y38" class="n l"
									onclick="seat38.checked=false"></a> <input type="checkbox"
									id="seat38" name="seatChosen" value="38">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[38]=='0'">
								<label for="seat39" style="margin: 0 auto;"> <a
									href="#y39" id="x39" class="l" onclick="seat39.checked=true"></a>
									<a href="#x39" id="y39" class="n l"
									onclick="seat39.checked=false"></a> <input type="checkbox"
									id="seat39" name="seatChosen" value="39">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[39]=='0'">
								<label for="seat40" style="margin: 0 auto;"> <a
									href="#y40" id="x40" class="l" onclick="seat40.checked=true"></a>
									<a href="#x40" id="y40" class="n l"
									onclick="seat40.checked=false"></a> <input type="checkbox"
									id="seat40" name="seatChosen" value="40">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
					</tr>

					<tr>
						<td>5</td>
						<td style="vertical-align: middle;"><s:if
								test="seats[40]=='0'">
								<label for="seat41" style="margin: 0 auto;"> <a
									href="#y41" id="x41" class="l" onclick="seat41.checked=true"></a>
									<a href="#x41" id="y41" class="n l"
									onclick="seat41.checked=false"></a> <input type="checkbox"
									id="seat41" name="seatChosen" value="41">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[41]=='0'">
								<label for="seat42" style="margin: 0 auto;"> <a
									href="#y42" id="x42" class="l" onclick="seat42.checked=true"></a>
									<a href="#x42" id="y42" class="n l"
									onclick="seat42.checked=false"></a> <input type="checkbox"
									id="seat42" name="seatChosen" value="42">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[42]=='0'">
								<label for="seat43" style="margin: 0 auto;"> <a
									href="#y43" id="x43" class="l" onclick="seat43.checked=true"></a>
									<a href="#x43" id="y43" class="n l"
									onclick="seat43.checked=false"></a> <input type="checkbox"
									id="seat43" name="seatChosen" value="43">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[43]=='0'">
								<label for="seat44" style="margin: 0 auto;"> <a
									href="#y44" id="x44" class="l" onclick="seat44.checked=true"></a>
									<a href="#x44" id="y44" class="n l"
									onclick="seat44.checked=false"></a> <input type="checkbox"
									id="seat44" name="seatChosen" value="44">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[44]=='0'">
								<label for="seat45" style="margin: 0 auto;"> <a
									href="#y45" id="x45" class="l" onclick="seat45.checked=true"></a>
									<a href="#x45" id="y45" class="n l"
									onclick="seat45.checked=false"></a> <input type="checkbox"
									id="seat45" name="seatChosen" value="45">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[45]=='0'">
								<label for="seat46" style="margin: 0 auto;"> <a
									href="#y46" id="x46" class="l" onclick="seat46.checked=true"></a>
									<a href="#x46" id="y46" class="n l"
									onclick="seat46.checked=false"></a> <input type="checkbox"
									id="seat46" name="seatChosen" value="46">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[46]=='0'">
								<label for="seat47" style="margin: 0 auto;"> <a
									href="#y47" id="x47" class="l" onclick="seat47.checked=true"></a>
									<a href="#x47" id="y47" class="n l"
									onclick="seat47.checked=false"></a> <input type="checkbox"
									id="seat47" name="seatChosen" value="47">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[47]=='0'">
								<label for="seat48" style="margin: 0 auto;"> <a
									href="#y48" id="x48" class="l" onclick="seat48.checked=true"></a>
									<a href="#x48" id="y48" class="n l"
									onclick="seat48.checked=false"></a> <input type="checkbox"
									id="seat48" name="seatChosen" value="48">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[48]=='0'">
								<label for="seat49" style="margin: 0 auto;"> <a
									href="#y49" id="x49" class="l" onclick="seat49.checked=true"></a>
									<a href="#x49" id="y49" class="n l"
									onclick="seat49.checked=false"></a> <input type="checkbox"
									id="seat49" name="seatChosen" value="49">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[49]=='0'">
								<label for="seat50" style="margin: 0 auto;"> <a
									href="#y50" id="x50" class="l" onclick="seat50.checked=true"></a>
									<a href="#x50" id="y50" class="n l"
									onclick="seat50.checked=false"></a> <input type="checkbox"
									id="seat50" name="seatChosen" value="50">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
					</tr>

					<tr>
						<td>6</td>
						<td style="vertical-align: middle;"><s:if
								test="seats[50]=='0'">
								<label for="seat51" style="margin: 0 auto;"> <a
									href="#y51" id="x51" class="l" onclick="seat51.checked=true"></a>
									<a href="#x51" id="y51" class="n l"
									onclick="seat51.checked=false"></a> <input type="checkbox"
									id="seat51" name="seatChosen" value="51">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[51]=='0'">
								<label for="seat52" style="margin: 0 auto;"> <a
									href="#y52" id="x52" class="l" onclick="seat52.checked=true"></a>
									<a href="#x52" id="y52" class="n l"
									onclick="seat52.checked=false"></a> <input type="checkbox"
									id="seat52" name="seatChosen" value="52">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[52]=='0'">
								<label for="seat53" style="margin: 0 auto;"> <a
									href="#y53" id="x53" class="l" onclick="seat53.checked=true"></a>
									<a href="#x53" id="y53" class="n l"
									onclick="seat53.checked=false"></a> <input type="checkbox"
									id="seat53" name="seatChosen" value="53">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[53]=='0'">
								<label for="seat54" style="margin: 0 auto;"> <a
									href="#y54" id="x54" class="l" onclick="seat54.checked=true"></a>
									<a href="#x54" id="y54" class="n l"
									onclick="seat54.checked=false"></a> <input type="checkbox"
									id="seat54" name="seatChosen" value="54">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[54]=='0'">
								<label for="seat55" style="margin: 0 auto;"> <a
									href="#y55" id="x55" class="l" onclick="seat55.checked=true"></a>
									<a href="#x55" id="y55" class="n l"
									onclick="seat55.checked=false"></a> <input type="checkbox"
									id="seat55" name="seatChosen" value="55">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[55]=='0'">
								<label for="seat56" style="margin: 0 auto;"> <a
									href="#y56" id="x56" class="l" onclick="seat56.checked=true"></a>
									<a href="#x56" id="y56" class="n l"
									onclick="seat56.checked=false"></a> <input type="checkbox"
									id="seat56" name="seatChosen" value="56">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[56]=='0'">
								<label for="seat57" style="margin: 0 auto;"> <a
									href="#y57" id="x57" class="l" onclick="seat57.checked=true"></a>
									<a href="#x57" id="y57" class="n l"
									onclick="seat57.checked=false"></a> <input type="checkbox"
									id="seat57" name="seatChosen" value="57">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[57]=='0'">
								<label for="seat58" style="margin: 0 auto;"> <a
									href="#y58" id="x58" class="l" onclick="seat58.checked=true"></a>
									<a href="#x58" id="y58" class="n l"
									onclick="seat58.checked=false"></a> <input type="checkbox"
									id="seat58" name="seatChosen" value="58">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[58]=='0'">
								<label for="seat59" style="margin: 0 auto;"> <a
									href="#y59" id="x59" class="l" onclick="seat59.checked=true"></a>
									<a href="#x59" id="y59" class="n l"
									onclick="seat59.checked=false"></a> <input type="checkbox"
									id="seat59" name="seatChosen" value="59">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
						<td style="vertical-align: middle;"><s:if
								test="seats[59]=='0'">
								<label for="seat60" style="margin: 0 auto;"> <a
									href="#y60" id="x60" class="l" onclick="seat60.checked=true"></a>
									<a href="#x60" id="y60" class="n l"
									onclick="seat60.checked=false"></a> <input type="checkbox"
									id="seat60" name="seatChosen" value="60">
								</label>
							</s:if>
							<s:else>
								<label style="margin: 0 auto;"><img
									src="../images/a2.jpg"></label>
							</s:else></td>
					</tr>
				</table>
				<br> <input type="submit" class="btn btn-primary btn-small"
					value="确定"> <input type="hidden" name="recordId"
					value="<s:property value="recordId" />">
			</div>

		</form>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
