package t_Spring和mybatis进行整合;

import S_Mybatis.z_z_MyBatis实例.javabean.BeanOne;

public interface Myinterface {
	public BeanOne getBeanOne();
	public int insertOne(BeanOne bean);
	public int deleteOne(BeanOne bean);
}
