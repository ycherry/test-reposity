package order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.CartServ;
import util.Cart;
import util.CreatId;
import util.Customer;
import util.Goods;
import util.Item;
import util.Order;
import util.OrderDetail;
import visitor.GoodsServ;


public class InsertOrderCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertOrderCtrl() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		CartServ cs=new CartServ();
		PrintWriter out = response.getWriter();
		float goodsPrice=0;
		// ���ɶ���
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			String customerName = customer.getCustomerName();
			Cart cart=(Cart)session.getAttribute("cart");
			ArrayList<Item> item1=cs.CartGoods(cart);
			
			if (item1 != null) {
				ArrayList<String> list = new ArrayList<String>();
				Order order = new Order();
				// ����BusinessId��list
				for (Item item : item1) {
					GoodsServ gs=new GoodsServ();
					Goods goods=new Goods();
					String goodsId=item.getGoods().getGoodsId();
					goods.setGoodsId(goodsId);
					goods=gs.QueryGoodsDetail(goods);
					
					
					goodsPrice=goods.getGoodsPrice();
					boolean find = true;
					for (int i = 0; i < list.size(); i++) {
						if (goodsId.equals(list.get(i))) {
							find = false;
							break;
						}
					}
					if (find) {
						list.add(goodsId);
					}
				}
				// �������ݳ�������У�����
				String orderStatus = "����";// ����û��֧������Ϊ�˷�����ʾ��Ĭ��ֵΪ���ҷ���
				order.setAddress(request.getParameter("address"));
				order.setPhone(request.getParameter("phone"));
				order.setRecipient(request.getParameter("recipient"));
				order.setPost(request.getParameter("post"));
				Date date = new Date();
				order.setOrderTime(date.toString());
				order.setOrderStatus(orderStatus);
				order.setCustomerName(customerName);
				OrderServ os = new OrderServ();
				boolean result1 = false;
				boolean result2 = false;
				// �������ﳵ
				for (String goodsId : list) {
					double costPrice = 0;
//					System.out.println("businessId:"+goodsId);
					CreatId creatid = new CreatId();
					// ���ɶ�����
					String orderId = creatid.creatOrderId(goodsId,
							customerName);
					for (Item item : item1) {
						if (goodsId.equals(item.getGoods().getGoodsId())) {
//							System.out.println("Goods().getGoodsId():"+item.getGoods().getGoodsId());
							costPrice += item.getSubtotal();// ���������ܼۼ���
							OrderDetail orderDetail = new OrderDetail();
							int quantity = item.getQuantity();
							orderDetail.setGoodsId(item.getGoods().getGoodsId());
							orderDetail.setQuantity(quantity);
							orderDetail.setOrderId(orderId);
							orderDetail.setCostPrice(item.getSubtotal());
							// ���뵽������ϸ��
							result1 = os.insertOrderDetail(orderDetail);
							costPrice=quantity*goodsPrice;
						}
					}
					// ���붩��
					order.setOrderId(orderId);
					order.setPayment(costPrice);
					result2 = os.insertOrder(order);
				}
				System.out.println("result1"+result1);
				System.out.println("result2"+result2);
				if (result1 == true && result2 == true) {
					session.setAttribute("cart", cart);
					out.println("��ϲ�㣬�¶����ɹ����ȴ��̼ҷ���");
					out.close();
				} else {
					out.println("�¶���ʧ�ܣ��������µ�");
					response.setHeader("refresh", "1;url=customer/confirm.jsp");
					out.close();
				}
			}
		} else {
			out.print("���ȵ�¼��");
			out.close();
			response.setHeader("refresh", "1;url=customer/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
