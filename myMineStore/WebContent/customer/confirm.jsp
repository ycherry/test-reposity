<%@ page language="java" import="util.*" pageEncoding="GBK"%>
<%@page contentType="text/html;charset=GBK"%>
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
      <li><a href=customerRegister.jsp><span>注册</span></a></li>
        <li><a href=customer/login.jsp><span>登录</span></a></li>
        <li>
				<a href="../mycart.jsp"><span>我的购物车</span> </a>
		</li>
		<li>
			<a href="loginSuccess.jsp"><span>myMine</span> </a>
		</li>
       </ul>
    </div>

    <div id="tabs5"
			style="position: absolute; top: 9%; left: 15%; height: 80%; width: 71%">
	<center>
		<h1>生成订单</h1>
	</center>	
	  <%
			Customer customer = (Customer) session.getAttribute("customer");
			if(customer!=null){
			
		%>
		<form name="orderDetail" action="../InsertOrderCtrl" method="post">
			<table align="center">
				<tr>
					<td>
						送货地址：
					</td>
					<td>
						<input type="text" size=70 name="address"
							value=<%=customer.getCustomerAddr()%>>
					</td>
				</tr>
				<tr>
					<td>
						邮编:
					</td>
					<td>
						<input type="text" name="post"
							value=<%=customer.getCustomerPost()%>>
					</td>
				</tr>
				<tr>
					<td>
						收货人姓名：
					</td>
					<td>
						<input type="text" name="recipient" value=<%=customer.getCustomerName()%>>
					</td>
				</tr>
				<tr>
					<td>
						联系电话：
					</td>
					<td>
						<input type="text" name="phone"
							value=<%=customer.getCustomerPhone()%>>
					</td>

				</tr>
				<tr>
					<td>
						<input type="submit" value="确认订单">
					</td>
					<td>
						<input type="button" value="返回到购物车" onclick="window.location.href='../mycart.jsp'" />
					</td>
				</tr>
			</table>
		</form>
		<%
			}else{				
				out.print("请先登录。");
				response.setHeader("refresh","1;url=login.jsp");
			}
		 %>
    	
    </div>
     </body>
</html>