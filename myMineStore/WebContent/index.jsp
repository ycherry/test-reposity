<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="util.*" %>
<%
	request.setCharacterEncoding("GBK"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<div id="img" style="position: absolute;">
			<a href="mycart.jsp"> <img src="img/html/cheche.jpg" border="0"
					width="150" height="60"> </a>
		</div>
	<head>
		<link rel="stylesheet" type="text/css" href="css/daohang.css">
	</head>
	<body >
	<%
	 Customer customer=new Customer();
     session.setAttribute("customer", customer);
	%>		
		<div id="tabs5"
			style="position: absolute; top: 1%; left: 15%; height: 8%; width: 71%">
			<ul>
				<li>
					<a href="QueryAllGoodsCtrl"><span>商城商品</span> </a>
				</li>
				<li>
					<a href="customer/customerRegister.jsp"><span>顾客注册</span> </a>
				</li>
				<li>
					<a href="customer/login.jsp"><span>顾客登录</span> </a>
				</li>
				
			</ul>
		</div>

		<div
			style="position: absolute; left: 20%; top: 10%; width: 77%; height: 90%">

			<div
				style="position: absolute; left: 5%; top: 5%; width: 400px; height: 340px">
				<iframe height="320" width="400" marginheight="0" marginwidth="0"
					name="best" scrolling="no" src="img/html/best/best.htm"></iframe>
			</div>
			<div id="tabs5"
				style="position: absolute; right: 15%; top: 10%; width: 35%; height: 250px">
				<form name="form2" action="./CustomerLoginCtrl" method="post">
					<center>
						<ul>
							<li>
								<a href="#"><span>用户登录</span> </a>
							</li>
						</ul>
						<br>
						<br>
						<table border="0">
							<tr>
								<td>
									用户名:
								</td>
								<td>
									<input type="text" name="customerName">
								</td>
								<td></td>
							</tr>
							<tr>
								<td>
									密&nbsp;&nbsp;码:
								</td>
								<td>
									<input type="password" name="customerPass">
								</td>

							</tr>
							
							<tr>
								<td colspan="2" align="center">
									<input type="submit" name="submit" value="登录">
									<input type="reset" name="reset" value="重置" />
							</tr>
						</table>
					</center>
				</form>
			</div>
		</div>
	</body>
</html>