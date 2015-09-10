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


public class EmptyCartCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmptyCartCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		CartServ cs=new CartServ();

		Cart cart=(Cart)session.getAttribute("cart");
		Customer customer=(Customer)session.getAttribute("customer");
		cart.setUserName(customer.getCustomerName());
		int i=cs.emptyCart(cart);
		if(i!=0){
			response.sendRedirect("mycart.jsp");
		}
		else
			System.out.print("Çå¿Õ¹ºÎï³µÊ§°Ü£¡");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
