package S_Mybatis.z_z_MyBatis实例;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import S_Mybatis.z_z_MyBatis实例.javabean.BeanOne;



/**
 * Servlet implementation class Myservlet17
 */
@WebServlet("/Myservlet17")
public class Myservlet17 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Myservlet17() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession session = this.getSqlsession();
		List<BeanOne> list= new ArrayList<>();
		list=session.selectList("S_Mybatis.z_z_MyBatis实例.mapping.selectPeople");
		BeanOne beanOne=null;
		
		for (Object o:list){
			beanOne=(BeanOne) o;
			System.out.println(beanOne.getName());
		}
		session.commit();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public SqlSession getSqlsession(){
		InputStream config = null;
		try {
			config = Resources.getResourceAsStream("S_Mybatis/z_z_MyBatis实例/config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(config);
		return sessionFactory.openSession();
	}
}
