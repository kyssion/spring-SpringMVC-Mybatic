package a_spring的bean依赖注入.beanfour;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import a_spring的bean依赖注入.beanThree.BeanThree;
import a_spring的bean依赖注入.beanTwo.BeanTwo;

public class BeanFour {
	private BeanTwo beanTwo;
	private String string;
	private BeanThree beanThree;
	private List<String> list;
	private Map<String, String > map;
	private Set<Object> set;
	/**
	 * 
	 */
	private Properties properties;
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Set<Object> getSet() {
		return set;
	}
	public void setSet(Set<Object> set) {
		this.set = set;
	}
	public BeanThree getBeanThree() {
		return beanThree;
	}
	public void setBeanThree(BeanThree beanThree) {
		this.beanThree = beanThree;
	}
	public BeanTwo getBeanTwo() {
		return beanTwo;
	}
	public void setBeanTwo(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
}
