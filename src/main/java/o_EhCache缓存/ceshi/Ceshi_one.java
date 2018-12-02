package o_EhCache缓存.ceshi;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
@Component
// ,condition="#name=li"(使用一个spel进行bool表达式  当为true的时候才进行缓存)，unless="#name!=li"(使用一个spel 进行bool表达式判断 true不进行缓存)*/
//@CachePut  一直进行 缓存

//@Cacheable 方法可以修饰类或者属性  1. 修饰类表示调用该类的任何实例都要进行缓存 2.修饰方法表示只用当程序调用方法的时候才进行缓存
//spring框架使用@Cacheable(value="xxx",key="#yyy",condition="#zzz<9",unless="#nnn>10")
//value- 表示使用那个缓冲区
//key- 表示使用SpEl 表示指定的缓存key
//condition - 使用SpEl表达式,返回一个boolean表达式 当使用true的时候才会 返回返回值
//unless - 使用SpEl表达式,但返回为true 不进行返回

public class Ceshi_one implements Z{//面向接口编程
	@Cacheable(value="users",key="#name")//
	public Javabean getone(String name,String password){
		return new Javabean(name,password);
	}
	@Cacheable(value="users",key="#name")
	public Javabean gettwo(String name,String password){
		return new Javabean(name,password);
	}
	//当为true 时才清空  key 清空指定缓存的key
	@CacheEvict(value="users",allEntries=true)
	//@CacheEvict(value="users",allEntries=true,beforeInvocation=true,key,condition)
	//value 			必须属性选择清空的缓存区		 
	//allEntries 		是否清空所有的缓冲		使用boolean类型当true的时候表示清空整个缓冲区	 	
	//beforeIncocation 	是否在执行前进行清空缓存	boolean类型
	//condition 		使用spsl表达式    当表达式为true的时候才使用清楚策略
	public void delectall(){  
		
	}
}