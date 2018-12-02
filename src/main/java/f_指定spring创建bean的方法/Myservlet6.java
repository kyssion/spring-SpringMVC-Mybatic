package f_指定spring创建bean的方法;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import f_指定spring创建bean的方法.a_使用构造方法创建.BeanOne;
import f_指定spring创建bean的方法.b_使用工厂方法创建.B_BeanOne;
import f_指定spring创建bean的方法.b_使用工厂方法创建.C_BeanTwo;


/**
 * Servlet implementation class Myservlet6
 */
@WebServlet("/Myservlet6")
public class Myservlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("f_指定spring创建bean的方法/bean.xml");
		BeanOne beanOne = context.getBean("constructionBean", BeanOne.class);
		beanOne.say();
		B_BeanOne b_BeanOne = context.getBean("jingtaiB", B_BeanOne.class);
		b_BeanOne.say();
		C_BeanTwo c_BeanTwo = context.getBean("shiliC",C_BeanTwo.class);
		c_BeanTwo.say();
		
	}
}
