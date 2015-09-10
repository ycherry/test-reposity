package visitor;

import util.Customer;

public class VisitorServ {
	VisitorDAO vd=new VisitorDAO();
	/**
	 * �ο�ע���Ϊ�˿�
	 * @param customer
	 * @return boolean
	 */
	public boolean insertCustomer(Customer customer){
		boolean result=false;
		try{
			int flag=vd.insertCustomer(customer);
			if(flag!=0){
				result=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


}
