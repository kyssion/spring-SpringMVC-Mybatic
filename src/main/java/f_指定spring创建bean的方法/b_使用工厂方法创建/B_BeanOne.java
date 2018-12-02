package f_指定spring创建bean的方法.b_使用工厂方法创建;

public class B_BeanOne implements A_fatherForBean{
	String string;
	@Override
	public void say() {
		System.out.println("this is bean one"+string);
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}

}
