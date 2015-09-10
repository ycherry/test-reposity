package cart;

import java.util.*;

import util.Cart;
import util.Customer;
import util.Goods;
import util.Item;

public class CartServ {
	CartDAO cartdao=new CartDAO();

	
	/**
	 * ��ӽ����ﳵ
	 * @param goods
	 * @param quantity
	 * @return
	 */
	public Cart addToCart(Cart cart){
		Goods curGoods=new Goods();
		curGoods=cartdao.queryById(cart);
		if(curGoods.getGoodsId()==null){
			//��ӵ����ﳵ
			cartdao.add(cart);
		}
		else {
			cartdao.updateCart(cart);
			}
		return cart;
	}
	
	/**
	 * ɾ��������
	 */
	public int  delete(Cart cart){
		int i;
		i=cartdao.deleteCartGoods(cart);
		if(i!=0){
			return i;
		}
		else
			return 0;
	}
	
	/**
	 * �޸Ĺ��ﳵ�Ĺ�����
	 */
	public int  update(Cart cart){
		int i;
		i=cartdao.updateCart(cart);
		if(i!=0){
			return i;
		}
		else
			return 0;
	}
	
	/**
	 * ��չ��ﳵ
	 */
	
	public int emptyCart(Cart cart){
		int i;
		i=cartdao.deleteAll(cart);
		if(i!=0){
			return i;
		}
		else
			return 0;
	}
	/**
	 * ��ʾ���ﳵ�����еĹ�����
	 * @param cart
	 * @return
	 */
	public ArrayList<Item> CartGoods(Cart cart){
//		ArrayList<Item> item=new ArrayList<Item>();
//		item=cartdao.queryByUserName(cart);
//		 Iterator it1 = item.iterator();
//		 while(it1.hasNext()){
//			 System.out.println(it1.next());
//		 }
//		for(Item item1:item){
//			System.out.println(item1.getGoods().getGoodsId());
//			System.out.println(item1.getGoods().getGoodsName());
//			System.out.println();
//		}
		return cartdao.queryByUserName(cart);
	}

}
