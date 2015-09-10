package order;

import java.util.ArrayList;


import util.Customer;
import util.Order;
import util.OrderDetail;

public class OrderServ {
OrderDAO od = new OrderDAO();
	
	/**
	 * ���붩����
	 * @param order
	 * @return
	 */
	public boolean insertOrder(Order order){
		try {
			int i = od.insertOrder(order);
			if(i!=0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * �������ϸ��
	 * @param orderDetail
	 * @return
	 */
	public boolean insertOrderDetail(OrderDetail orderDetail){
		try {
			int i = od.insertOrderDetail(orderDetail);
			if(i!=0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

}
