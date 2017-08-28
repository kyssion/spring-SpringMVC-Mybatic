package p_spring事务.noconfig;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import p_spring事务.JDBC_Business;
import p_spring事务.Operating_interface;
@Component(value="mycustomerTransfer")
public class CustomerTransfornoConfig implements Operating_interface{
	@Resource(name="MyJdbcBusiness")
	private JDBC_Business jDBC_Business;
	public JDBC_Business getJDBC_Business() {
		return jDBC_Business;
	}
	public void setJDBC_Business(JDBC_Business jDBC_Business) {
		this.jDBC_Business = jDBC_Business;
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public void transfer(String from, String to, int money) {
		// TODO Auto-generated method stub
		//当事务发生异常的时候将会进行回滚
		this.jDBC_Business.turn_into_money(to, money);
		//int i=1/0;
		this.jDBC_Business.turn_money_out(from, money);
	}
	
}
