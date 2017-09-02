package p_spring事务;

import org.springframework.jdbc.core.JdbcTemplate;
//jdbc业务的实现类---
public class JDBC_Business extends JdbcTemplate implements Business_interface{
	//转入钱
	@Override
	public void turn_into_money(String name, int money) {
		// TODO Auto-generated method stub
		String sql = "update Transfer set money=money+? where name= ? ";
		this.update(sql, money,name);
		
	}
	//传出钱
	@Override
	public void turn_money_out(String name, int money) {
		// TODO Auto-generated method stub
		String sql = "update Transfer set money=money-? where name= ? ";
		this.update(sql, money,name);
	}
}
