package p_spring事务.hasconfig;

import p_spring事务.JDBC_Business;
import p_spring事务.Operating_interface;

public class CustomerTransforHasConfig implements Operating_interface{
	private JDBC_Business jDBC_Business;
	public JDBC_Business getJDBC_Business() {
		return jDBC_Business;
	}
	public void setJDBC_Business(JDBC_Business jDBC_Business) {
		this.jDBC_Business = jDBC_Business;
	}
	@Override
	public void transfer(String from, String to, int money) {
		// TODO Auto-generated method stub
		//当事务发生异常的时候将会进行回滚
		this.jDBC_Business.turn_into_money(to, money);
		//int i=1/0;
		this.jDBC_Business.turn_money_out(from, money);
	}
	
}
