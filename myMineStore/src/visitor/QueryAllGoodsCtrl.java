package visitor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Goods;


public class QueryAllGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsServ goodsserv=new GoodsServ();
       
   
    public QueryAllGoodsCtrl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//数据打包
		ArrayList<Goods> list=new ArrayList<Goods>();
		list=goodsserv.queryAllGoods();
		HttpSession session=request.getSession();
		session.setAttribute("goodsArrayList", list);
		if(list.isEmpty()==false){
			response.sendRedirect("visitor.jsp");
		}
		else
			response.sendRedirect("index.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
