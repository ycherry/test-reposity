package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import util.Customer;
import util.DBcon;
import util.Order;
import util.OrderDetail;

public class OrderDAO {
	DBcon dbcon=new DBcon();
	/**
	 * 插入Order
	 * @param order
	 * @return i
	 * @throws Exception
	 */
	public int insertOrder(Order order) throws Exception{
		Connection  conn = dbcon.getConnection();
		String sql="insert into order1 (orderId,customerName,address,orderTime,post,recipient,phone,orderStatus,payment) values(?,?,?,?,?,?,?,?,?)";
//		String sql = "insert into order(orderId,businessId,customerName,address,recipient,phone,orderStatus,payment,orderTime,post) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstat=conn.prepareStatement(sql);
		pstat.setString(1,order.getOrderId());
//		pstat.setString(2,order.getBusinessId());
		pstat.setString(2,order.getCustomerName());
		pstat.setString(3,order.getAddress());
		pstat.setString(4,order.getOrderTime());
		pstat.setString(5,order.getPost());
		pstat.setString(6,order.getRecipient());
		pstat.setString(7,order.getPhone());
		pstat.setString(8,order.getOrderStatus());
		pstat.setDouble(9,order.getPayment());
		
//		System.out.println(sql);
//		System.out.println("orderId:"+order.getOrderId());
//		System.out.println(order.getBusinessId());
//		System.out.println(order.getCustomerName());
//		System.out.println(order.getAddress());
//		System.out.println(order.getRecipient());
//		System.out.println(order.getPhone());
//		System.out.println(order.getOrderStatus());
//		System.out.println(order.getOrderTime());
//		System.out.println(order.getPost());
//		System.out.println(order.getPayment());


		int i=pstat.executeUpdate();
		pstat.close();
		conn.close();
		return i;
	}
	/**
	 * 插入OrderDetail
	 * @param orderDetail
	 * @return i
	 * @throws Exception
	 */
	public int insertOrderDetail(OrderDetail orderDetail) throws Exception{
		Connection  conn = dbcon.getConnection();
		String sql = "insert into orderdetail(orderId,goodsId,quantity,costPrice) values(?,?,?,?)";
		PreparedStatement pstat=conn.prepareStatement(sql);
//		System.out.println(orderDetail.getOrderId());
		pstat.setString(1,orderDetail.getOrderId());
		pstat.setString(2,orderDetail.getGoodsId());
		pstat.setInt(3,orderDetail.getQuantity());
		pstat.setDouble(4,orderDetail.getCostPrice());
		int i=pstat.executeUpdate();
		pstat.close();
		conn.close();
		return i;
	}
	/**
	 * 修改订单信息（送货地址、接收人、联系电话、总金额）
	 * @param order
	 * @return i
	 * @throws Exception
	 */
	public int updateOrder(Order order) throws Exception{
		Connection  conn = dbcon.getConnection();
		String sql = "update order1 set (address=?,recipient=?,phone=?,payment=?) where orderId=?";
		PreparedStatement pstat=conn.prepareStatement(sql);
		pstat.setString(5,order.getOrderId());
		pstat.setString(1,order.getAddress());
		pstat.setString(2,order.getRecipient());
		pstat.setString(3,order.getPhone());	
		pstat.setDouble(4,order.getPayment());
		int i=pstat.executeUpdate();
		pstat.close();
		conn.close();
		return i;
	}
	
	

	
}
