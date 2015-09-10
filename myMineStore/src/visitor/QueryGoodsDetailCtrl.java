package visitor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Customer;
import util.Goods;

/**
 * Servlet implementation class QueryGoodsDetailCtrl
 */
public class QueryGoodsDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Goods goods=new Goods();
	Customer customer=new Customer();
	GoodsServ goodsserv=new GoodsServ();
       
   
    public QueryGoodsDetailCtrl() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		goods.setGoodsId((String)request.getParameter("goodsId"));	
//		System.out.println(goods.getGoodsId());
		goods=goodsserv.QueryGoodsDetail(goods);
		if(request.getParameter("name")!=null){
			customer.setCustomerName((String)request.getParameter("name"));
		}
		HttpSession session=request.getSession();
		session.setAttribute("goodsDetail", goods);
		response.sendRedirect("goodsdetail.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
