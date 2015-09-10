package cart;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Cart;
import util.Goods;
import util.Item;
import visitor.GoodsServ;


public class AddToCartCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		Goods goods=new Goods();
		HttpSession session=request.getSession();
		CartServ cs=new CartServ();
		Cart cart=new Cart();
		//���ݴ��
//		String userName=java.net.URLDecoder.decode(Irequest.getParameter("userName"),"GBK");
//		String userName=new String(request.getParameter("userName").getBytes("ISO-8859-1"),"GBK"); 
		String userName=request.getParameter("userName");
		int quantity=Integer.valueOf(request.getParameter("quantity"));
		cart.setUserName(userName);
		Item item=new Item();
		goods.setGoodsId(request.getParameter("goodsId"));
		String goodsName = request.getParameter("goodsName");
//		System.out.println("ת��ǰ��"+goodsName);
		goodsName = java.net.URLDecoder.decode(goodsName,"GBK"); 
//		System.out.println("ת����:"+goodsName);
//		String goodsName=new String(request.getParameter("goodsName").getBytes("ISO-8859-1"),"GBK");
		goods.setGoodsName(goodsName);
//		goods.setGoodsName(request.getParameter("goodsName"));
		goods.setGoodsPrice(Float.valueOf(request.getParameter("goodsPrice")));
		item.setGoods(goods);
		item.setQuantity(quantity);
		cart.setItem(item);
		//���빺�ﳵ
		cs.addToCart(cart);
		//�޸���Ʒ���е�����
		GoodsServ gs=new GoodsServ();
		goods=gs.QueryGoodsDetail(goods);
		goods.setGoodsCount(goods.getGoodsCount()-quantity);
		
		session.setAttribute("cart", cart);
		response.sendRedirect("visitor.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
