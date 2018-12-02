package f_指定spring创建bean的方法.b_使用工厂方法创建;

public class C_BeanTwo implements A_fatherForBean{
	//注意类在使用的时候必须加上相关的get方法才能让spring框架实现自动的注入
	String string;
	@Override
	public void say() {
		System.out.println("this is bean Two"+string);
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}

}
