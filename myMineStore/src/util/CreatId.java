package util;

import java.util.Date;

public class CreatId {
	/**
	 *  ��̬����ID
	 * @return id
	 */
	public String creatId(){
		String id ;		
		Date date=new Date();
		String time=Long.toString(date.getTime());//��ú�������ת����String		
		String math=Long.toString(Math.round(Math.random()*10000));//����������ת����λ��String
		id=time+math;//���ID
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
