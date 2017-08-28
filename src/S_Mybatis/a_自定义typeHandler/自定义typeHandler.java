package S_Mybatis.a_自定义typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
//!--注意若果使用了注解就可以在配置文件中使用pagexx的属性而不用使用typeHandler属性
@MappedTypes({String.class})			//定义数据库映射的的java属性 指定那些类型将会被拦截
@MappedJdbcTypes(JdbcType.VARCHAR)		//定义数据库映射数据库的类型
//当使用自定义typeHandle的时候需要实现这个接口
//!---在mapping文件中需要显示的注册使用的tylehandle 并且在mybatis的配置文件(和mapping文集不同)文件中个必须进行注册
public class 自定义typeHandler implements TypeHandler<String>{
	public String getResult(ResultSet arg0, String columeName) throws SQLException {return null;}
	public String getResult(ResultSet arg0, int index) throws SQLException {return null;}
	public String getResult(CallableStatement arg0, int arg1) throws SQLException {return null;}
	public void setParameter(PreparedStatement arg0, int arg1, String arg2, JdbcType arg3) throws SQLException {}}