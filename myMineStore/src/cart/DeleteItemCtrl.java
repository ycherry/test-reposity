package cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Cart;
import util.Customer;
import util.Goods;
import util.Item;


public class DeleteItemCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteItemCtrl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		CartServ cs=new CartServ();
		Goods goods=new Goods();
		//得到购物车对象
		Cart cart=(Cart)session.getAttribute("cart");
		Customer customer=(Customer)session.getAttribute("customer");
//		ArrayList<Item> item=(ArrayList<Item>) cs.CartGoods(cart);
		String goodsId=request.getParameter("goodsId");
		goods.setGoodsId(goodsId);
		Item item=new Item();
		item.setGoods(goods);
		cart.setUserName(customer.getCustomerName());
		cart.setItem(item);
		int i=cs.delete(cart);
		if(i!=0){
			response.sendRedirect("mycart.jsp");
		}
		else
			System.out.println("删除失败！");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
