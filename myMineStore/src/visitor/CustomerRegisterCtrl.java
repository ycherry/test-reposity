package visitor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Customer;


public class CustomerRegisterCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VisitorServ visitorserv = new VisitorServ();
   
    public CustomerRegisterCtrl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得JSP页面传来的参数
		String customerId = request.getParameter("customerId");
		String customerName = request.getParameter("customerName");
		String customerPass = request.getParameter("customerPass");
		int customerAge = Integer.valueOf(request.getParameter("customerAge"));
		String customerSex = request.getParameter("customerSex");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("customerEmail");
		String customerAddr = request.getParameter("customerAddr");
		String customerPost = request.getParameter("customerPost");				
		//数据打包
		Customer customer = new Customer();
		customer.setCustomerAddr(customerAddr);
		customer.setCustomerAge(customerAge);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerPass(customerPass);
		customer.setCustomerPhone(customerPhone);
		customer.setCustomerPost(customerPost);
		customer.setCustomerSex(customerSex);
        boolean result = visitorserv.insertCustomer(customer);
		
		if(result==true){
			response.sendRedirect("customer/login.jsp");
		}else{
			response.sendRedirect("customer/customerRegister.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
