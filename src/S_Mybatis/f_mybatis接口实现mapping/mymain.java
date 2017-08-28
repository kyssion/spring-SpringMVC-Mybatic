package S_Mybatis.f_mybatis接口实现mapping;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mymain {
	public void my() throws IOException{
		SqlSessionFactory sessionFactory = 
				new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("xxx.xxx"));
		SqlSession session= sessionFactory.openSession(false);//关闭自动提交
		//使用这两个方法可以进行动态的调用在sql语句中使用已经进行定义方法
		Myintarface myintarface = session.getMapper(Myintarface.class);
		myintarface.getBeanOne("123");
	}
}
