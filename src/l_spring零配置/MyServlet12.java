package l_spring零配置;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import l_spring零配置.beanOne.BeanOne;

/**
 * Servlet implementation class MyServlet13
 */
@WebServlet("/MyServlet12")
public class MyServlet12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("l_spring零配置/bean.xml");
		BeanOne beanOne = applicationContext.getBean("beanOne", BeanOne.class);
		beanOne.say();
	}
}
