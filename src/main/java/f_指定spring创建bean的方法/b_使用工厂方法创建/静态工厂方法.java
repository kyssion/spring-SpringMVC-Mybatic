package f_指定spring创建bean的方法.b_使用工厂方法创建;

public class 静态工厂方法 {
	//在使用的时候时候直接使用相关的类不需要使用spring容器对他进行实例化 注意参数是static
	public static A_fatherForBean getBean(String string){
		if (string.equals("B")==true){
			B_BeanOne b_BeanOne = new B_BeanOne();
			b_BeanOne.setString("哈哈B");
			return b_BeanOne;
		}else{
			C_BeanTwo c_BeanTwo = new C_BeanTwo();
			c_BeanTwo.setString("哈哈C");
			return c_BeanTwo;
		}
	}
}
