package c_spring_applicationContext的事件机制.applicationEventListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

import c_spring_applicationContext的事件机制.applicationEvent.MyApplicationEvent;

public class MyApplicationListener implements ApplicationListener<ApplicationEvent>{
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		if (arg0 instanceof MyApplicationEvent){
			((MyApplicationEvent) arg0).say();
		}
		//指的是xml文件加载完成并且可用后发出的事件
		if (arg0 instanceof ContextRefreshedEvent){
			((MyApplicationEvent) arg0).say();
		}
		//当ConfigurableApplicationContext 接口的start（）方法的时候触发这个方法 
		if (arg0 instanceof ContextStartedEvent){
			((MyApplicationEvent) arg0).say();
		}
		//当ConfigurableApplicationContext 接口的close（）方法的时候触发这个方法 
		if (arg0 instanceof ContextClosedEvent){
			((MyApplicationEvent) arg0).say();
		}
		//当ConfigurableApplicationContext 接口的stop（）方法的时候触发这个方法 
		if (arg0 instanceof ContextStoppedEvent){
			((MyApplicationEvent) arg0).say();
		}
		//requestHandledEvent web相关的事件 只能使用 dispatcherServlet的web应用当中 当用户请求结束的时候将会自动触发
		//
	}

}
