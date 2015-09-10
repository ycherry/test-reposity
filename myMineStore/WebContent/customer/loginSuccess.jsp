<%@ page language="java" import="util.*" pageEncoding="GBK"%>
<%@page contentType="text/html;charset=GBK"%>
<%@page import="cart.*" %>
<%@page import="java.util.*" %>
<%
	request.setCharacterEncoding("GBK");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/daohang.css">
</head>
<body>
<div id="tabs5" style="position: absolute; top: 1%; left: 15%; height: 8%; width:71%" >
    <ul> 
    <li><a href="#"><span> 欢迎你
    <%
      Customer customer=(Customer)session.getAttribute("customer");
      Cart cart=new Cart();
      cart.setUserName(customer.getCustomerName());
//      CartServ cs=new CartServ();
      session.setAttribute("cart", cart);
      
    %>
    <%=customer.getCustomerName()%></span></a></li>
    <li><a href="../QueryAllGoodsCtrl"><span>逛商城</span></a></li>
    <li><a href="../mycart.jsp"><span>我的购物车</span></a></li>	
		<li><a href="./update.jsp"><span>修改个人信息</span></a></li>
        <li><a href="../LogoutCtrl"><span>退出登录</span></a></li>
        </ul>
    </div>
    <div id="tabs5" style="position: absolute; top: 9%; left: 15%; height: 80%; width:71%" >
    <br>
    <br>
		<center>
		<h1><strong>个人信息</strong> </h1>
				<table align="center" width="97%">
					<tr>
						<td width="20%" align="right">
							用户名:
						</td>
						<td>
							<input id="userid" name="customerName"
								value="<%=customer.getCustomerName()%>" size="20"
								maxlength="20" type="text"	
								onblur="checkName();">
							<span id="name" class="view"></span>
						</td>
					</tr>

					
					<tr>
						<td width="20%" align="right">
							性别:
						</td>
						<td>
							<input type="radio" name="customerSex" value="True"<%if("True".equals(customer.getCustomerSex())){%> checked <%} %>>
							帅哥
							<input type="radio" name="customerSex" value="False" <%if("False".equals(customer.getCustomerSex())){%> checked <%} %>>
							美女
						</td>
					</tr>
					<tr>
							<td width="20%" align="right">
							年龄:
						</td>
						<td>
							<input name="customerAge" size="5" type="text"
								value="<%=customer.getCustomerAge()%>" onblur="checkAge();">
							<span id="age" class="view"></span>
						</td>
					</tr>

					<tr>
							<td width="20%" align="right">
							电话:
						</td>
						<td>
							<input name="customerPhone" type="text" id="phone" size="20"
								value="<%=customer.getCustomerPhone()%>" onblur="checkPhone();">
							<span id="phone" class="view"></span>
						</td>
					</tr>

					<tr>
						<td valign="top"	 width="20%" align="right">
							地址:
						</td>
						<td>
							<textarea name="customerAddr" cols="60" rows="5" id="addr"><%=customer.getCustomerAddr()%></textarea>
						</td>
					</tr>
					<tr>
							<td width="20%" align="right">
							email:
						</td>
						<td>
							<input type="text" name="customerEmail"
								value="<%=customer.getCustomerEmail()%>" onblur="checkEmail();">
							<span id="email" class="view"></span>
						</td>
					</tr>
					<tr>
							<td width="20%" align="right">
							邮编:
						</td>
						<td>
							<input type="text" name="customerPost"
								value="<%=customer.getCustomerPost()%>" onblur="checkPost();">
							<span id="post" class="view"></span>
						</td>
					</tr>
				</table>
		</center>
	 </div>
</body>
</html>