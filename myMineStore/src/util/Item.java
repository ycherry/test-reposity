package util;

public class Item {
	private Goods goods;
	private int quantity;
	private double subtotal;
	
	//¹ºÎïÏî
//	public Item(Goods goods,int quantity){
//		this.goods=goods;
//		this.quantity=quantity;
//		this.subtotal=goods.getGoodsPrice()*quantity;
//	}
		
		
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
