package S_Mybatis.b_自定义工厂方法;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
//定义工厂方法感觉使用反射了再说吧暂时不会
public class Myfactory extends DefaultObjectFactory{
	private static final long serialVersionUID = 1L;
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		return super.create(type, constructorArgTypes, constructorArgs);
	}
	public <T> T create(Class<T> type) {
		return super.create(type);
	}
	public <T> boolean isCollection(Class<T> type) {
		return super.isCollection(type);
	}
	protected Class<?> resolveInterface(Class<?> arg0) {
		return super.resolveInterface(arg0);
	}
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}
}
