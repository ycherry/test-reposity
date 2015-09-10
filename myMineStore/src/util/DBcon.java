package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
	private static String dbUrl ="jdbc:mysql://localhost/javadb2?useUnicode=true&characterEncoding=GBK";
	  private static String dbUser ="root";
	  private static String dbPwd = "19941115";
	  public  Connection getConnection() {
	    Connection con = null;
	   
	      //Class.forName(dbClassName).newInstance();
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				 try {
					con = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
					 return con;
				} catch (SQLException e) {
					System.out.println("DB connect fail");
					return null;
				}
			} catch (ClassNotFoundException e) {
				System.out.println("DB connect fail");
				return null;
			}
//	    	System.out.println(con);
	   
	  }

}
