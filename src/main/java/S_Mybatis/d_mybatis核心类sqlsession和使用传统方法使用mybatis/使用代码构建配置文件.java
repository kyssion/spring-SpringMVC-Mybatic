package S_Mybatis.d_mybatis核心类sqlsession和使用传统方法使用mybatis;


import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class 使用代码构建配置文件 {
	public  void  method(){
		//首先构建数据库链接池 要使用
		PooledDataSource pool = new PooledDataSource();
		//配置数据库链接池
		pool.setDriver("xxx");
		//.....
		//构建数据库事务方法
		TransactionFactory transactionFactory = 
				new JdbcTransactionFactory();
		//创建数据库运行环境
		Environment environment = new Environment("xx", transactionFactory, pool);
		//创建configuration对象
		Configuration configuration = new Configuration(environment);
		//注册一个mybatis 的上下文别名
		configuration.getTypeAliasRegistry().registerAlias("xxx",this.getClass());
		//加入一个映射器
		configuration.addMapper(this.getClass());
		//SqlsessionFactoryBuilder 构建 SqlsessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
	}
}
