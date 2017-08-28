package d_bean获取spring容器和自身的id.bean获得自身的id;

import org.springframework.beans.factory.BeanNameAware;

public class BeanTwo implements BeanNameAware{
	@Override
	public void setBeanName(String arg0) {
		//这个string 就是bean的名字
	}
}
