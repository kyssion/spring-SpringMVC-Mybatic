package d_bean获取spring容器和自身的id.bean获得容器属性;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanOne implements BeanFactoryAware,ApplicationContextAware{
	//使用 beanfactoryAware 接口将会在 spring框架在进行 依赖注入的时候进行回掉从而让这个方法能够自动的将spring容器加入进方法中
	//使用ApplicationContextAware方法 这个方法同上只不过这个方法加入的是applicationcontext接口
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println(arg0.toString());
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println(arg0.toString());
	}
}
