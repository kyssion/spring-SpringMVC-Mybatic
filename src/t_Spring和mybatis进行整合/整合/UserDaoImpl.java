package t_Spring和mybatis进行整合.整合;

import S_Mybatis.z_z_MyBatis实例.javabean.BeanOne;
import t_Spring和mybatis进行整合.Myinterface;

//这个是真正的DAO层进行数据库的操作---需要使用需要在数据数据库中进行配置-使用单例模式
public class UserDaoImpl extends BaseDaoImpl implements Myinterface{

	@Override
	public BeanOne getBeanOne() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int insertOne(BeanOne bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(BeanOne bean) {
		// TODO Auto-generated method stub
		return 0;
	}


}
