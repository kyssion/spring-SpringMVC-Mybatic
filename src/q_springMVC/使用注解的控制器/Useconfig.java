package q_springMVC.使用注解的控制器;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//使用配置文件的控制器需要使用controller接口实现控制器的操作
//因为不使用注解的方法每次只能定义一个javabean 在配置文件中,所以一个bean只能映射一个url
public class Useconfig implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("123");
		//获得使用从contextlistener进行配置的javabean
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		
		
		//返回一个视图
		return new ModelAndView("a");
	}
	
}
