package visitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Customer;
import util.DBcon;

public class VisitorDAO {
	DBcon dbcon = new DBcon();
	/**
	 * ×¢²á¹Ë¿Í
	 * @param customer
	 * @return pstat.executeUpdate()
	 * @throws Exception
	 */
	public int insertCustomer(Customer customer) {
		int i=0;
		Connection  conn = dbcon.getConnection();
		String customerName=customer.getCustomerName();
		String customerPass=customer.getCustomerPass();
		String customerAddr=customer.getCustomerAddr();
		int customerAge=customer.getCustomerAge();		
		String customerSex=customer.getCustomerSex();
		String customerPhone=customer.getCustomerPhone();
		String customerEmail=customer.getCustomerEmail();
		String customerPost=customer.getCustomerPost();
		String sql = "insert into customer(customerName,customerPassword,customerAddress,customerAge,customerSex,customerPhone,customerEmail,customerPost,customerId) values(?,?,?,?,?,?,?,?,?)";
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
			pstat.setString(9, customer.getCustomerId());
			i=pstat.executeUpdate();
			pstat.close();
			conn.close();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

}
