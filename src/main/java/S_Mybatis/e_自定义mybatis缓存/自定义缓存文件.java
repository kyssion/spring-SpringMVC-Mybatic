package S_Mybatis.e_自定义mybatis缓存;

import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
//实现自定义的缓存文件必须实现的接口
public class 自定义缓存文件  implements Cache{

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void putObject(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object removeObject(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
