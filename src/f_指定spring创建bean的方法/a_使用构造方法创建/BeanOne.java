package f_指定spring创建bean的方法.a_使用构造方法创建;

public class BeanOne{
	String string;
	public BeanOne(String string) {
		// TODO Auto-generated constructor stub
		this.string= string;
	}
	public void say() {
		System.out.println(string);
	}
	
}
