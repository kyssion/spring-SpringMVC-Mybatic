package k_spring后置处理器.bean后处理器;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Beanhouchuliqi implements BeanPostProcessor{
	
	//在bean 进行初始化之前就会被调用 arg0使用的是系统将执行后处理的bean示例 arg1是bean的id 返回处理后的bean实例
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println(arg0+"this is before");
		return arg0;
	}
	//在bean初始化完成后调用 其余的和上面的相同
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println(arg0+"*"+arg1+"this is after");
		return arg0;
	}

	
}
