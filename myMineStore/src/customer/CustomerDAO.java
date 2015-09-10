package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.Customer;
import util.DBcon;

public class CustomerDAO {
	DBcon dbcon = new DBcon();
	/**
	 * 顾客登录验证
	 * 查询顾客个人信息
	 * @param customer
	 * @return curCustomer
	 * @throws Exception
	 */
	public Customer queryByName(Customer customer) throws Exception{
		Customer curCustomer = new Customer();
		Connection  conn = dbcon.getConnection();
//		Connection  conn=null;
//		Class.forName("com.mysql.jdbc.Driver");
//		conn = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root", "19941115");
		String sql = "select * from customer where customerName=?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, customer.getCustomerName());
		ResultSet rs = null;
		rs = pstat.executeQuery();
//		System.out.println(sql);
		while(rs.next()){
			String customerId = rs.getString("customerId");
			String customerName = rs.getString("customerName");
			String customerPass=rs.getString("customerPassword");
			String customerAddr=rs.getString("customerAddress");
			String customerSex=rs.getString("customerSex");
			int customerAge=rs.getInt("customerAge");
			String customerPhone=rs.getString("customerPhone");
			String customerEmail=rs.getString("customerEmail");
			String customerPost=rs.getString("customerPost");
			
			curCustomer.setCustomerId(customerId);
			curCustomer.setCustomerName(customerName);
			curCustomer.setCustomerPass(customerPass);
			curCustomer.setCustomerAddr(customerAddr);
			curCustomer.setCustomerAge(customerAge);
			curCustomer.setCustomerSex(customerSex);
			curCustomer.setCustomerPhone(customerPhone);
			curCustomer.setCustomerEmail(customerEmail);
			curCustomer.setCustomerPost(customerPost);
//			System.out.println(curCustomer.getCustomerId());
//			System.out.println(curCustomer.getCustomerSex());
		}
		pstat.close();
//		stat.close();
		conn.close();
		return curCustomer;
	}
	
	
	public Customer queryById(Customer customer) throws Exception{
		Customer curCustomer = new Customer();
		Connection  conn = dbcon.getConnection();
//		Connection  conn=null;
//		Class.forName("com.mysql.jdbc.Driver");
//		conn = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root", "19941115");
		String sql = "select * from customer where customerId=?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, customer.getCustomerId());
		ResultSet rs = null;
		rs = pstat.executeQuery();
//		System.out.println(sql);
		while(rs.next()){
			String customerId = rs.getString("customerId");
			String customerName = rs.getString("customerName");
			String customerPass=rs.getString("customerPassword");
			String customerAddr=rs.getString("customerAddress");
			String customerSex=rs.getString("customerSex");
			int customerAge=rs.getInt("customerAge");
			String customerPhone=rs.getString("customerPhone");
			String customerEmail=rs.getString("customerEmail");
			String customerPost=rs.getString("customerPost");
			
			curCustomer.setCustomerId(customerId);
			curCustomer.setCustomerName(customerName);
			curCustomer.setCustomerPass(customerPass);
			curCustomer.setCustomerAddr(customerAddr);
			curCustomer.setCustomerAge(customerAge);
			curCustomer.setCustomerSex(customerSex);
			curCustomer.setCustomerPhone(customerPhone);
			curCustomer.setCustomerEmail(customerEmail);
			curCustomer.setCustomerPost(customerPost);
//			System.out.println(curCustomer.getCustomerId());
//			System.out.println(curCustomer.getCustomerSex());
		}
		pstat.close();
//		stat.close();
		conn.close();
		return curCustomer;
	}
	/**
	 * 修改顾客的个人信息
	 * @param customer
	 * @return pstat.executeUpdate()
	 * @throws SQLException 
	 * @throws Exception
	 */
	public int updateCustomer(Customer customer) {	
		int i=0;
		Connection  conn = dbcon.getConnection();
		String customerID=customer.getCustomerId();
		String customerName=customer.getCustomerName();
		String customerPass=customer.getCustomerPass();
		String customerAddr=customer.getCustomerAddr();
		int customerAge=customer.getCustomerAge();
		String customerSex=customer.getCustomerSex();
		String customerPhone=customer.getCustomerPhone();
		String customerEmail=customer.getCustomerEmail();
		String customerPost=customer.getCustomerPost();
		String sql = "update customer set customerName=?,customerPassword=?,customerAddress=?,customerAge=?,customerSex=?,customerPhone=?,customerEmail=?,customerPost=? where customerId=?";
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,customerName);
			pstat.setString(2,customerPass);
			pstat.setString(3,customerAddr);
			pstat.setInt(4,customerAge);
			pstat.setString(5,customerSex);
			pstat.setString(6, customerPhone);
			pstat.setString(7,customerEmail);
			pstat.setString(8,customerPost);
			pstat.setString(9, customerID);
//			System.out.println(customerID);
//			System.out.println(customerName);
//			System.out.println("password:"+customerPass);
			i=pstat.executeUpdate();
			pstat.close();
			conn.close();
//			System.out.println("i="+i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.println("fault:"+e.getErrorCode());
//			System.out.println("there is a fault");
			e.printStackTrace();
		}
		return i;
			
	}

}
