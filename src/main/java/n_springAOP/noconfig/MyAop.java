package n_springAOP.noconfig;
//定义切面类

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//使用这个注解表明这个类是一个切面类 用来给其他的一些类进行增强处理
//spring的aop主要用来增强方法
@Component//注意在不使用配置文件的时候要进行aop时候必须使用这条注解将所需要的方法放进spring容器中
@Aspect
public class MyAop implements Ordered{
	//aop增强表示在这个方法调用之前进行处理的过程
	//！！！注意在切入的点上还可以添加一个&&args(one,two)或者&&args(one,two,..)-前者表示匹配存在两个参数的方法并且讲参数传入进来-后一个表示匹配两个参数及其以上的方法
	@Before(value="execution(* n_springAOP.noconfig.aopbeanOne.*.*(..))&&args(one,two)")
	public void methodForBefore(String one ,String two){
		System.out.println("i am is aop before"+one+two);
	}
	//在aop增强的方法返回后进行的操作 returning 属性将会被动态的添加到Object参数中
	//这里使用了定义切入点方法 切人的函数在必要的时候可以是全限定名称
	@AfterReturning(returning="returning",pointcut="myPintCut()")
	public void methodForAfterReturning(Object returning){
		System.out.println("this is afterReturning return is "+returning);
	}
	//这个增强表示在aop的方法抛出异常之后进行调用的方法  throwing 的属性将会动态的添加进ext参数中
	@AfterThrowing(throwing="ext" ,value="execution(* n_springAOP.noconfig.aopbeanOne.*.*(..))")
	public void methodAfterThrowing(Throwable ext){
		
	}
	//这个增强表示在框架的执行过程中进行增强处理 之一使用Around 运行时增强的时候第一个参数必须是ProceedingJoinPoin类型
	//当调用ProceedingJoinPoint参数的proceed()方法的时候才会动态的调用需要增强的方法 里面的参数可以传递一个object[]的对象表示相关的调用方法的参数
	//这个参数存在一个getArgs方法 返回一个 object[] 表示调用时候传递进来的参数
	//这个增强可以出处理增强方法处理的时机 
	@Order(1)
	@Around(value="execution(* n_springAOP.noconfig.aopbeanOne.*.*(..))")
	public String methodForAround(ProceedingJoinPoint jp) throws Throwable{
		Object[] oo=jp.getArgs();		//返回调用的时候传递进来的参数
		jp.getTarget();					//返回进行aop增强的原始类
		jp.getTarget();					//返回进行aop增强的原始类
		System.out.println("This is Around begin....");
		String a=(String) jp.proceed(oo);
		System.out.println("this is Around end.....");
		return a;
	}
	//当多个切面作用在一个方法上的时候使用这个方法将会返回一优先级数值越小优先级高
	//除此之外还能使用注解定义优先级--使用继承接口的方法只是对全局进行定义的
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	@After("execution(* n_springAOP.noconfig.aopbeanOne.*.*(..))")
	public void MethodAfter(){
		System.out.println("this is after");
	}
	//切入点的使用相当的繁杂所以我们使用函数表示切入点 -详细情况见上面的afterReturning方法
	@Pointcut(value="execution(public * n_springAOP.noconfig.aopbeanOne.*.*(..))")
	public void myPintCut(){}
	//  execution(modifier-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
	// modifier-pattern-指定方法的修饰符(public等) 支持通配符 可省略
	// ret-type-pattern -- 返回值类型 支持通配符
	//declaring-type-pattern- 方法所属的全限定类名称 可以使用通配可省略
	// name-pattern 方法的名称 可使用通配符*
	//(param-pattern) 表示接受的形参列表 可以使用 *-匹配一个参数 ..匹配多个参数 或者使用基本类型
	//表达式的扩展属性 	args 指定参数是指定类型的
	//					target 指定目标对象是指定类型的
	//主属性和扩展属性的链接符 && 同时满足匹配 || 只满足一个或者多个匹配 ! 不满足匹配					
}
