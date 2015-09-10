<%@ page language="java" import="java.util.*,util.*"
	pageEncoding="GBK"%>
<%@ page import="util.Goods" %>
<%@page contentType="text/html;charset=GBK"%>
<%
	request.setCharacterEncoding("GBK");
%>

<html>
<head>
		<link rel="stylesheet" type="text/css" href="css/daohang.css">
	</head>

	<body>
		<div id="tabs5"
			style="position: absolute; top: 1%; left: 15%; height: 8%; width: 71%">
			<ul>
				<li>
					<a href="customer/customerRegister.jsp"><span>我要注册</span> </a>
				</li>
				<li>
					<a href="mycart.jsp"><span>我的购物车</span> </a>
				</li>
				<li>
					<a href="index.jsp"><span>返回商城</span> </a>
				</li>
			</ul>
		</div>
		<div id="tabs5"
			style="position: absolute; top: 9%; left: 15%; height: 80%; width: 71%">
			<%
				ArrayList<Goods> goodsList = (ArrayList<Goods>) session.getAttribute("goodsArrayList");
			%>
			<form name="terms" action="./CheckGoodsCtrl" method="post">
				<table align="center" border="0">
					<tr>
						<td>
							<select size="1" name="select">
								<option value="goodsName" selected>
									商品
								</option>								
							</select>
						</td>
						<td>
							<input type="text" name="keyword">
						</td>
						<td>
							<select size="1" name="goodsCategory">
								<option value="all" selected>
									（请选择宝贝种类）
								</option>
								<option value="家用电器">
									家用电器
								</option>
								<option value="手机数码">
									手机数码
								</option>
								<option value="电脑产品">
									电脑产品
								</option>
								<option value="日用百货">
									日用百货
								</option>
							</select>
						</td>
						<td>
							<input type="submit" value="搜索">
						</td>
					</tr>

				</table>
			</form>
			<table border="0" cellspacing="1" width="90%">
				<tr>
					<th width="30%" align="center">
						图片
					</th>
					<th width="30%" align="center">
						商品名
					</th>
					<th width="30%" align="center">
						价格
					</th>

				</tr>
				<%
				for (Goods goods : goodsList) {
			%>
			<tr>
					<td width=30% align="center" valign="middle">
						<img src="<%=goods.getGoodsView()%>"  height="130" width="100">
					</td>
					<td width=10% align="center" valign="middle">
						<a href="QueryGoodsDetailCtrl?goodsId=<%=goods.getGoodsId()%>"><%=goods.getGoodsName()%></a>
					</td>
					<td width=30% align="center" valign="middle"><%=goods.getGoodsPrice()%></td>
				</tr>
				<%
				}
			%>
			</table>
			
		</div>
	</body>
</body>
</html>