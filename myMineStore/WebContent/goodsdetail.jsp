<%@ page language="java" import="util.*" pageEncoding="GBK"%>
<%@page contentType="text/html;charset=GBK"%>
<%
	request.setCharacterEncoding("GBK");
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/daohang.css">
	<%
	  Customer customer=(Customer)session.getAttribute("customer");	
	  String userName=customer.getCustomerName();
		Goods goods=(Goods)session.getAttribute("goodsDetail");
		  String goodsName=goods.getGoodsName();
		  double goodsPrice=goods.getGoodsPrice();
	    
	 %>
		<script  type="text/javascript" charset="GBK">  
		      function ajaxFunction()
		 		{
				  var	 userName ="<%=userName%>";
				  if(userName=="null"){
					  alert ("请先登录！ ");
					    return;
					  }
				 var goodsId = document.myForm.goodsId.value;				 
				 var quantity=document.myForm.quantity.value;
				 var goodsName="<%=goodsName%>";
				 goodsName= encodeURI(encodeURI(goodsName,"GBK"),"GBK"); 
				 var goodsPrice="<%=goodsPrice%>";
                 var url= "AddToCartCtrl?goodsId="+goodsId+"&quantity="+quantity+"&userName="+userName+"&goodsName="+goodsName+"&goodsPrice="+goodsPrice;
				 window.location.href=url;
		
		     }    
	</script>		
	<SCRIPT  src="js/bp.js"></SCRIPT>
	</head>
	<body>
	<%if(userName!=null){ %>
	<div><%=userName%>你好</div>
	<%} %>
		<div id="tabs5"
			style="position: absolute; top: 1%; left: 15%; height: 8%; width: 71%">
			<ul>
				<li>
					<a href="index.jsp"><span>顾客登录</span> </a>
				</li>
				<li>
					<a href="index.jsp"><span>商城首页</span> </a>
				</li>
				<li>
					<a href="#"><span>商品详情</span> </a>
				</li>
				<li>
					<a href="mycart.jsp"><span>我的购物车</span> </a>
				</li>
			</ul>
		</div>
		<div
			style="position: absolute; left: 5%; top: 10%; width: 15%; height: 90%">
		</div>
		<div
			style="position: absolute; left: 20%; top: 10%; width: 77%; height: 90%; background-color: snow">
			
			<form name="myForm">
				<table align="left">
					<tr>
						<td>
							商铺名称：<%=goods.getBusinessId() %>
						</td>
					</tr>
				</table>
				<br>
				<br>
				<div style="position: absolute; top: 15% %; left: 10%;"
					class=imglist_right id=mpd>
					<img src="<%=goods.getGoodsView()%>"
						onmousemove=javascript:slidebp(); id=mp style="CURSOR: pointer"
						onmouseout=javascript:closebp(); onclick="window.location.href='bigimg/<%=goods.getGoodsView()%>'"/>
				</div>
				<DIV id=bpd
					style="BORDER: #cccccc 1px solid; DISPLAY: none; OVERFLOW: hidden; WIDTH: 280px; POSITION: absolute; HEIGHT: 280px">
					<DIV id=bpd2 style="POSITION: absolute">
						<IFRAME
							style="Z-INDEX: -1; LEFT: 2px; WIDTH: 1000px; POSITION: absolute; TOP: 5px; HEIGHT: 1000px"
							src="javascript:false" frameBorder=0 scrolling=no></IFRAME>
						<IMG id=bp src="bigimg/<%=goods.getGoodsView()%>">
					</DIV>
				</DIV>
				<DIV id=vpd
					style="BORDER-RIGHT: #444444 1px solid; BORDER-TOP: #444444 1px solid; DISPLAY: none; OVERFLOW: hidden; BORDER-LEFT: #444444 1px solid; WIDTH: 90px; BORDER-BOTTOM: #444444 1px solid; POSITION: absolute; HEIGHT: 90px">
					<DIV id=vpd2 style="POSITION: absolute">
						<IMG onmousemove=javascript:slidebp(); id=vp
							style="CURSOR: pointer" onmouseout=javascript:closebp();
							src="<%=goods.getGoodsView()%>">
					</DIV>
				</DIV>
				<SCRIPT language=javascript>
gid = 37;
mp_pos = getAbsPoint(object("mpd"));
locateZoom();
</SCRIPT>
				<table align="center" border="0"
					style="position: absolute; top: 13% %; right: 30%; width: 25%; height: 65%;">
					<tr>
						<td>
							<input type="hidden" name="goodsId" value=<%=goods.getGoodsId()%> />
						</td>
					</tr>
					<tr>
						<td>
							商品名称：<%=goods.getGoodsName()%></td>
					</tr>
					<tr>
						<td>
							商品价格：<%=goods.getGoodsPrice()%></td>
					</tr>
					<tr>
						<td>
							商品类别：<%=goods.getGoodsCategory()%>
						</td>
					</tr>
					<tr>
						<td>
							商品描述：<%=goods.getGoodsDesc()%></td>
					</tr>
					<tr>
					<td>
						<input type="text" name="quantity" value="1" size="5"/>库存量<%=goods.getGoodsCount() %>
					</td>			
					</tr>
					<tr>					
						<td>
							<input type="button" name="username" value="加入购物车"
								onclick="ajaxFunction();">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
	</body>
</html>