package visitor;

import java.sql.*;
import java.util.ArrayList;

import util.DBcon;
import util.Goods;

public class GoodsDAO {
	DBcon dbcon = new DBcon();
	/**
	 * 查询所有商品
	 * @return list
	 * @throws Exception
	 */
	public ArrayList<Goods> queryAllGoods(){
		ArrayList<Goods> list=new ArrayList<Goods>();
		String goodsId;
		String goodsName;
		String goodsCategory;
		String producer;
		String goodsDesc;
		int goodsCount;
		float goodsPrice;
		String goodsView;
		String businessId;
		Connection conn=dbcon.getConnection();
		String sql="select * from goods";
		try {
			Statement stat=conn.createStatement();
			ResultSet rs=null;
			rs=stat.executeQuery(sql);
			while(rs.next()){
				goodsId=rs.getString("goodsId");
				goodsName=rs.getString("goodsName");
				goodsCategory=rs.getString("goodsCategory");
				producer=rs.getString("goodsProducer");
				goodsDesc=rs.getString("goodsDesc");
				goodsCount=rs.getInt("goodsCount");
				goodsPrice=rs.getFloat("goodsPrice");
				goodsView=rs.getString("goodsView");
				businessId=rs.getString("businessId");	
				Goods goods=new Goods();
				goods.setGoodsId(goodsId);
				goods.setGoodsName(goodsName);
				goods.setGoodsCategory(goodsCategory);
				goods.setProducer(producer);
				goods.setGoodsDesc(goodsDesc);
				goods.setGoodsCount(goodsCount);
				goods.setGoodsPrice(goodsPrice);
				goods.setGoodsView(goodsView);
				goods.setBusinessId(businessId);
				list.add(goods);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	/**
	 * 模糊搜索商品
	 * 商品类型、商品名称
	 * @param goods
	 * @return list
	 * @throws Exception
	 */
	public ArrayList<Goods> checkGoods(Goods goods) {
		ArrayList<Goods> list=new ArrayList<Goods>();		
		Connection  conn = dbcon.getConnection();
		String sql=null;
		if(!goods.getGoodsCategory().equals("all")){
			sql = "select * from goods where (goodsName like ?)&(goodsCategory=?)";
		}else{
			sql = "select * from goods where goodsname like ?";
		}		
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,"%"+goods.getGoodsName()+"%");
			if(!goods.getGoodsCategory().equals("all")){
				pstat.setString(2,goods.getGoodsCategory());
			}		
			ResultSet rs=null;
			rs=pstat.executeQuery();
			String goodsId;
			String goodsName;
			String goodsCategory;
			String producer;
			String goodsDesc;
			int goodsCount;
			float goodsPrice;
			String goodsView;
			String businessId;
			while(rs.next()){
				goodsId=rs.getString("goodsId");
				goodsName=rs.getString("goodsName");
				goodsCategory=rs.getString("goodsCategory");
				producer=rs.getString("goodsProducer");
				goodsDesc=rs.getString("goodsDesc");
				goodsCount=rs.getInt("goodsCount");
				goodsPrice=rs.getFloat("goodsPrice");
				goodsView=rs.getString("goodsView");
				businessId=rs.getString("businessId");
				Goods curGoods=new Goods();
				curGoods.setGoodsId(goodsId);
				curGoods.setGoodsName(goodsName);
				curGoods.setGoodsCategory(goodsCategory);
				curGoods.setProducer(producer);
				curGoods.setGoodsCount(goodsCount);
				curGoods.setGoodsDesc(goodsDesc);
				curGoods.setGoodsPrice(goodsPrice);
				curGoods.setBusinessId(businessId);
				curGoods.setGoodsView(goodsView);
				list.add(curGoods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return list;
	}
	
	
	
	public Goods queryById(Goods goods){
		Goods curGoods=new Goods();
		Connection  conn = dbcon.getConnection();
		String sql = "select * from goods where goodsId=?";
		PreparedStatement pstat;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,goods.getGoodsId());
			ResultSet rs=null;
			rs=pstat.executeQuery();
			String goodsId;
			String goodsName;
			String goodsCategory;
			String producer;
			String goodsDesc;
			int goodsCount;
			float goodsPrice;
			String goodsView;
			String businessId;
			while(rs.next()){
				goodsId=rs.getString("goodsId");
				goodsName=rs.getString("goodsName");
				goodsCategory=rs.getString("goodsCategory");
				producer=rs.getString("goodsProducer");
				goodsDesc=rs.getString("goodsDesc");
				goodsCount=rs.getInt("goodsCount");
				goodsPrice=rs.getFloat("goodsPrice");
				goodsView=rs.getString("goodsView");
				businessId=rs.getString("businessId");
				curGoods.setGoodsId(goodsId);
				curGoods.setGoodsName(goodsName);
				curGoods.setGoodsCategory(goodsCategory);
				curGoods.setProducer(producer);
				curGoods.setGoodsCount(goodsCount);
				curGoods.setGoodsDesc(goodsDesc);
				curGoods.setGoodsPrice(goodsPrice);
				curGoods.setBusinessId(businessId);
				curGoods.setGoodsView(goodsView);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return curGoods;
	}	

}
