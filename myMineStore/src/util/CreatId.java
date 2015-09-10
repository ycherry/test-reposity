package util;

import java.util.Date;

public class CreatId {
	/**
	 *  动态生成ID
	 * @return id
	 */
	public String creatId(){
		String id ;		
		Date date=new Date();
		String time=Long.toString(date.getTime());//获得毫秒数并转换成String		
		String math=Long.toString(Math.round(Math.random()*10000));//获得随机数并转成四位的String
		id=time+math;//组成ID
		return id;
	}
	public String creatOrderId(String businessId,String customerName){
		String id;
		Date date = new Date();
//		String time=Long.toString(date.getTime());
//		id=businessId+customerName+time;
		id=businessId+customerName;
		return id;
	}

}
