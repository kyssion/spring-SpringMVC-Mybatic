package S_Mybatis.z_z_MyBatis实例.javabean;

import java.util.List;

public class BeanOne {
	private List<BeanTwo> list=null;
	public List<BeanTwo> getList() {
		return list;
	}
	public void setList(List<BeanTwo> list) {
		this.list = list;
	}
	public BeanOne(String name,Integer age){
		this.name=name;
		this.age=age;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BeanOne() {
		// TODO Auto-generated constructor stub
	}
	public String name;
	public int age;
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
