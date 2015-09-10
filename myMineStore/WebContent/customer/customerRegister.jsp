<%@ page language="java" pageEncoding="GBK"%>
<%@page contentType="text/html;charset=GBK"%>
<%
request.setCharacterEncoding("GBK");
%>
<html>
<head>
		<script src="customerRegister.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/daohang.css">

</head>
<body>
	<div id="tabs5"
			style="position: absolute; top: 1%; left: 15%; height: 8%; width: 71%">
			<ul>
				<li>
					<a href=customerRegister.jsp><span>顾客注册</span>
					</a>
				</li>
				<li>
					<a href=./login.jsp><span>顾客登录</span>
					</a>
				</li>
				<li>
					<a href=../index.jsp><span>返回首页</span>
					</a>
				</li>
			</ul>
		</div>
		<div id="tabs5"
			style="position: absolute; top: 9%; left: 15%; height: 8%; width: 71%">
			<center>
				<br>
				<h1>
					用户注册
				</h1>
				<form method="post" name="register" action="../CustomerRegisterCtrl">
					<input type="hidden" name="action" value="register" />

					<table class="tableborder" align="center" cellpadding="4"
						cellspacing="1" width="97%">
						<tr>
							<td width="20%">
								账号:
							</td>
							<td>
								<input id="userId" name="customerId" size="20" maxlength="20"
									type="text" >
								
							</td>
						</tr>
						<tr>
							<td width="20%">
								用户名:
							</td>
							<td>
								<input name="customerName" size="20" maxlength="20" type="text" 
								        onkeyup="ajaxFunction()" onblur="checkName();">
								        <span id="name" class="view">!</span>
							</td>
						<tr>

						<tr>
							<td>
								密码:
							</td>
							<td>
								<input name="customerPass" size="20" type="password"
									onblur="checkPass();">
								<span id="pass" class="view">!</span>
							</td>
						</tr>
						<tr>
							<td>
								确认密码:
							</td>
							<td class="altbg2">
								<input name="customerPass2" size="20" type="password"
									onblur="checkPass2();">
								<span id="pass2" class="view">!</span>
							</td>
						</tr>
						
							<td>
								性别:
							</td>
							<td>
								<input type="radio" name="customerSex" value="True">
								帅哥
								<input type="radio" name="customerSex" value="False" checked>
								美女
							</td>
						</tr>
						<tr>
							<td>
								年龄:
							</td>
							<td>
								<input name="customerAge" size="5" type="text"
									onblur="checkAge();">
								<span id="age" class="view"></span>
							</td>
						</tr>

						<tr>
							<td>
								电话:
							</td>
							<td>
								<input name="customerPhone" type="text" size="20"
									onblur="checkPhone();">
								<span id="phone" class="view"></span>
							</td>
						</tr>

						<tr>
							<td valign="top">
								地址:
							</td>
							<td>
								<textarea name="customerAddr" cols="60" rows="5"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								email:
							</td>
							<td>
								<input type="text" name="customerEmail" onblur="checkEmail();">
								<span id="email" class="view"></span>
							</td>
						</tr>
						<tr>
							<td>
								邮编:
							</td>
							<td>
								<input type="text" name="customerPost" onblur="checkPost();">
								<span id="post" class="view">（6位数字）</span>
							</td>
						</tr>
						<tr>
							<td></td>
							<td align="left">
								<input value="提交" type="submit">
								<input value="重置" type="reset">
							</td>
					</table>
				</form>
			</center>
		</div>
</body>
</html>