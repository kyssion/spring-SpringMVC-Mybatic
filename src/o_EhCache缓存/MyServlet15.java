package o_EhCache缓存;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import o_EhCache缓存.ceshi.Ceshi_one;
import o_EhCache缓存.ceshi.Javabean;
import o_EhCache缓存.ceshi.Z;

/**
 * Servlet implementation class Myservlet11
 */
@WebServlet("/MyServlet15")
public class MyServlet15 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("o_EhCache缓存/bean.xml");
		Z ceshi = applicationContext.getBean("ceshi_one",Z.class);
		Javabean javabean = ceshi.getone("li", "li");
		Javabean javabean2 = ceshi.getone("li", "lill");
		System.out.println("this is javabean1"+javabean);
		System.out.println("this is javabean2"+javabean2);
		ceshi.delectall();//这里使用清除缓冲区
		Javabean javabean3= ceshi.getone("li", "li");
		System.out.println(javabean3);
	}
}
