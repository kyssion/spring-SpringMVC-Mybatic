package n_springAOP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import n_springAOP.hasconfig.aopBeanTwo.AopBeanTwo;
import n_springAOP.noconfig.FatherBean;

/**
 * Servlet implementation class Myservlet14
 */
@WebServlet("/Myservlet14")
public class Myservlet14 extends HttpServlet {
	//
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//noConfig();
		hasConfig();
	}
	public void noConfig(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("n_springAOP/noconfig/bean.xml");
		//!--一定要注意了 noconfig包中的增强类使用的是jdk代理返回的是一个增强代理接口只能使用接口进行接受
		FatherBean aopBeanOne = applicationContext.getBean("aopBeanOne",FatherBean.class);
		String aString=aopBeanOne.say("123","456");
		System.out.println(aString);
	}
	public void hasConfig(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("n_springAOP/hasconfig/bean.xml");
		AopBeanTwo aopBeanTwo= applicationContext.getBean("aopbeantwo",AopBeanTwo.class);
		String string =aopBeanTwo.say("xixix", "hahaha");
		System.out.println("this is main"+string);
	}
}
