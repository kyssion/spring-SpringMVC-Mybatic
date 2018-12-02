package f_指定spring创建bean的方法.b_使用工厂方法创建;

public class 实例工厂方法 {
	//实例工厂方法的意思是 在bean中需要进行相关的配置
	public A_fatherForBean getBean(String string){
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
