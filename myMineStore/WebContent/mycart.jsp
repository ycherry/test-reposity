<%@ page language="java" import="java.util.*,util.*,cart.*"
	pageEncoding="GBK"%>
	<%@page contentType="text/html;charset=GBK"%>
<%
	request.setCharacterEncoding("GBK");
%>
<html>
	<head>
		<title>�ҵĹ��ﳵ</title>
		<link rel="stylesheet" type="text/css" href="css/daohang.css">
		
	</head>
	<body>
		<div id="tabs5"
			style="position: absolute; top: 0%; left: 15%; height: 80%; width: 71%">
			<img src="img/html/cheche.jpg" width="128" height="88">
			<font size="7" color="#0080ff"><strong>�ҵĹ��ﳵ</strong> </font>
		</div>
		<center>
			<div id="tabs5"
				style="position: absolute; top: 35%; left: 15%; height: 8%; width: 71%">				
					<table border="1" align="center" width="80%">
						<tr>							
							<th width="30%">
								��Ʒ����
							</th>
							<th width="10%">
								��Ʒ�۸�
							</th>
							<th width="10%">
								��Ʒ����
							</th>
							<th width="10%">
								С��
							</th>
							<th width="10%">
								ɾ����Ʒ
							</th>
							<th width="10%" >
							�޸�����
							</th>
						</tr>
					</table>					
						<%
//							ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
						Cart cart=(Cart)session.getAttribute("cart");
						CartServ cs=new CartServ();
						ArrayList<Item> item1=(ArrayList<Item>)cs.CartGoods(cart);
							double costPrice=0;															
     					if (item1 != null) {
							ArrayList<String> list=new ArrayList<String>();
							double m=0;						
							for (Item item : item1) {	
								costPrice+=item.getSubtotal();
									m+=item.getSubtotal();				
							%>					
					<form name="mycart" action="UpdateCartCtrl?goodsPrice=<%=item.getGoods().getGoodsPrice()%>" method="post" >
					<table align="center" border="0" width="80%">
						<tr>							
							<td width="30%"><a href="QueryGoodsDetailCtrl?goodsId=<%=item.getGoods().getGoodsId()%>"><%=item.getGoods().getGoodsName()%></a></td>
							<td width="10%"><%=item.getGoods().getGoodsPrice()%></td>
							<td width="10%"><input type="text" name="quantity" value="<%=item.getQuantity()%>" size="2" onblur="ctrl()"></td>
							<td width="10%"><%=item.getSubtotal()%></td>
							<td width="10%">							
								<input type="button" value="ɾ  ��" name="delete"
									onclick="dodelete();">
							</td>
							<td width="10%">
							<input type="hidden" value="<%=item.getGoods().getGoodsId()%>" name="goodsId">
							<input type="submit" value="��  ��" />								
							</td>
						</tr>
					</table>
					<script type="text/javascript">
			           function dodelete(){
				       var goodsId="<%=item.getGoods().getGoodsId()%>";
				       var rs=confirm("ȷ��ɾ��?");
				       if(rs){
					      window.location.href="DeleteItemCtrl?goodsId="+goodsId;
					    }
				       else
					     return;
				       }

				       
			        </script>	
					</form>			
					<%
							}%>
						<p align="right">�ܼۣ�<%=m %>	</p>										
				<br>
				<ul>					
					<li>
						<a href="#" onclick='javascript:empty()'><span>��չ��ﳵ</span> </a>
					</li>
					<li>
						<a href="QueryAllGoodsCtrl"><span>��������</span> </a>
					</li>
					<li>
						<a href="customer/confirm.jsp"><span>ȥ����</span> </a>
					</li>
				</ul>
					<script type="text/javascript">
			           function empty(){
				       var rs=confirm("ȷ��Ҫ��չ��ﳵ ?");
				       if(rs){
					      window.location.href="EmptyCartCtrl";
					    }
				       else
					     return;
				       }
			        </script>			
			<%
			}
			%>
			
			</div>					
		</center>
	</body>
</html>