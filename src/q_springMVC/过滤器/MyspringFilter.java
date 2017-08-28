package q_springMVC.过滤器;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//实现自定义spring拦截器必须继承的接口HandlerINterceptor  但是如果要使用这个拦截器需要将这个拦截器注册到相应的springmvc的配置文件(不是web.xml)中去
public class MyspringFilter implements HandlerInterceptor{
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		//请求结束的时候调用的方法 object类的效果和上面的的相同 Exception表示抛出的异常
		
	}

	@Override//接受的拦截之后返回的参数
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override//这个方法表示是否见当前的请求拦截下来 true表示不false 拦截  参数中有一个object 的类i表示将要进行拦截对象的实例
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
