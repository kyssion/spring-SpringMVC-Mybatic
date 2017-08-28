package i_spring框架出处理单例模式下的非单例成员.使用接口;

import i_spring框架出处理单例模式下的非单例成员.使用接口.BeanTwo;

public abstract class BeanOne implements Fatherbean{
	@SuppressWarnings("unused")
	private BeanTwo beanTwo;
	public abstract BeanTwo getBeanTwo();
	public void say(){
		getBeanTwo().say();
	}
	public void setBeanTwo(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
}
