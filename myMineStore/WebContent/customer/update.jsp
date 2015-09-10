<%@ page language="java" import="util.*" pageEncoding="GBK"%>
<%@page contentType="text/html;charset=GBK"%>
<%
	request.setCharacterEncoding("GBK");
%>
<html>
<head>
		<script src="../customerRegister.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/daohang.css">
	</head>

	<body>
		<div id="tabs5"
			style="position: absolute; top: 1%; left: 15%; height: 8%; width: 71%">
			<ul>
				<li>
					<a href="../index.jsp"><span>返回商城</span>
					</a>
				</li>
				<li>
					<a href="update.jsp"><span>修改个人信息</span>
					</a>
				</li>
				<li>
					<a href="../QueryCustomerOrderCtrl"><span>我的订单信息</span>
					</a>
				</li>
				<%
					Customer customer = (Customer) session.getAttribute("customer");
					Business business = (Business) session.getAttribute("business");
					
					
					if (business!= null) {
				%>
				<li>
					<a href="../QueryBusinessCtrl"><span>我的店铺</span>
					</a>
				</li>
					<%
						} else {
					%>
				
				<li>
					<a href="../BusinessRegisterCtrl"><span>我要开店</span>
					</a>
				</li>
				<%
					}
				%>
				
				<li>
					<a href="../LogoutCtrl"><span>退出登录</span>
					</a>
				</li>
			</ul>
		</div>

<div id="tabs5"
			style="position: absolute; top: 9%; left: 15%; height: 8%; width: 71%">
			<center>
				<br>
				<h1>
					修改个人信息
				</h1>
				<form method="post" name="update" action="../UpdateCustomerCtrl">
					<input type="hidden" name="action" value="update" />

					<table align="center" width="97%">
						<tr>
							<td width="20%">
								用户名:
							</td>
							<td>
								<input id="userid" name="customerName"
									value="<%=customer.getCustomerName()%>" size="20"
									maxlength="20" type="text" onblur="checkName();">
								<span id="name" class="view"></span>
							</td>
						</tr>

						<tr>
							<td>
								密码:
							</td>
							<td>
								<input name="customerPass" size="20" type="password"
									value="<%=customer.getCustomerPass()%>" onblur="checkPass();">
								<span id="pass" class="view"></span>
							</td>
						</tr>
						<tr>
							<td>
								确认密码:
							</td>
							<td>
								<input name="customerPass2" size="20" type="password"
									value="<%=customer.getCustomerPass()%>" onblur="checkPass2();">
								<span id="pass2" class="view"></span>
							</td>
						</tr>
						<tr>
							<td>
								性别:
							</td>
							<td>
								<input type="radio" name="customerSex" value="True"
									<%if("True".equals(customer.getCustomerSex())){%> checked
									<%} %>>
								帅哥
								<input type="radio" name="customerSex" value="False"
									<%if("False".equals(customer.getCustomerSex())){%> checked
									<%} %>>
								美女
							</td>
						</tr>
						<tr>
							<td>
								年龄:
							</td>
							<td>
								<input name="customerAge" size="5" type="text"
									value="<%=customer.getCustomerAge()%>" onblur="checkAge();">
								<span id="age" class="view"></span>
							</td>
						</tr>

						<tr>
							<td>
								电话:
							</td>
							<td>
								<input name="customerPhone" type="text" id="phone" size="20"
									value="<%=customer.getCustomerPhone()%>" onblur="checkPhone();">
								<span id="phone" class="view"></span>
							</td>
						</tr>

						<tr>
							<td valign="top">
								地址:
							</td>
							<td>
								<textarea name="customerAddr" cols="60" rows="5" id="addr"><%=customer.getCustomerAddr()%></textarea>
							</td>
						</tr>
						<tr>
							<td>
								email:
							</td>
							<td>
								<input type="text" name="customerEmail"
									value="<%=customer.getCustomerEmail()%>" onblur="checkEmail();">
								<span id="email" class="view"></span>
							</td>
						</tr>
						<tr>
							<td>
								邮编:
							</td>
							<td>
								<input type="text" name="customerPost"
									value="<%=customer.getCustomerPost()%>" onblur="checkPost();">
								<span id="post" class="view">（6位数字）</span>
							</td>
						</tr>
					</table>
					<br>
					<input name="updatesubmit" value="确认修改" type="submit">
				</form>
			</center>

		</div>
	</body>
</html>