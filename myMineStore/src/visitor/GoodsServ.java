package visitor;

import java.util.ArrayList;

import util.Goods;

public class GoodsServ {
   GoodsDAO gd=new GoodsDAO();
	
	/**
	 * 查询所有商品信息
	 * @return list
	 */
	public ArrayList<Goods> queryAllGoods(){
		ArrayList<Goods> list=new ArrayList<Goods> ();
		try {
			list=gd.queryAllGoods();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 简单的商品搜索
	 * @param goods
	 * @return list
	 */
	public ArrayList<Goods> checkGoods(Goods goods){
		ArrayList<Goods> list=new ArrayList<Goods> ();
		try {
			list=gd.checkGoods(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询商品明细
	 * @param goods
	 * @return
	 */
	public Goods QueryGoodsDetail(Goods goods){
		Goods curGoods = new Goods();
		try {
			curGoods = gd.queryById(goods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return curGoods;
	}	
	

}
