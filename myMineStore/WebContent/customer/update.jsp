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
					<a href="../index.jsp"><span>�����̳�</span>
					</a>
				</li>
				<li>
					<a href="update.jsp"><span>�޸ĸ�����Ϣ</span>
					</a>
				</li>
				<li>
					<a href="../QueryCustomerOrderCtrl"><span>�ҵĶ�����Ϣ</span>
					</a>
				</li>
				<%
					Customer customer = (Customer) session.getAttribute("customer");
					Business business = (Business) session.getAttribute("business");
					
					
					if (business!= null) {
				%>
				<li>
					<a href="../QueryBusinessCtrl"><span>�ҵĵ���</span>
					</a>
				</li>
					<%
						} else {
					%>
				
				<li>
					<a href="../BusinessRegisterCtrl"><span>��Ҫ����</span>
					</a>
				</li>
				<%
					}
				%>
				
				<li>
					<a href="../LogoutCtrl"><span>�˳���¼</span>
					</a>
				</li>
			</ul>
		</div>

<div id="tabs5"
			style="position: absolute; top: 9%; left: 15%; height: 8%; width: 71%">
			<center>
				<br>
				<h1>
					�޸ĸ�����Ϣ
				</h1>
				<form method="post" name="update" action="../UpdateCustomerCtrl">
					<input type="hidden" name="action" value="update" />

					<table align="center" width="97%">
						<tr>
							<td width="20%">
								�û���:
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
								����:
							</td>
							<td>
								<input name="customerPass" size="20" type="password"
									value="<%=customer.getCustomerPass()%>" onblur="checkPass();">
								<span id="pass" class="view"></span>
							</td>
						</tr>
						<tr>
							<td>
								ȷ������:
							</td>
							<td>
								<input name="customerPass2" size="20" type="password"
									value="<%=customer.getCustomerPass()%>" onblur="checkPass2();">
								<span id="pass2" class="view"></span>
							</td>
						</tr>
						<tr>
							<td>
								�Ա�:
							</td>
							<td>
								<input type="radio" name="customerSex" value="True"
									<%if("True".equals(customer.getCustomerSex())){%> checked
									<%} %>>
								˧��
								<input type="radio" name="customerSex" value="False"
									<%if("False".equals(customer.getCustomerSex())){%> checked
									<%} %>>
								��Ů
							</td>
						</tr>
						<tr>
							<td>
								����:
							</td>
							<td>
								<input name="customerAge" size="5" type="text"
									value="<%=customer.getCustomerAge()%>" onblur="checkAge();">
								<span id="age" class="view"></span>
							</td>
						</tr>

						<tr>
							<td>
								�绰:
							</td>
							<td>
								<input name="customerPhone" type="text" id="phone" size="20"
									value="<%=customer.getCustomerPhone()%>" onblur="checkPhone();">
								<span id="phone" class="view"></span>
							</td>
						</tr>

						<tr>
							<td valign="top">
								��ַ:
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
								�ʱ�:
							</td>
							<td>
								<input type="text" name="customerPost"
									value="<%=customer.getCustomerPost()%>" onblur="checkPost();">
								<span id="post" class="view">��6λ���֣�</span>
							</td>
						</tr>
					</table>
					<br>
					<input name="updatesubmit" value="ȷ���޸�" type="submit">
				</form>
			</center>

		</div>
	</body>
</html>