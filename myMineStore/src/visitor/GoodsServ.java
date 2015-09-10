package visitor;

import java.util.ArrayList;

import util.Goods;

public class GoodsServ {
   GoodsDAO gd=new GoodsDAO();
	
	/**
	 * ��ѯ������Ʒ��Ϣ
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
	 * �򵥵���Ʒ����
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
	 * ��ѯ��Ʒ��ϸ
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
