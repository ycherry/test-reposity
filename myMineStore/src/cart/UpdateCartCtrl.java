package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Cart;
import util.Customer;
import util.Goods;
import util.Item;


public class UpdateCartCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateCartCtrl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		CartServ cs=new CartServ();
		Goods goods=new Goods();
		Item item=new Item();
		//得到购物车对象
		Cart cart=(Cart)session.getAttribute("cart");
		Customer customer=(Customer)session.getAttribute("customer");
		String goodsId=request.getParameter("goodsId");
		int quantity=Integer.valueOf(request.getParameter("quantity"));
		double goodsPrice=Double.valueOf(request.getParameter("goodsPrice"));
		goods.setGoodsId(goodsId);
		goods.setGoodsPrice((float)goodsPrice);
		item.setGoods(goods);
		item.setQuantity(quantity);
		cart.setItem(item);
		cart.setUserName(customer.getCustomerName());
		int i=cs.update(cart);
		if(i!=0){
			response.sendRedirect("mycart.jsp");
		}
		else
			System.out.print("更新失败！");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
