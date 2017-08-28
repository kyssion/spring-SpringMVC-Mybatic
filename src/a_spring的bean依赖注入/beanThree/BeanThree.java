package a_spring的bean依赖注入.beanThree;

import a_spring的bean依赖注入.beanTwo.BeanTwo;

public class BeanThree {
	public BeanThree(){
		
	}
	private BeanTwo beanTwo;
	String string ;
	public BeanTwo getBeanTwo() {
		return beanTwo;
	}
	public void setBeanTwo(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
	public BeanThree(BeanTwo beanTwo ,String hehe) {
		// TODO Auto-generated constructor stub
		this.beanTwo=beanTwo;
		this.string=hehe;
	}
	public void say(){
		System.out.println(this.beanTwo+"***"+string);
	}
}
