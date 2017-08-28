package e_spring依赖注入使用配置类方式.bean配置类;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//这个注解将会动态的声明一个类作为配置类

import e_spring依赖注入使用配置类方式.beanOne.BeanOne;
@Configuration
public class Bean配置类 {
	@Value("xxxx")//相当于xml文件中的value-作用定义一个名称叫做persionName的变量置位xxxx
	String persionName;
	@Bean(name="beanOne")
	public BeanOne beanOne(){
		BeanOne beanOne = new BeanOne();
		return beanOne;
	}
	//修饰返回类的方法的注解还有
	/*  --相关属性对应的方法和bean.xml中的相关属性的 
	 * scope
	 * Lazy
	 * dependsOn
	 * 
	 * */
}
