package customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import util.Customer;



@SuppressWarnings("serial")
public class CustomerLoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerServ customerserv = new CustomerServ(); 
   
    public CustomerLoginCtrl() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//从JSP中获得数据		
		String customerName = request.getParameter("customerName");
		String customerPass=request.getParameter("customerPass");
		//数据打包
				Customer customer = new Customer();
				customer.setCustomerName(customerName);
				customer.setCustomerPass(customerPass);
				Customer result = customerserv.login(customer);
				if(result.getCustomerId()!=null){
					session.setAttribute("customer", result);
					response.sendRedirect("customer/loginSuccess.jsp");
				}else{
					response.sendRedirect("customer/login.jsp");
					
					}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
