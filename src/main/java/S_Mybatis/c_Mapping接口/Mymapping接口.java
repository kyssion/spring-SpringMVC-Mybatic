package S_Mybatis.c_Mapping接口;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import S_Mybatis.z_javabean.MyjavaBean;

public interface Mymapping接口 {
	public MyjavaBean getJavaBean(int age);
	//与 xml 文件的相应的属性相会对应 返回值对性 resultMap,String name 对应paramertype,函数名对应id
	public MyjavaBean select_one_for_child(String name);
	public List<MyjavaBean> select_some_child(Map<String, Integer> age);//当有多个参数需要传递的时候记得使用封装的方法  系统会自动的应用get或者其他的方法获得参数
	//等同于 sqlsession.selectList("xxxxx",map);.....
	public List<MyjavaBean> select_some_child_by_zhujie(@Param("age")Integer age);//注解表示使用自己定义的param参数在映射文件中使用ognl表达式取出来
	public Integer insert_a_child(MyjavaBean child);//当使用
}
