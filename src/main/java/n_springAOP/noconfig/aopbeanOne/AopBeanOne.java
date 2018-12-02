package n_springAOP.noconfig.aopbeanOne;

import org.springframework.stereotype.Component;

import n_springAOP.noconfig.FatherBean;
@Component
public class AopBeanOne implements FatherBean{
	//--这里面 左面的小图标消失的启示-当实现接口的时候 spring框架自动使用jdk代理,没有使用接口的时候使用cglib代理
	//当使用使用了接口的时候aop增强的不是接口中的方法会导致spring的插件不识别但是spring的代码没有出现错误 说明是spring框架中使用的
	//了自动的判断方法
	@Override
	public String say(String one,String two){
		System.out.println("i'am aopbeanone");
		return "beanOneReturn"+one+two;
	}
} 	                           
