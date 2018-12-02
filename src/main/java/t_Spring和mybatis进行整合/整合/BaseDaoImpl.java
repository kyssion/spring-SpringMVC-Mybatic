package t_Spring和mybatis进行整合.整合;

import org.mybatis.spring.SqlSessionTemplate;
//实现一个父类用于给UserDaoImpi进行集成
public class BaseDaoImpl {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
}
