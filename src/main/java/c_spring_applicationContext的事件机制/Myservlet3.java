package c_spring_applicationContext的事件机制;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import c_spring_applicationContext的事件机制.applicationEvent.MyApplicationEvent;

/**
 * Servlet implementation class Myservlet3
 */
@WebServlet("/Myservlet3")
public class Myservlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * spring的时间监听机制是观察者模式的实现-
		 * 每当ApplicationContext发布ApplicationEvent的时候，applicationListener bean 将会自动的进行发布
		 * */
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("c_spring_applicationContext的事件机制/bean.xml");
		MyApplicationEvent myApplicationEvent = new MyApplicationEvent("sfsdfsdf","123123");
		//发出事件
		applicationContext.publishEvent(myApplicationEvent);
		//spring 存在内置事件  -详情见MyApplicationEvent 类
	}

}
