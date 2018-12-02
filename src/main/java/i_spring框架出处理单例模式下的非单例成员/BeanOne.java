package i_spring框架出处理单例模式下的非单例成员;

public abstract class BeanOne {
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
