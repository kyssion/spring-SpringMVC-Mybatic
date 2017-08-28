package h_Bean的生命周期;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//使用bean的生命周期配置 - 注意bean的生命周期只是针对单例模式下的bean对象因为对于非单例模式 spring框架只进行创建而不管其他的用途
//所以spring框架对非单利模式不进行生命周期的检测
//InitializingBean接口表示bean对象在全部的依赖关系都被设置之后将会被自动的进行调用
public class MyBean implements InitializingBean,DisposableBean{
	//接口中定义的初始化方法
	public void afterPropertiesSet() throws Exception {}
	//接口中定义的销毁方法
	public void destroy() throws Exception {}
	//配置文件中定义的初始化方法
	public void init(){}
	//配置文件中定义的销毁方法
	public void Mydestroy(){}
	//这些方法的调用顺序是先调用接口的方法再掉用配置文件中的方法
	
}
