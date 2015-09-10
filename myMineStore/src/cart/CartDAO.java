package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Cart;
import util.DBcon;
import util.Goods;
import util.Item;

public class CartDAO {
	DBcon dbcon = new DBcon();
	
	/**
	 * 添加进购物车
	 * @param cart
	 * @return
	 */
	public int add(Cart cart){
		int i=0;
		Connection  conn = dbcon.getConnection();
		String userName=cart.getUserName();
		String goodsId=cart.getItem().getGoods().getGoodsId();
		String goodsName=cart.getItem().getGoods().getGoodsName();
		int    goodsNumber=cart.getItem().getQuantity();
		double goodsPrice=cart.getItem().getGoods().getGoodsPrice();
		double totalPrice=goodsPrice*goodsNumber;
		String sql = "insert into cart(userName,goodsId,goodsName,goodsNumber,goodsPrice,totalPrice) values(?,?,?,?,?,?)";
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,userName);
			pstat.setString(2,goodsId);
			pstat.setString(3,goodsName);
			pstat.setInt(4,goodsNumber);
			pstat.setDouble(5,goodsPrice);
			pstat.setDouble(6, totalPrice);
//			System.out.println(goodsName);
			i=pstat.executeUpdate();
			pstat.close();
			conn.close();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	/**
	 * 查找购物车中是否存在该购物项
	 * @param cart
	 * @return
	 */
	public Goods queryById(Cart cart){
		Goods curGoods=new Goods();
		Connection  conn = dbcon.getConnection();
		String sql = "select * from cart where goodsId=? and userName=? ";
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,cart.getItem().getGoods().getGoodsId());
			pstat.setString(2,cart.getUserName());
			ResultSet rs=null;
			rs=pstat.executeQuery();
			String goodsId;
			String goodsName;
			float goodsPrice;
			while(rs.next()){
				goodsId=rs.getString("goodsId");
				goodsName=rs.getString("goodsName");
				goodsPrice=rs.getFloat("goodsPrice");
				curGoods.setGoodsId(goodsId);
				curGoods.setGoodsName(goodsName);
				curGoods.setGoodsPrice(goodsPrice);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return curGoods;
	}
	
	/**
	 * 取出购物车中所有的购物项
	 * @param cart
	 * @return
	 */
	public ArrayList<Item> queryByUserName(Cart cart){
		ArrayList<Item> list=new ArrayList<Item>();
		
		Connection  conn = dbcon.getConnection();
		String sql = "select * from cart where userName=? ";
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,cart.getUserName());
//			System.out.println(cart.getUserName());
			ResultSet rs=null;
			rs=pstat.executeQuery();
			String goodsId;
			String goodsName;
			double goodsPrice;
			int quantity;
			while(rs.next()){
				Item item=new Item();
				Goods goods=new Goods();
				goodsId=rs.getString("goodsId");
//				System.out.println(goodsId);
				goodsName=rs.getString("goodsName");
//				System.out.println(goodsName);
				quantity=rs.getInt("goodsNumber");
				goodsPrice=rs.getDouble("goodsPrice");		
				goods.setGoodsId(goodsId);
				goods.setGoodsName(goodsName);
				goods.setGoodsPrice((float)goodsPrice);
				item.setGoods(goods);
				item.setQuantity(quantity);
				item.setSubtotal(goodsPrice*quantity);
//				System.out.println(item.getGoods().getGoodsName());
//				System.out.println(item.getSubtotal());
				list.add(item);					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(Item item1:list){
//			System.out.println(item1.getGoods().getGoodsId());
//			System.out.println(item1.getGoods().getGoodsName());
//			System.out.println();
//		}
		return list;
		
	}
	/**
	 * 修改购物车中的购物项
	 * @param cart
	 * @return
	 */
	public int updateCart(Cart cart){
		int i=0;
		Connection  conn = dbcon.getConnection();
		String userName=cart.getUserName();
		String goodsId=cart.getItem().getGoods().getGoodsId();
		int    goodsNumber=cart.getItem().getQuantity();
		double goodsPrice=cart.getItem().getGoods().getGoodsPrice();
		double totalPrice=goodsPrice*goodsNumber;
		String sql = "update cart set goodsNumber=?,totalPrice=? where userName=? and goodsId=?";
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);			
			pstat.setInt(1,goodsNumber);
			pstat.setDouble(2, totalPrice);
			pstat.setString(3,userName);
			pstat.setString(4,goodsId);
			i=pstat.executeUpdate();
			pstat.close();
			conn.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	/**
	 * 删除购物项
	 * @param cart
	 * @return
	 */
	public int deleteCartGoods(Cart cart){
		int i=0;
		Connection  conn = dbcon.getConnection();
		String userName=cart.getUserName();
		String goodsId=cart.getItem().getGoods().getGoodsId();
		String sql = "delete from cart where userName=? and goodsId=?";
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,userName);
			pstat.setString(2,goodsId);
			i=pstat.executeUpdate();
			pstat.close();
			conn.close();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	/**
	 * 清空购物成车
	 * @param cart
	 * @return
	 */
	public int deleteAll(Cart cart){
		int i=0;
		Connection  conn = dbcon.getConnection();
		String userName=cart.getUserName();
		String sql = "delete from cart where userName=?";
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,userName);
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
