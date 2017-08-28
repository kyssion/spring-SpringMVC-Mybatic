package S_Mybatis.z_javabean;

import org.apache.ibatis.type.Alias;

@Alias("javabean.myparent")//注解定义个别名会覆盖<typeAliases>定义的别名。
public class MyjavaBean {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
