package i_spring框架出处理单例模式下的非单例成员;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class Myservlet9
 */
@WebServlet("/Myservlet9")
public class Myservlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用cglib方法进行
		method();
		//使用jdk方法进行注入
		method2();
	}
	public void method(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("j_spring框架出处理单例模式下的非单例成员/bean.xml");
		BeanOne beanOne1 = context.getBean("beanone",BeanOne.class);
		BeanOne beanOne2 = context.getBean("beanone",BeanOne.class);
		BeanOne beanOne3 = context.getBean("beanone",BeanOne.class);
		beanOne1.say();
		beanOne2.say();
		beanOne3.say();
	}
	public void method2(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("j_spring框架出处理单例模式下的非单例成员/bean.xml");
		i_spring框架出处理单例模式下的非单例成员.使用接口.BeanOne beanOne1 = context.getBean("intebeanone",i_spring框架出处理单例模式下的非单例成员.使用接口.BeanOne.class);
		i_spring框架出处理单例模式下的非单例成员.使用接口.BeanOne beanOne2 = context.getBean("intebeanone",i_spring框架出处理单例模式下的非单例成员.使用接口.BeanOne.class);
		i_spring框架出处理单例模式下的非单例成员.使用接口.BeanOne beanOne3 = context.getBean("intebeanone",i_spring框架出处理单例模式下的非单例成员.使用接口.BeanOne.class);
		beanOne1.say();
		beanOne2.say();
		beanOne3.say();
	}
}
