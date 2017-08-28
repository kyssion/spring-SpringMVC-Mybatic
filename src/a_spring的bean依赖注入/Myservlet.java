package a_spring的bean依赖注入;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import a_spring的bean依赖注入.beanOne.BeanOne;
import a_spring的bean依赖注入.beanThree.BeanThree;
import a_spring的bean依赖注入.beanTwo.BeanTwo;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得依赖的bean的方法
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =
				//方法中的资源载入文件可以使用通配符 表示一次性加入多个资源 具体见 m
				new ClassPathXmlApplicationContext("a_spring的bean依赖注入/bean*.xml");
		//使用绝对路径获得bean的方法
//		ApplicationContext apt =
//				new FileSystemXmlApplicationContext("./a_spring的bean依赖注入/bean.xml");
		
		//！！！！---注意 spring框架的获得依赖注入的bean对象其实是使使用工厂方法生成的本质上其实是一个单例模式
		BeanTwo beanTwo = applicationContext.getBean("beantwo",BeanTwo.class);
		System.out.println(beanTwo.toString());
		BeanOne beanone = applicationContext.getBean("beanone",BeanOne.class);
		System.out.println(beanone.getBeanTwo().toString());
		//！！--不管是用什么方法在spring框架中除了使用
		BeanThree beanThree = (BeanThree)applicationContext.getBean("beanthree");
		beanThree.say();
		BeanOne beanOne2 = applicationContext.getBean("beanoneTT", BeanOne.class);
		System.out.println(beanone.getString().equals(beanOne2.getString()));
		//!!----spring 这个方法将会返回 bean的别名称数组
		@SuppressWarnings("unused")
		String[] stirngs = applicationContext.getAliases("beanthree");
		/*
		 * spring 容器方法  --- Beanfactory-最基本的接口 子接口 applicationContext
		 * appliaction接口的实现类有FileSystemXmlApplicationContext ClassPathXmlApplicationContext
		 * AnnoatatonConfigApplicationContext XmlWebApplicationContext 
		 * 机制：当容器调用spring的上述方法的时候将会实例化所有单利模式的方法 
		 * 
		 * 
		 * */
		/*
		 * 如果相对spring框架进行扩展就需要使用者个借口的实现类进行扩展
		 * 
		 * */
		@SuppressWarnings("unused")
		BeanFactory beanFactory = new BeanFactory() {
			public boolean isTypeMatch(String arg0, Class<?> arg1) throws NoSuchBeanDefinitionException {return false;}
			public boolean isTypeMatch(String arg0, ResolvableType arg1) throws NoSuchBeanDefinitionException {
				return false;}
			//查看这个bean是否是单例模式
			public boolean isSingleton(String arg0) throws NoSuchBeanDefinitionException {return false;}
			public boolean isPrototype(String arg0) throws NoSuchBeanDefinitionException {return false;}
			//获得这个bean的class类型
			public Class<?> getType(String arg0) throws NoSuchBeanDefinitionException {return null;}
			public <T> T getBean(Class<T> arg0, Object... arg1) throws BeansException {return null;}
			public Object getBean(String arg0, Object... arg1) throws BeansException {return null;}
			public <T> T getBean(String arg0, Class<T> arg1) throws BeansException {return null;}
			public <T> T getBean(Class<T> arg0) throws BeansException {return null;}
			public Object getBean(String arg0) throws BeansException {return null;}
			//返回当前bean的别名数组
			public String[] getAliases(String arg0) {return null;}
			//确认这个bean是否存在
			public boolean containsBean(String arg0) {return false;}
		};
		@SuppressWarnings("unused")
		ApplicationContext applicationContext2= new ApplicationContext() {
			//返回一个资源对象通常是 xml文件 resource 是spring的资源访问接口，通过这恶接口可以方便的方位磁盘上的资源文件
			public Resource getResource(String arg0) {return null;}
			public ClassLoader getClassLoader() {return null;}
			public Resource[] getResources(String arg0) throws IOException {return null;}
			public void publishEvent(Object arg0) {}
			public void publishEvent(ApplicationEvent arg0) {}
			//spring国际化支持方法 接口
			public String getMessage(String arg0, Object[] arg1, String arg2, Locale arg3) {return null;}
			public String getMessage(String arg0, Object[] arg1, Locale arg2) throws NoSuchMessageException {return null;}
			public String getMessage(MessageSourceResolvable arg0, Locale arg1) throws NoSuchMessageException {return null;}
			public BeanFactory getParentBeanFactory() {return null;}
			public boolean containsLocalBean(String arg0) {return false;}
			public boolean isTypeMatch(String arg0, Class<?> arg1) throws NoSuchBeanDefinitionException {return false;}
			public boolean isTypeMatch(String arg0, ResolvableType arg1) throws NoSuchBeanDefinitionException {return false;}
			public boolean isSingleton(String arg0) throws NoSuchBeanDefinitionException {return false;}
			public boolean isPrototype(String arg0) throws NoSuchBeanDefinitionException {return false;}
			public Class<?> getType(String arg0) throws NoSuchBeanDefinitionException {return null;}
			public <T> T getBean(Class<T> arg0, Object... arg1) throws BeansException {return null;}
			public Object getBean(String arg0, Object... arg1) throws BeansException {return null;}
			public <T> T getBean(String arg0, Class<T> arg1) throws BeansException {return null;}
			public <T> T getBean(Class<T> arg0) throws BeansException {return null;}
			public Object getBean(String arg0) throws BeansException {return null;}
			public String[] getAliases(String arg0) {return null;}
			public boolean containsBean(String arg0) {return false;}
			public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> arg0) throws BeansException {return null;}
			public <T> Map<String, T> getBeansOfType(Class<T> arg0, boolean arg1, boolean arg2) throws BeansException {return null;}
			public <T> Map<String, T> getBeansOfType(Class<T> arg0) throws BeansException {return null;}
			public String[] getBeanNamesForType(Class<?> arg0, boolean arg1, boolean arg2) {return null;}
			public String[] getBeanNamesForType(Class<?> arg0) {return null;}
			public String[] getBeanNamesForType(ResolvableType arg0) {return null;}
			public String[] getBeanNamesForAnnotation(Class<? extends Annotation> arg0) {return null;}
			public String[] getBeanDefinitionNames() {return null;}
			public int getBeanDefinitionCount() {return 0;}
			public <A extends Annotation> A findAnnotationOnBean(String arg0, Class<A> arg1)
					throws NoSuchBeanDefinitionException {return null;}
			public boolean containsBeanDefinition(String arg0) {return false;}
			public Environment getEnvironment() {return null;}
			public long getStartupDate() {return 0;}
			public ApplicationContext getParent() {return null;}
			public String getId() {return null;}
			public String getDisplayName() {return null;}
			public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {return null;}
			public String getApplicationName() {return null;}
		};
	}
}
