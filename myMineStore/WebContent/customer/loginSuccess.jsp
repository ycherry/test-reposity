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
    <li><a href="#"><span> ��ӭ��
    <%
      Customer customer=(Customer)session.getAttribute("customer");
      Cart cart=new Cart();
      cart.setUserName(customer.getCustomerName());
//      CartServ cs=new CartServ();
      session.setAttribute("cart", cart);
      
    %>
    <%=customer.getCustomerName()%></span></a></li>
    <li><a href="../QueryAllGoodsCtrl"><span>���̳�</span></a></li>
    <li><a href="../mycart.jsp"><span>�ҵĹ��ﳵ</span></a></li>	
		<li><a href="./update.jsp"><span>�޸ĸ�����Ϣ</span></a></li>
        <li><a href="../LogoutCtrl"><span>�˳���¼</span></a></li>
        </ul>
    </div>
    <div id="tabs5" style="position: absolute; top: 9%; left: 15%; height: 80%; width:71%" >
    <br>
    <br>
		<center>
		<h1><strong>������Ϣ</strong> </h1>
				<table align="center" width="97%">
					<tr>
						<td width="20%" align="right">
							�û���:
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
							�Ա�:
						</td>
						<td>
							<input type="radio" name="customerSex" value="True"<%if("True".equals(customer.getCustomerSex())){%> checked <%} %>>
							˧��
							<input type="radio" name="customerSex" value="False" <%if("False".equals(customer.getCustomerSex())){%> checked <%} %>>
							��Ů
						</td>
					</tr>
					<tr>
							<td width="20%" align="right">
							����:
						</td>
						<td>
							<input name="customerAge" size="5" type="text"
								value="<%=customer.getCustomerAge()%>" onblur="checkAge();">
							<span id="age" class="view"></span>
						</td>
					</tr>

					<tr>
							<td width="20%" align="right">
							�绰:
						</td>
						<td>
							<input name="customerPhone" type="text" id="phone" size="20"
								value="<%=customer.getCustomerPhone()%>" onblur="checkPhone();">
							<span id="phone" class="view"></span>
						</td>
					</tr>

					<tr>
						<td valign="top"	 width="20%" align="right">
							��ַ:
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
							�ʱ�:
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