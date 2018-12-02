package a_spring的bean依赖注入.beanOne;

import a_spring的bean依赖注入.beanTwo.BeanTwo;

public class BeanOne {
	private BeanTwo beanTwo;
	private String  string;
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public BeanTwo getBeanTwo() {
		return beanTwo;
	}

	public void setBeanTwo(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
	public void say(){
		System.out.println("This is beanTwo");
	}
}
