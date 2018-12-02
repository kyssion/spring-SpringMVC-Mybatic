package n_springAOP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
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
		//Spring加载Bean的流程： 
		//(1)创建一个上下文context = createApplicationContext; 
		//(2)context中都会有一个BeanFactory（默认是DefaultListableBeanFactory）,
		//在该类的子类类xmlBeanFactory中进行xml文件的解析； 
		//(3)在类XmlBeanDefinitionParser 中用Dom解析xml文件(DefaultXmlBeanDefinitionParser)，
		//解析xml文件中所有bean，并将bean放到BeanDefinitionHolder中，封装成BeanDefinition； 
		//(4)再进行bean的注册，具体在BeanDefinitionReaderUtils类调用DefaultListableBeanFactory
		//类的registerBeanDefinition进行bean的注册，在这里用了一HashMap存放bean,
		//其中用Beanname作为键值，其封装好的beanDefinition作为值。还有用一个List存放所有的bean的名字。
		
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
