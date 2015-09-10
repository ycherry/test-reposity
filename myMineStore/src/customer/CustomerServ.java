package customer;

import util.Customer;

public class CustomerServ {
	CustomerDAO cust = new CustomerDAO();
	/**
	 * �˿͵�½��֤
	 * @param customer
	 * @return customer
	 */	
	public Customer login(Customer customer){
		Customer curCustomer  = new Customer();
		try {
			curCustomer = cust.queryByName(customer);
			if(curCustomer !=null){
				String pwdNew= curCustomer.getCustomerPass();
				String pwdOld = customer.getCustomerPass();
				if(pwdOld.equals(pwdNew)){
					return curCustomer;
				}else{
					 customer.setCustomerId(null);
				}
			}
		} catch (Exception e) {
			customer.setCustomerId(null);
		}		
		return customer;
	//	return curCustomer;
	}
	
	/**
	 * ��ѯ������Ϣ
	 * @param customer
	 * @return customer
	 */
	public Customer checkCustomer(Customer customer){
		Customer curCustomer=new Customer();
		try {
			curCustomer = cust.queryByName(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curCustomer;
	}
	
	
	/**
	 * ���¸�����Ϣ
	 * @param customer
	 * @return boolean
	 */
	public boolean update(Customer customer){
		boolean result=false;
		int i;
		try{
			i=cust.updateCustomer(customer);
			if(i!=0){
				result=true;
			}
		}catch(Exception e){
			System.out.println("i doesn't exist!");
			result=false;
		}
		return result;
	}

}
