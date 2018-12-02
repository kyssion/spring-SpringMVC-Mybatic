package c_spring_applicationContext的事件机制.applicationEvent;

import org.springframework.context.ApplicationEvent;
//实现spring相应首先要进行spring event事件的注册
//这个方法只是一个封装器-用来将事件进行封装通过接口传递到 实现类中 然后在发出事件
public class MyApplicationEvent extends ApplicationEvent{
	private static final long serialVersionUID = 1L;
	Object object =null;
	//注意这里的第一个参数其实没有什么用就是为了个事件一个参数进行生成一个标号 传递过来的source将会在使用后变成空值
	public MyApplicationEvent(Object source,String string) {
		super(source);
		// TODO Auto-generated constructor stub
		this.object=string;
		System.out.println(object.toString());
	}
	public void say(){
		if(this.object!=null){
			System.out.println(object.toString());
		}
		else{
			System.out.println("this object is Null!!");
		}
	}
}
