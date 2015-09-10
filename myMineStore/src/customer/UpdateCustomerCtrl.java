package customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Customer;

/**
 * Servlet implementation class UpdateCustomerCtrl
 */
public class UpdateCustomerCtrl extends HttpServlet {
	CustomerServ customerserv = new CustomerServ();
       
   
    public UpdateCustomerCtrl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得从JSp页面传来的参数
				HttpSession session = request.getSession();
				String customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
				String customerName = request.getParameter("customerName");
				String customerPass = request.getParameter("customerPass");
				String customerAddr = request.getParameter("customerAddr");
				int customerAge = Integer.parseInt(request.getParameter("customerAge"));
				String customerSex = request.getParameter("customerSex");
				String customerPhone = request.getParameter("customerPhone");
				String customerEmail = request.getParameter("customerEmail");
				String customerPost = request.getParameter("customerPost");
				// 数据打包
				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customerName);
				customer.setCustomerPass(customerPass);
				customer.setCustomerAddr(customerAddr);
				customer.setCustomerAge(customerAge);
				customer.setCustomerSex(customerSex);
				customer.setCustomerPhone(customerPhone);
				customer.setCustomerEmail(customerEmail);
				customer.setCustomerPost(customerPost);
				boolean result = customerserv.update(customer);
				
				
				//输出数据
//				System.out.println(customer.getCustomerName());
//				System.out.println(customer.getCustomerId());

				if (result == true) {
					session.removeAttribute("customer");
					session.setAttribute("customer", customer);
					response.sendRedirect("customer/loginSuccess.jsp");
				} else {
					response.sendRedirect("customer/update.jsp");
				}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
