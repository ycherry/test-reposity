package cart;

import java.util.*;

import util.Cart;
import util.Customer;
import util.Goods;
import util.Item;

public class CartServ {
	CartDAO cartdao=new CartDAO();

	
	/**
	 * 添加进购物车
	 * @param goods
	 * @param quantity
	 * @return
	 */
	public Cart addToCart(Cart cart){
		Goods curGoods=new Goods();
		curGoods=cartdao.queryById(cart);
		if(curGoods.getGoodsId()==null){
			//添加到购物车
			cartdao.add(cart);
		}
		else {
			cartdao.updateCart(cart);
			}
		return cart;
	}
	
	/**
	 * 删除购物项
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
	 * 修改购物车的购物项
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
	 * 清空购物车
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
	 * 显示购物车这所有的购物项
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
