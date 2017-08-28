package n_springAOP.hasconfig;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAopHasConfig {
	public void before(String one,String two){
		System.out.println("this is before...." + one+two);
	}
	public void afterReturn(String returning){
		System.out.println("this is afterurning ,return is "+returning);
	}
	public void afterthrow(){
		System.out.println("this is throwing");
	}
	public String around(ProceedingJoinPoint jPoint) throws Throwable{
		Object[] objects = jPoint.getArgs();
		String string = (String) jPoint.proceed(objects);
		return string;
	}
	public void after(String one,String two){
		System.out.println("this is after"+one+two);
	}
}
