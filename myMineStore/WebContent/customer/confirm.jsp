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
      <li><a href=customerRegister.jsp><span>ע��</span></a></li>
        <li><a href=customer/login.jsp><span>��¼</span></a></li>
        <li>
				<a href="../mycart.jsp"><span>�ҵĹ��ﳵ</span> </a>
		</li>
		<li>
			<a href="loginSuccess.jsp"><span>myMine</span> </a>
		</li>
       </ul>
    </div>

    <div id="tabs5"
			style="position: absolute; top: 9%; left: 15%; height: 80%; width: 71%">
	<center>
		<h1>���ɶ���</h1>
	</center>	
	  <%
			Customer customer = (Customer) session.getAttribute("customer");
			if(customer!=null){
			
		%>
		<form name="orderDetail" action="../InsertOrderCtrl" method="post">
			<table align="center">
				<tr>
					<td>
						�ͻ���ַ��
					</td>
					<td>
						<input type="text" size=70 name="address"
							value=<%=customer.getCustomerAddr()%>>
					</td>
				</tr>
				<tr>
					<td>
						�ʱ�:
					</td>
					<td>
						<input type="text" name="post"
							value=<%=customer.getCustomerPost()%>>
					</td>
				</tr>
				<tr>
					<td>
						�ջ���������
					</td>
					<td>
						<input type="text" name="recipient" value=<%=customer.getCustomerName()%>>
					</td>
				</tr>
				<tr>
					<td>
						��ϵ�绰��
					</td>
					<td>
						<input type="text" name="phone"
							value=<%=customer.getCustomerPhone()%>>
					</td>

				</tr>
				<tr>
					<td>
						<input type="submit" value="ȷ�϶���">
					</td>
					<td>
						<input type="button" value="���ص����ﳵ" onclick="window.location.href='../mycart.jsp'" />
					</td>
				</tr>
			</table>
		</form>
		<%
			}else{				
				out.print("���ȵ�¼��");
				response.setHeader("refresh","1;url=login.jsp");
			}
		 %>
    	
    </div>
     </body>
</html>