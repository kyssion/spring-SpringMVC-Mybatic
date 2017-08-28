package k_spring后置处理器;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import k_spring后置处理器.bean后处理器.BeanOne;
@WebServlet("/Myservlet11")
public class Myservlet11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("k_spring后置处理器/bean.xml");
		BeanOne beanOne = context.getBean("beanone", BeanOne.class);
	}
}
