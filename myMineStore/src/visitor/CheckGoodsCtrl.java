package visitor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Goods;


public class CheckGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Goods goods=new Goods();
	GoodsServ goodsserv=new GoodsServ();
       
   
    public CheckGoodsCtrl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Goods> list=new ArrayList<Goods>();
		goods.setGoodsName(request.getParameter("keyword"));
		goods.setGoodsCategory(request.getParameter("goodsCategory"));
		list=goodsserv.checkGoods(goods);
		HttpSession session=request.getSession();
		session.setAttribute("goodsArrayList", list);
		response.sendRedirect("visitor.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
