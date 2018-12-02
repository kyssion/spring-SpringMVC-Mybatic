package S_Mybatis.d_mybatis核心类sqlsession和使用传统方法使用mybatis;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import S_Mybatis.z_z_MyBatis实例.javabean.BeanOne;

public class 基本类详解 {
	public void 核心() throws IOException{
		//SqlSessionFactory获取一个输入的配置信息流从信息流中的到配置文件的相关信息 获取方法通过sqlfactoryBuilder类build-sessionFactor
		//这个是构建sqlsession核心方法  -必须使用mybatis定义的Ressources资源使用类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config.xml"));
		//获得sqlsession   这个方法中有一个boolean类型表示是否自动提交
		SqlSession session = sqlSessionFactory.openSession();
		//想定义list可以在编译的过长中让jvm自动的进行转化而不是使用Java的格式转化方法 selectlist方法默认的返回类型是selectList<object>
		List<BeanOne> list= new ArrayList<>();
		list=session.selectList("S_Mybatis.z_z_MyBatis实例.mapping.selectPeople");
		
	}
	//sqlsession所有的方法
	public void method(){
		MySqlSession session = new MySqlSession() {
			//数据库进行更新的方法,当使用多个数据的时候我们可以让object是一个封装的集合类
			public int update(String arg0, Object arg1) {return 0;}
			public int update(String arg0) {return 0;}
			//查询一个数据
			public <T> T selectOne(String arg0, Object arg1) {return null;}
			public <T> T selectOne(String arg0) {return null;}
			public <K, V> Map<K, V> selectMap(String arg0, Object arg1, String arg2, RowBounds arg3) {return null;}
			public <K, V> Map<K, V> selectMap(String arg0, Object arg1, String arg2) {return null;}
			public <K, V> Map<K, V> selectMap(String arg0, String arg1) {return null;}
			//数据库的高级应用 RowBounds-RowBounds 参数会告诉 MyBatis 略过指定数量的记录,还有限制返回结果的数量。 RowBounds 类有一个构造方法来接收 offset 和 limit,否则是不可改变的。
			int offset = 100;
			int limit = 25;
			RowBounds rowBounds = new RowBounds(offset, limit);
			public <E> List<E> selectList(String arg0, Object arg1, RowBounds arg2) {return null;}
			public <E> List<E> selectList(String arg0, Object arg1) {return null;}
			public <E> List<E> selectList(String arg0) {return null;}
			//删除数据
			public int delete(String arg0, Object arg1) {return 0;}
			public int delete(String arg0) {return 0;}
			//增加数据
			public int insert(String arg0, Object arg1) {return 0;}
			public int insert(String arg0) {return 0;}
			//事务回滚
			public void rollback(boolean arg0) {}
			public void rollback() {}
			//事务提交
			public void commit(boolean arg0) {}
			public void commit() {}
			//大家都懂
			public void close() {}
			public void clearCache() {}
			//获得各种配置信息
			public <T> T getMapper(Class<T> arg0) {return null;}
			public Connection getConnection() {return null;}
			public Configuration getConfiguration() {return null;}
		};
	}
	class MySqlSession{}
}
