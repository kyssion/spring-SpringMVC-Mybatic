package l_spring零配置.beanOne;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import l_spring零配置.beantwo.BeanTwo;

//使用spring零配置所需有使用的bean标记注解 当不使用参数的时候表示默认的bean id就是类名称首字母小写
//can pe en te
@Component//表示一个普通的bean类 can po neng te   
			//@Controller//表示一个控制器组件类
			//@Service//表示一个业务逻辑组件类
			//@Repository//标注一个dao组件类 rui po ze chui
@Scope("prototype")		//---设置bean对象使用的作用域
@DependsOn({"beanTwo"})//相当于xml文件中配置的dependson属性表示依赖关系
@Lazy(true)//表示函数是否进行延迟加载
public class BeanOne {
	//rui zuo si
	@Resource(name="beanTwo")//使用这个注解相当于在框架中使用ref
	public BeanTwo beanTwo;
	@PostConstruct//进行初始化的方法这个方法将会在函数进行初始化后进行调用
	public void say(){
		this.beanTwo.say();
	}
	@PreDestroy//相当于删除的方法在使用这个方法的时候将会在销毁的时候进行回调
	public void methed(){
		
	}
	@Autowired//将方法中所有的参数都默认使用bytype模式进行自动的依赖注入  找不到type对应的bean或者存在多个bean都会抛出异常
	@Qualifier("beanTwo")//用来和autowired连用 表示使用自动转配并且指定相关的bean斤进行自动的装配
	public void method(BeanTwo beanTwo){}
	
}
